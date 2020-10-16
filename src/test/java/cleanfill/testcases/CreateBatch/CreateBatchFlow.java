package cleanfill.testcases.CreateBatch;

import cleanfill.PageObjects.*;
import cleanfill.base.BaseClass;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class CreateBatchFlow extends BaseClass {

    public CreateBatchFlow() {
        log4j = Logger.getLogger(this.getClass().getName());
    }

    @Test
    public void verify_user_can_complete_create_batch_process() {

        testCaseLog("Verify user can complete Create Batch process.");

        LoginPage login = new LoginPage(driver);
        LandingPage landingPage = new LandingPage(driver);
        BatchPage batch = new BatchPage(driver);
        BatchVerification verification = new BatchVerification(driver);

        login.loginAs(SOURCE_USERNAME, SOURCE_PASSWORD);
        landingPage.clickOnBatches();

        if (verification.verifyBatchesScreen()) {
            success("User can see the Batches page.");
        } else {
            failure("ERROR : Batches page is not display.");
        }

        for (int i = 1; i <= batch.getLastRow(); i++) {
            batch.clickOnNewBatchRequest();

            if (verification.verifyCreateNewBatchScreen()) {
                success("User can see the Create New Batch screen.");
            } else {
                failure("ERROR : Create New Batch screen not display");
            }

            batch.enterBatchLoadInformation(i);
            batch.enterSourceSiteDetails(i);
            batch.enterSoilDescriptionParameters(i);
            batch.enterAttachments(i);

            batch.clickOnField(SUBMIT_REQUEST);

            if (verification.verifyBatchCreatedSuccessfully()) {
                success("Verify Batch Request created successfully.");
            } else {
                failure("ERROR : Verify Batch Request created successfully.");
            }

            batch.searchCreatedBatch();

            if (verification.verifyCreatedBatchDisplayWithStatus(Validations.STATUS_PENDING_RECEIVING_SITE)) {
                success("Verify Batch Request display on the table.");
            } else {
                failure("ERROR : Verify Batch Request display on the table.");
            }
        }

        sa.assertAll();
    }

}