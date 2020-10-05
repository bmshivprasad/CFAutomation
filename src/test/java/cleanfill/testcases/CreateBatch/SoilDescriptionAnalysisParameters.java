package cleanfill.testcases.CreateBatch;

import cleanfill.PageObjects.BatchPage;
import cleanfill.PageObjects.BatchVerification;
import cleanfill.PageObjects.LandingPage;
import cleanfill.PageObjects.LoginPage;
import cleanfill.base.BaseClass;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class SoilDescriptionAnalysisParameters extends BaseClass {

    public SoilDescriptionAnalysisParameters() {
        log4j = Logger.getLogger(this.getClass().getName());
    }

    @Test
    public void verify_soil_description_information_validations_in_soil_description() {

        testCaseLog("Verify Soil Description validations in the Soil Description section.");

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

        batch.clickOnNewBatchRequest();

        if (verification.verifyCreateNewBatchScreen()) {
            success("User can see the Create New Batch screen.");
        } else {
            failure("ERROR : Create New Batch screen not display");
        }

        batch.enterPanelOneInformation();
        batch.enterPanelTwoInformation();

        if (verification.verifyPanelThreeDisplay()) {
            success("User can see the Panel 3 Screen to enter Site Information.");
        } else {
            failure("ERROR : User can see the Panel 3 Screen to enter Site Information.");
        }

        if (verification.verifyFieldIsMandatory(SOIL_DESCRIPTION)) {
            success("Select a Soil Description should be mandatory.");
        } else {
            failure("ERROR : Select a Soil Description should be mandatory.");
        }

        batch.clickOnField(SOIL_DESCRIPTION);

        if (verification.verifyAllSoilDescriptionOptionDisplay()) {
            success("All defined options are display for the Soil Description.");
        } else {
            failure("ERROR : All defined options are display for the Soil Description.");
        }

        batch.selectAnOption();

        if (verification.verifySelectedValueDisplayOnDropdown(SELECTED_SOIL_DESCRIPTION)) {
            success("Selected dropdown value should display on the field.");
        } else {
            failure("ERROR : Selected dropdown value should display on the field.");
        }

        sa.assertAll();

    }

}
