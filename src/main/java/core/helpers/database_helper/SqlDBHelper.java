package core.helpers.database_helper;

import java.sql.SQLException;

import static core.helpers.Const.driver;
import static core.helpers.Const.mysqldriver;

public class SqlDBHelper extends DatabaseAttributes implements DatabaseHelper {
    public void setConnection(String dbConnectionUrl,
                              String dbUserName, String dbPassword) throws SQLException, ClassNotFoundException{
        super.setDatabaseConnection(driver, dbConnectionUrl, dbUserName, dbPassword);
    }
}
