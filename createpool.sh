asadmin create-jdbc-connection-pool --datasourceclassname=org.apache.derby.jdbc.ClientDataSource --restype=javax.sql.DataSource --property portNumber=1527:password=APP:user=APP:serverName=localhost:databaseName=RIMSDB:connectionAttributes=\;create\\=true RIMSPool
asadmin ping-connection-pool RIMSPool
asadmin create-jdbc-resource --connectionpoolid RIMSPool jdbc/rims