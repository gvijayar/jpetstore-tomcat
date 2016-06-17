# JPetstore on OpenShift

This is a reference application for deploying the JPetstore application on the JBoss Web Server (Tomcat 8) image on OpenShift. It leverages common web application frameworks including Spring, IBatis (Object Relational Mapping Framework) and Struts. This example is based on the following example and has been modified to work in an OpenShift environment.

https://src.springframework.org/svn/spring-samples/jpetstore/trunk/org.springframework.samples.jpetstore/

This application has also been modified to work with an external RDBMS - at the moment it has only been tested with the Postgres Database, but in the future it will be updated to work with a variety of databases. 

Please follow these steps to deploy this application on an OSE environment.

1. Create a new OpenShift Project
<li>oc new-project jpetstore --description="jpetstore on jws 8" --display-name="JPetstore application deployed on a JWS/Tomcat image connecting to a remote database" 

2. Now install the application template in the project namespace. This template includes the environment specific database connection details which will be collected at runtime and subsequently used to build the runtime configuration.
<li>oc create -f https://raw.githubusercontent.com/gvijayar/jpetstore-tomcat/master/jpetstore-ose3-externaldb.json

3. Create the application by passing in the necessary database connection information as environment variables. These variables will be used by the S2I process to dynamically build the configuration from the Tomcat pod to connect to the external database.
<li>oc new-app jws3-tomcat8-postgresql-custom-s2i-p DB_HOST=[DATABASE_HOST],DB_PORT=[DATABASE_PORT],DB_DATABASE=[DATABSE_NAME],DB_USERNAME=[USERNAME],DB_PASSWORD=[PASSWORD]

This application has also been setup to automatically initialize and configure the Postgres database on load - so no additonal database configuration is necessary.

