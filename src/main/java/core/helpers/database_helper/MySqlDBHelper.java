package core.helpers.database_helper;

import static core.helpers.Const.*;

import java.sql.SQLException;

public class MySqlDBHelper extends DatabaseAttributes implements DatabaseHelper{
    public void setConnection(String dbConnectionUrl,
                              String dbUserName, String dbPassword) throws SQLException, ClassNotFoundException{
        super.setDatabaseConnection(mysqldriver, dbConnectionUrl, dbUserName, dbPassword);
    }
}


