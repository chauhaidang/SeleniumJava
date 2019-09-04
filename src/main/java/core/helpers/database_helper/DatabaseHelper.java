package core.helpers.database_helper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface DatabaseHelper {
    void setConnection(String dbConnectionUrl, String dbUserName, String dbPassword) throws SQLException, ClassNotFoundException;
    List<String> getQuery(String query) throws SQLException;
    Connection getConnection();
    void closeConnection() throws Exception;
}
