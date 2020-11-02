package cleanfill.testcases.CreateBatch;

import cleanfill.PageObjects.*;
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

        batch.enterPanelTwoInformation();
        batch.enterPanelOneInformation();

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

    @Test
    public void verify_soil_quality_information_validations_in_soil_description() {

        testCaseLog("Verify Soil Quality validations in the Soil Description section.");

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

        batch.enterPanelTwoInformation();
        batch.enterPanelOneInformation();

        if (verification.verifyPanelThreeDisplay()) {
            success("User can see the Panel 3 Screen to enter Site Information.");
        } else {
            failure("ERROR : User can see the Panel 3 Screen to enter Site Information.");
        }

        batch.clickOnSoilAnalysisDone();
        batch.clickOnSoilAnalysisDone();
        batch.waitTillPageLoad();

        if (verification.verifyMandatoryFieldValidation(SOIL_QUALITY)) {
            success("Select a Soil Quality should be mandatory.");
        } else {
            failure("ERROR : Select a Soil Quality should be mandatory.");
        }

        batch.clickOnField(SOIL_QUALITY);

        if (verification.verifyAllSoilQualityOptionDisplay()) {
            success("All defined options are display for the Soil Quality.");
        } else {
            failure("ERROR : All defined options are display for the Soil Quality.");
        }

        batch.selectSoilQuality(2);

        if (verification.verifySelectedValueDisplayOnDropdown(SELECTED_SOIL_QUALITY)) {
            success("Selected dropdown value should display on the field.");
        } else {
            failure("ERROR : Selected dropdown value should display on the field.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_analysis_parameter_information_validations_in_soil_description() {

        testCaseLog("Verify Analysis Parameter validations in the Soil Description section.");

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

        batch.enterPanelTwoInformation();
        batch.enterPanelOneInformation();

        if (verification.verifyPanelThreeDisplay()) {
            success("User can see the Panel 3 Screen to enter Site Information.");
        } else {
            failure("ERROR : User can see the Panel 3 Screen to enter Site Information.");
        }

        if (verification.verifyAnalysisParametersDisplay()) {
            success("Verify All Soil Analysis options display.");
        } else {
            failure("ERROR : Verify All Soil Analysis options display.");
        }

        batch.selectSoilAnalysis();

        if (verification.verifyTCLPAndSampleDetailDisplay()) {
            success("Verify Number of Sample and TCLP Checkbox fields display.");
        } else {
            failure("ERROR : Verify Number of Sample and TCLP Checkbox fields display.");
        }

        batch.uncheckSelectedChoice();

        if (verification.verifyTCLPAndSampleDetailDisappear()) {
            success("Verify Number of Sample and TCLP Checkbox fields disappear.");
        } else {
            failure("ERROR : Verify Number of Sample and TCLP Checkbox fields disappear.");
        }

        batch.selectSoilAnalysisAsOther();

        if (verification.verifyOtherSelectDetails()) {
            success("Verify Other Text field display.");
        } else {
            failure("ERROR : Verify Other Text field display.");
        }

        batch.enterMoreCharactersThan(OTHER_SOIL_ANALYSIS, 100);

        if (verification.verifyMaxCharacter(OTHER_SOIL_ANALYSIS, 100)) {
            success("Verify Other Text accepts max 100 characters only.");
        } else {
            failure("ERROR : Verify Other Text accepts max 100 characters only.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_receiving_site_information_validations_in_soil_description() {

        testCaseLog("Verify Receiving Site validations in the Soil Description section.");

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

        batch.enterPanelTwoInformation();
        batch.enterPanelOneInformation();

        if (verification.verifyPanelThreeDisplay()) {
            success("User can see the Panel 3 Screen to enter Site Information.");
        } else {
            failure("ERROR : User can see the Panel 3 Screen to enter Site Information.");
        }

        batch.clickOnField(SOIL_QUALITY);
        batch.selectSoilQuality(1);
        batch.clickOnPanel(3);
        batch.clickOnField(RECEIVING_SITE, 2);

        while (batch.isReceivingSiteNotAvailable()) {
            batch.closeReceivingSitePopup();
            batch.clickOnField(SOIL_QUALITY);
            batch.selectSoilQuality(1);
            batch.clickOnPanel(3);
            batch.clickOnField(RECEIVING_SITE, 2);
        }

        if (verification.verifyModelWindowOpens()) {
            success("Verify Model Window opens to select receiving site.");
        } else {
            failure("ERROR : Verify Model Window opens to select receiving site.");
        }

        if (verification.verifyReceivingSiteNameAndAddressDisplay()) {
            success("Verify Source Site user can see the Receiving Site Name and Address.");
        } else {
            failure("ERROR : Verify Source Site user can see the Receiving Site Name and Address.");
        }

        batch.searchReceivingSite();

        if (verification.verifyReceivingSiteSearchedSuccessfully()) {
            success("Verify Receiving Site searched successfully.");
        } else {
            failure("ERROR : Verify Receiving Site searched successfully.");
        }

        batch.selectAnyReceivingSite();

        if (verification.verifyReceivingSiteSelected()) {
            success("Verify Receiving Site selected successfully.");
        } else {
            failure("ERROR : Verify Receiving Site selected successfully.");
        }

        sa.assertAll();

    }

}
