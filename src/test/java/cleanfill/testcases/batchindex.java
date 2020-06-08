package cleanfill.testcases;

import cleanfill.PageObjects.cleanfillPage;
import cleanfill.base.EnhancedBaseClass;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

public class batchindex extends EnhancedBaseClass {

    public batchindex() {
        log4j = Logger.getLogger("NEW BATCH REQUEST");
    }

    public static int getRandomIntBetweenRange(int min, int max) {
        int x = (int)((Math.random() * ((max - min) + 1)) + min);
        return x;
    }
    @Test
    public void TC02_Batches_Index() throws IOException, InterruptedException {

        testCaseLog("TC01_Create_New_Batch");

        cleanfill.PageObjects.LoginPage login = new cleanfill.PageObjects.LoginPage(CleanFillDriver);
        cleanfill.PageObjects.LandingPage lp = new cleanfill.PageObjects.LandingPage(CleanFillDriver);
        cleanfillPage cf = new cleanfillPage(CleanFillDriver);

        //login.loginAs(USER_NAME, PASSWORD);
        cf.loginAs(USER_NAME, PASSWORD);

        Thread.sleep(2000);
    }

}