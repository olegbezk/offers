# offers

add to the Tomcat context.xml file 

<Resource name="jdbc/spring" auth="Container" type="javax.sql.DataSource"
		maxTotal="100" maxIdle="30" maxWaitMillis="10000" username="username"
		password="password" driverClassName="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/springtutorial" />

or create connection with apache.commons.dbcp.BasicDataSource 
