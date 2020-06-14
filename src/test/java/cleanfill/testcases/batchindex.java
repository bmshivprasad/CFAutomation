package cleanfill.testcases;

import cleanfill.PageObjects.batchindexpage;
import cleanfill.PageObjects.cleanfillPage;
import cleanfill.base.EnhancedBaseClass;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import java.io.IOException;

public class batchindex extends EnhancedBaseClass {

    public batchindex() {
        log4j = Logger.getLogger("NEW BATCH REQUEST");
    }

    @Test
    public void TC02_Batch_Approval() throws IOException, InterruptedException {

        testCaseLog("TC02_Batch_Approval");

        cleanfill.PageObjects.LoginPage login = new cleanfill.PageObjects.LoginPage(CleanFillDriver);
        cleanfill.PageObjects.LandingPage lp = new cleanfill.PageObjects.LandingPage(CleanFillDriver);
        cleanfillPage cf = new cleanfillPage(CleanFillDriver);
        batchindexpage bi=new batchindexpage(CleanFillDriver);
        //login.loginAs(USER_NAME, PASSWORD);
        cf.loginAs(USER_NAME1, PASSWORD1);
        cf.clickonbatche();
        bi.recvngsiteportal();
        bi.assignfillsiteuser();
        bi.verifymybatches();
        bi.reviewnextload();
        bi.reviewnextsource();
        bi.reviewnextsoil();
        bi.approvefillsite();
        bi.suggestload();
        bi.requestload();
        //bi.invoicetype();
        bi.priceperload();
        bi.feeperload();
        bi.qualifiedperson();
        bi.submitqp();
        bi.fsgrantedpopup();
        bi.verifyfourthstatus();
        Thread.sleep(2000);
    }

}