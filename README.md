# JPetstore on OpenShift

This is a reference application for deploying the JPetstore application on the JBoss Web Server (Tomcat 8) image on OpenShift. This example is based on the following example and has been modified to work in an OpenShift environment.

https://src.springframework.org/svn/spring-samples/jpetstore/trunk/org.springframework.samples.jpetstore/

This application has also been modified to work with an external RDBMS - at the moment it has only been tested with the Postgres Database, but in the future it will be updated to work with a variety of databases. 

Please follow these steps to deploy this application on an OSE environment.

1. oc new-project jpetstore --description="jpetstore on jws 8" --display-name="JPetstore application deployed on a JWS/Tomcat image connecting to a remote database" 


