package org.mule.modules.elasticmuleevents.config;

import org.mule.api.annotations.components.Configuration;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.param.Default;

@Configuration(friendlyName = "Configuration")
public class ConnectorConfig {

	/**
     * Elastic Host
     */
    @Configurable
    @Default("52.201.237.3")
    private String host;

    /**
     * Elastic Port
     */
    @Configurable
    @Default("9300")
    private Integer port;
    
    /**
     * Elastic Index
     */
    @Configurable
    @Default("logstash-2016.04.08")
    private String index;
    
    /**
     * Elastic Type
     */
    @Configurable
    @Default("events")
    private String type;
    
    /**
     * Elastic Date Format
     */
    @Configurable
    @Default("yyyy-MM-dd'T'HH:mm:ssSZ")
    private String dateFormat;
    

    /**
     * Set Elastic host address
     *
     * @param Elastic host address
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Get Elastic host address
     */
    public String getHost() {
        return this.host;
    }

    /**
     * Set Elastic port
     *
     * @param Elastic port
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * Get Elastic port
     */
    public Integer getPort() {
        return this.port;
    }
    
    /**
     * Set Elastic index
     *
     * @param Elastic index
     */
    public void setIndex(String index) {
        this.index = index;
    }

    /**
     * Get Elastic index
     */
    public String getIndex() {
        return this.index;
    }
    
    /**
     * Set Elastic index type
     *
     * @param Elastic index type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get Elastic index type
     */
    public String getType() {
        return this.type;
    }
    
    /**
     * Set Elastic Date Format
     *
     * @param Elastic Date Format
     */
    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    /**
     * Get Elastic Date Format
     */
    public String getDateFormat() {
        return this.dateFormat;
    }
}