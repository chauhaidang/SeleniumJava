package core.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MavenPropertiesReader {
    private static InputStream in = MavenPropertiesReader.class.getResourceAsStream("/maven.properties");
    private static Properties mavenProps = new Properties();

    public static String getMavenPropertyValue(String key) {
        try {
            mavenProps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mavenProps.getProperty(key);
    }
}
