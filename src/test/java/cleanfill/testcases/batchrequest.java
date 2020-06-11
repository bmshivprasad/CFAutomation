package cleanfill.testcases;

import cleanfill.PageObjects.cleanfillPage;
import cleanfill.base.EnhancedBaseClass;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

public class batchrequest extends EnhancedBaseClass {

    public batchrequest() {
        log4j = Logger.getLogger("NEW BATCH REQUEST");
    }


    @Test
    public void TC01_Create_New_Batch() throws IOException, InterruptedException {

        testCaseLog("TC01_Create_New_Batch");

        cleanfill.PageObjects.LoginPage login = new cleanfill.PageObjects.LoginPage(CleanFillDriver);
        cleanfill.PageObjects.LandingPage lp = new cleanfill.PageObjects.LandingPage(CleanFillDriver);
        cleanfillPage cf = new cleanfillPage(CleanFillDriver);

        //login.loginAs(USER_NAME, PASSWORD);
        cf.loginAs(USER_NAME, PASSWORD);
        cf.clickonbatche();
        // cf.dismisspopup();
        cf.clickonbatchcreate();
        cf.selecteststartDate();
        // cf.enterbatchdate();
        cf.enterbatchname();
        cf.trackbyload();
        cf.trackbyweight();
        cf.estimatedloads();
        cf.numberOfTrucks();
        cf.estimatedweight();
        cf.txtestimatedvol();
        cf.batchnext();
        //cf.stayonpage();
        cf.sourcesiteopen();
        cf.sourcesite();
        cf.sourcesitetypeopen();
        cf.sourcetypeoption();
        cf.sourcesitehstry();
        cf.sourcesitehstryselect();
        cf.presentuse();
        cf.addrefnotes();
        cf.primarycontact();
        cf.primarycontactoptions();
        cf.qualifiedperson();
        cf.qualifiedpersonoptn();
        cf.nextssinfo();
        //cf.stayonpage();
        cf.soildescription();
        cf.soildescriptionoptn();
        cf.soilquantity();
        cf.soilqtyriptionoptn();
        cf.materialno();
        cf.materialyes();
        cf.entergradereason();
        cf.debrisyes();
        cf.debrisno();
        cf.enterdebrisreason();
        //cf.analysisone();
        //cf.analysisinorg();
        //cf.analysismetals();
       // cf.analysispcb();
        //cf.analysispest();
       // cf.analysissvoc();
        //cf.analysisvoc();
        cf.analysisother();
        cf.othertextbox();
        cf.drprecvngsite();
        cf.drpdwnrecvngsite();
        cf.nextsoildesc();
        // cf.stayonpage();
        cf.UploadFile();
        cf.addlink();
        cf.pastlink();
        cf.comments();
        cf.submitbatchrequest();
        cf.backtobatches();
        cf.batchsearch();
        cf.recvngsiteportal();
        Thread.sleep(2000);
    }

}