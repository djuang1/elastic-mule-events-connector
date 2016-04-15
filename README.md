# Elasticsearch Mule Events Connector

Anypoint Connector provides the ability to write events directly to Elasticsearch in a Mule Event specific format.

# Example Mule Event

`{  
   "application":"test-elk",
   "timestamp":"2016-04-14T12:42:51274-0500",
   "notificationType":"EventNotification",
   "action":"custom event",
   "resourceIdentifier":"test-elkFlow",
   "source":"test-elkFlow",
   "muleMessage":"Hello World!",
   "path":null,
   "annotations":null,
   "muleMessageId":"4f55dba0-0268-11e6-ad7d-acbc32b36e6b",
   "customEventProperties":null,
   "customEventName":null,
   "@version":"1",
   "@timestamp":"2016-04-14T12:42:51.274-0500",
   "host":"localhost",
   "type":"events"
}`

# Mule supported versions
Mule 3.5.x

# Elasticsearch supported versions
1.4+

# Installation 
For beta connectors you can download the source code and build it with devkit to find it available on your local repository. Then you can add it to Studio

For released connectors you can download them from the update site in Anypoint Studio. 
Open Anypoint Studio, go to Help → Install New Software and select Anypoint Connectors Update Site where you’ll find all avaliable connectors.

#Usage
For information about usage our documentation at http://github.com/djuang1/elastic-mule-events.

# Reporting Issues

We use GitHub:Issues for tracking issues with this connector. You can report new issues at this link http://github.com/djuang1/elastic-mule-events/issues.