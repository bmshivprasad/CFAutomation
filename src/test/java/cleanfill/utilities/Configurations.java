package cleanfill.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public interface Configurations {

    Properties configProp = new Properties();
    ExcelUtils excelUtils = new ExcelUtils();

    String CURRENT_DATE_TIME = new SimpleDateFormat("MMMddyyyy_hhmmss").format(new Date());

    String TEST_DATA_LOCATION = getProjectDir() + File.separator + "Resources";
    String TEST_DATA = "CFL_Data";
    String CREATE_BATCH = "Create Batch";
    String CREDENTIALS = "Credentials";
    String FILE_LOCATION = getProjectDir() + File.separator + "Resources" + File.separator + "Files";
    String CONFIGURATION_PATH = getProjectDir() + File.separator + "Configuration" + File.separator + "config.properties";

    String BASE_URL = getProperty("clean_fill_url");

    String SOURCE_USERNAME = excelUtils.getTestData(TEST_DATA, CREDENTIALS, ExcelColumns.SOURCE_SITE_USERNAME, 1);
    String SOURCE_PASSWORD = excelUtils.getTestData(TEST_DATA, CREDENTIALS, ExcelColumns.SOURCE_SITE_PASSWORD, 1);

    String RECEIVER_USERNAME = excelUtils.getTestData(TEST_DATA, CREDENTIALS, ExcelColumns.RECEIVING_SITE_USERNAME, 1);
    String RECEIVER_PASSWORD = excelUtils.getTestData(TEST_DATA, CREDENTIALS, ExcelColumns.RECEIVING_TYPE_PASSWORD, 1);

    String FILE_JPEG = FILE_LOCATION + File.separator + "QA_JPEG.jpg";
    String FILE_PNG = FILE_LOCATION + File.separator + "QA_PNG.png";
    String FILE_DOC = FILE_LOCATION + File.separator + "QA_DOC.doc";
    String FILE_PDF = FILE_LOCATION + File.separator + "QA_PDF.pdf";
    String FILE_10MB = FILE_LOCATION + File.separator + "QA_10MB.jpg";
    String FILE_EXTRA = FILE_LOCATION + File.separator + "QA_EXTRA.jpg";
    String FILE_EXTRA_2 = FILE_LOCATION + File.separator + "QA_EXTRA_2.jpg";

    String BROWSER = getProperty("browser");
    String PROJECT_DIR = getProjectDir();

    int IMPLICIT_WAIT = Integer.parseInt(getProperty("default_wait"));
    long WEBDRIVER_WAIT = Long.parseLong(getProperty("webdriver_wait"));

    static String getProjectDir() {
        return System.getProperty("user.dir");
    }

    static String getProperty(String key) {
        InputStream input = null;
        try {
            input = new FileInputStream(CONFIGURATION_PATH);
            configProp.load(input);
        } catch (Exception e) {
            System.out.println("Error occurred while reading property file.  -  " + CONFIGURATION_PATH);
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
