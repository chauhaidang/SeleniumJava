package core.helpers;

public class Const {
    public static final String MAIN_PATH = "src/main/java";
    public static final String TEST_PATH = "src/test/java";
    public static final String TEST_RESOURCE_PATH = "src/test/resources";
    public static final String MAIN_RESOURCE_PATH = "src/main/resources";

    //Locator identifier
    public static final String XPATH = ".xpath";
    public static final String CSS = ".css";
    public static final String ID = ".id";

    //Test account
    public static final String MAIL_TEST = "chauhaidang1testing@gmail.com";
    public static final String PASSWORD_TEST = "123456789";

    //Mail server
    public static final String server = "smtp.gmail.com";
    public static final String from = MAIL_TEST;
    public static final String password = "";

    public static final String[] to = {"chauhaidang1@gmail.com"};
    public static final String subject = "Test Report";

    public static final String messageBody = "TestMessage";
    public static final String attachmentPath = "target/";
    public static final String attachmentName = "surefire-reports/html/extent.html";


    //SQL DATABASE DETAILS
    public static final String driver = "net.sourceforge.jtds.jdbc.Driver";
    public static final String dbConnectionUrl = "jdbc:jtds:sqlserver://localhost:porthere;DatabaseName=blahblah";
    public static final String dbUserName = "sa";
    public static final String dbPassword = "*******";

    //MYSQL DATABASE DETAILS
    public static final String mysqldriver = "com.mysql.jdbc.Driver";
    public static final String mysqluserName = "root";
    public static final String mysqlpassword = "123456";
    public static final String mysqlurl = "jdbc:mysql://localhost:3306/dangchau";

    //Env Properties
    public static final String IS_HEADLESS = "headless";
    public static final String BROWSER_NAME = "browserName";

}
