package Training.Collection;

import javax.xml.transform.Result;
import java.sql.*;

public class JDBCClass {
    public static void main(String[] args) throws SQLException {
        //JDBC is just like a driver program to execute sql command to the sql database (server) without using any sql client
        //We need to download database driver to use (.jar file)

        //Step to interact with database
        /**
         * 1. open connection
         * 2. create statement
         * 3. execute statement
         * 4. close connection
         */

        //Example for oracle jdbc connection
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/servicename", "username", "password");

        //Create statement object
        Statement statement = con.createStatement();
        String sqlQuery = "Select * From Book Where Book.id = 20";

        //Execute statement
        statement.execute(sqlQuery); //if sql statment is select, it will return data

        //Store data from query
        ResultSet rs = statement.executeQuery(sqlQuery);

        //I don't know the size of results so i use while
        // next() mostly check the condition of the next iteration whether it can be iterate or not
        while(rs.next()){
            //get value of each column in each iteration (row)
            int id = rs.getInt("column id");
            String name = rs.getString("name");

            System.out.println("id is: "+ id + " and name is: "  + name);
        }

        //Close connection
        con.close();
    }
}
