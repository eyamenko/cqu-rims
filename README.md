# RIMS

Renting Information Management System JavaEE application

## Technologies used

* EJB
* JPA (EclipseLink)
* JSF
* PrimeFaces
* Twitter Bootstrap

## Prerequisites

* JDK 7
* GlassFish Server
* Apache Derby
* Maven

## Setup

Sample setup for GlassFish Server & Apache Derby

1. `$ asadmin start-domain`
2. `$ startNetworkServer`
3. `$ asadmin create-jdbc-connection-pool --datasourceclassname=org.apache.derby.jdbc.ClientDataSource --restype=javax.sql.DataSource --property portNumber=1527:password=APP:user=APP:serverName=localhost:databaseName=RIMSDB:connectionAttributes=\;create\\=true RIMSPool`
4. `$ asadmin ping-connection-pool RIMSPool`
5. `$ asadmin create-jdbc-resource --connectionpoolid RIMSPool jdbc/rims`
6. `$ mvn package`
7. `$ asadmin deploy target/rims.war`
