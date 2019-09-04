package core.helpers.database_helper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAttributes {

    protected Connection con = null;

    protected void setDatabaseConnection(String driverClassName, String dbConnectionUrl,
                              String dbUserName, String dbPassword) throws SQLException, ClassNotFoundException {
        try {
            Class.forName(driverClassName);
            con = DriverManager.getConnection(dbConnectionUrl, dbUserName, dbPassword);

            if (!con.isClosed())
                System.out.println("Successfully connected to SQL server");

        } catch (Exception e) {
            System.err.println("Cannot connect to SQL database server");
            // monitoringMail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject+" - (Script failed with Error, Datamart database used for reports, connection not established)", TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
        }
    }

    public List<String> getQuery(String query) throws SQLException {

        //String Query="select top 10* from ev_call";
        Statement St = con.createStatement();
        ResultSet rs = St.executeQuery(query);
        List<String> values = new ArrayList<String>();
        while (rs.next()) {

            values.add(rs.getString(1));

        }
        return values;
    }


    public Connection getConnection() {
        return con;
    }

    public void closeConnection() throws Exception{
        con.close();
    }
}
