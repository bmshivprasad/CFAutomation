package cleanfill.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public interface Configurations {

    Properties configProp = new Properties();

    String currentDateTime = new SimpleDateFormat("MMMddyyyy_hhmmss").format(new Date());

    String TEST_DATA_LOCATION = getProjectDir() + "\\src\\test\\java\\gfl\\testData";

    String configurationPath = getProjectDir() + "/Configuration/config.properties";

    String BASE_URL = getProperty("clean_fill_url");

    String SOURCE_USERNAME = getProperty("source_site_username");
    String SOURCE_PASSWORD = getProperty("source_site_password");

    String RECEIVER_USERNAME = getProperty("receiving_site_username");
    String RECEIVER_PASSWORD = getProperty("receiving_site_password");

    String BROWSER = getProperty("browser");
    String PROJECT_DIR = getProjectDir();

    String IMPLICIT_WAIT = getProperty("default_wait");
    String WEBDRIVER_WAIT = getProperty("webdriver_wait");

    static String getProjectDir() {
        return System.getProperty("user.dir");
    }

    static String getProperty(String key) {
        InputStream input = null;
        try {
            input = new FileInputStream(configurationPath);
            configProp.load(input);
        } catch (Exception e) {
            System.out.println("Error occurred while reading property file.  -  " + configurationPath);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return configProp.getProperty(key);
    }

}
