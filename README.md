servicesimulator
==============

Application that uses REST and SOAP services and works with Wiremock proxy.


Workflow
========

Start Wiremock server like standalone. 

java -jar wiremock-standalone-2.5.1.jar --port=9898 --enable-browser-proxying --record-mapping


To compile the entire project, run "mvn install".

To run the application, run "mvn jetty:run -Dhttp.proxyHost=localhost -Dhttp.proxyPort=9898" and open http://localhost:8080/servicesimulator

