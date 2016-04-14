
package org.mule.modules.elasticmuleevents.generated.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.elasticmuleevents.ElasticMuleEventsConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>ElasticMuleEventsConnectorProcessAdapter</code> is a wrapper around {@link ElasticMuleEventsConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.8.0", date = "2016-04-14T06:17:19-05:00", comments = "Build UNNAMED.2762.e3b1307")
public class ElasticMuleEventsConnectorProcessAdapter
    extends ElasticMuleEventsConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<ElasticMuleEventsConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, ElasticMuleEventsConnectorCapabilitiesAdapter> getProcessTemplate() {
        final ElasticMuleEventsConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,ElasticMuleEventsConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, ElasticMuleEventsConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, ElasticMuleEventsConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
