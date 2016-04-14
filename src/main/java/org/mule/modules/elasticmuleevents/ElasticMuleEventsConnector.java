package org.mule.modules.elasticmuleevents;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.mule.api.MuleEvent;
import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.param.Optional;
import org.mule.api.annotations.param.Payload;
import org.mule.modules.elasticmuleevents.config.ConnectorConfig;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Connector(name="elastic-mule-events", friendlyName="Elastic Mule Events")
public class ElasticMuleEventsConnector {

	protected transient Log logger = LogFactory.getLog(getClass());

    @Config
    ConnectorConfig config;

    /**
     * Log Mule Event
     *
     * @param eventName A name for the business event to track. Parameter is a String.
     * @param keyPerformanceIndicator Single field to track KPIs. Similar to Custom Business Events. Parameter is a String.
     * @return String value with the "_id" from Elastic
     */
    @Processor(friendlyName="Log Mule Event")
    public Object logMuleEvent(@Payload Object payload, @Optional String eventName, @Optional String keyPerformanceIndicator, MuleEvent event) {

    	SimpleDateFormat sdfTimestamp1 = new SimpleDateFormat(config.getDateFormat());    	
    	//Elastic specific date/time format
    	SimpleDateFormat sdfTimestamp2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    	
    	Date currentTimestamp = new Date();
    	
    	String json;
    	
		try {
			
			json = "{" +    					
					"\"application\":\"" + event.getMuleContext().getConfiguration().getId() + "\"," +
					"\"timestamp\":\"" + sdfTimestamp1.format(currentTimestamp) + "\"," +
			        "\"notificationType\":\"EventNotification\"," +
			        "\"action\":\"custom event\"," +
			        "\"resourceIdentifier\":\"" + event.getFlowConstruct().getName() + "\"," +	
					"\"source\":\"" + event.getFlowConstruct().getName() + "\"," +				
					"\"muleMessage\":\"" + payload + "\"," +
					"\"path\":null," +
					"\"annotations\":null," +
					"\"muleMessageId\":\"" + event.getMessage().getUniqueId() + "\"," +
					"\"customEventProperties\":\"" + keyPerformanceIndicator + "\"," +
			        "\"customEventName\":\"" + eventName + "\"," +    	        
			        "\"@version\":\"1\"," +
			        "\"@timestamp\":\"" + sdfTimestamp2.format(currentTimestamp) + "\"," +
			        "\"host\":\"" + InetAddress.getLocalHost().getHostName() + "\"," +
			        "\"type\":\"" + config.getType() + "\"" +
			    "}";
			
			Client client = new TransportClient();
    		((TransportClient) client).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(config.getHost()), config.getPort()));
    	
    		IndexResponse response = client.prepareIndex(config.getIndex(), config.getType())
        	        .setSource(json)
        	        .get();

        	client.close();
        	        	
        	if (response.isCreated()){
        		logger.info(response.getId());
        	} else {
        		logger.info("Event creation failed");
        	}
			
		} catch (UnknownHostException uhex) {
			uhex.printStackTrace();
		} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    	
    	return payload;
    }

    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
    }

}