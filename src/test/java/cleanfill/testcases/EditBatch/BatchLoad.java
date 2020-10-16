package cleanfill.testcases.EditBatch;

import cleanfill.PageObjects.*;
import cleanfill.base.BaseClass;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class BatchLoad extends BaseClass {

    public BatchLoad() {
        log4j = Logger.getLogger(this.getClass().getName());
    }

    @Test
    public void verify_batch_load_information_stored_after_save() {

        testCaseLog("Verify Batch Load Information saved after clicking on Save button.");

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

        batch.clickOnField(SAVE_BUTTON);

        if (verification.verifyBatchRequestSaved()) {
            success("Verify Batch Request Save Successfully.");
        } else {
            failure("ERROR : Verify Batch Request Save Successfully.");
        }

        batch.searchCreatedBatch();

        if (verification.verifyCreatedBatchDisplayWithStatus(Validations.STATUS_DRAFT)) {
            success("Verify Batch Request display on the table with Draft.");
        } else {
            failure("ERROR : Verify Batch Request display on the table with Draft.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_batch_name_validations_in_batch_information_on_edit() {

        testCaseLog("Verify Batch Name validations in the Batch Information section after Edit.");

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

        if (batch.isBatchListAvailable())
            batch.getAlreadyCreatedBatchName();

        batch.clickOnNewBatchRequest();

        if (verification.verifyCreateNewBatchScreen()) {
            success("User can see the Create New Batch screen.");
        } else {
            failure("ERROR : Create New Batch screen not display");
        }

        batch.enterPanelOneInformation();

        batch.clickOnField(SAVE_BUTTON);

        if (verification.verifyBatchRequestSaved()) {
            success("Verify Batch Request Save Successfully.");
        } else {
            failure("ERROR : Verify Batch Request Save Successfully.");
        }

        batch.searchCreatedBatch();
        batch.openBatch();

        batch.removeText(BATCH_NAME);
        batch.clickOnField(BATCH_ID);

        if (verification.verifyFieldIsMandatory(BATCH_NAME)) {
            success("Batch Name field should be mandatory.");
        } else {
            failure("ERROR : Batch Name field should be mandatory.");
        }

        batch.enterMoreCharactersThan(BATCH_NAME, 25);

        if (verification.verifyMaxCharacter(BATCH_NAME, 25)) {
            success("Batch Name can have max 25 characters");
        } else {
            failure("ERROR : Batch Name can have max 25 characters");
        }

        if (!batch.isBatchNameEmpty()) {
            batch.enterDuplicateBatchName();

            if (verification.verifyValidationMessageForDuplicateBatchName(BATCH_NAME)) {
                success("Duplicate Batch Name should not allow.");
            } else {
                failure("ERROR : Duplicate Batch Name should not allow.");
            }
        } else {
            testWarningLog("ERROR : Duplicate Batch Name can't be verified as no already create batch found.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_batch_id_validations_in_batch_information() {

        testCaseLog("Verify Batch Id validations in the Batch Information section.");

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

        batch.clickOnField(SAVE_BUTTON);

        if (verification.verifyBatchRequestSaved()) {
            success("Verify Batch Request Save Successfully.");
        } else {
            failure("ERROR : Verify Batch Request Save Successfully.");
        }

        batch.searchCreatedBatch();
        batch.openBatch();

        if (verification.verifyBatchIdGenerated()) {
            success("Batch ID should be generated automatically and of 7 digits.");
        } else {
            failure("ERROR : Batch ID should be generated automatically and of 7 digits.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_measurement_settings_display_selected_after_opening_draft() {

        testCaseLog("Verify Measurement Settings display selected after opening draft.");

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

        batch.clickOnField(SAVE_BUTTON);

        if (verification.verifyBatchRequestSaved()) {
            success("Verify Batch Request Save Successfully.");
        } else {
            failure("ERROR : Verify Batch Request Save Successfully.");
        }

        batch.searchCreatedBatch();
        batch.openBatch();

        if (verification.verifyMeasurementDisplaySelected()) {
            success("Measurement Setting radios should be mandatory.");
        } else {
            failure("ERROR : Measurement Setting radios field should be mandatory.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_estimation_loads_validations_in_load_information_after_edit() {

        testCaseLog("Verify Estimation Loads validations in the Load Information section after edit.");

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

        batch.clickOnField(SAVE_BUTTON);

        if (verification.verifyBatchRequestSaved()) {
            success("Verify Batch Request Save Successfully.");
        } else {
            failure("ERROR : Verify Batch Request Save Successfully.");
        }

        batch.searchCreatedBatch();
        batch.openBatch();

        batch.removeText(ESTIMATED_LOADS);
        batch.clickOnField(ESTIMATED_WEIGHT);

        if (verification.verifyFieldIsMandatory(ESTIMATED_LOADS)) {
            success("Estimated Loads field should be mandatory.");
        } else {
            failure("ERROR : Estimated Loads field field should be mandatory.");
        }

        batch.enterMoreDigitsThan(ESTIMATED_LOADS, 6);

        if (verification.verifyMaxSixDigitsAccepted(ESTIMATED_LOADS)) {
            success("Estimated Loads field should accept 6 digits maximum.");
        } else {
            failure("ERROR : Estimated Loads field should accept 6 digits maximum.");
        }

        batch.enterInvalidValue(ESTIMATED_LOADS, "0");

        if (verification.verifyValidationMessageForInvalidField(ESTIMATED_LOADS)) {
            success("Estimated Loads field should accept more than 1 as value.");
        } else {
            failure("ERROR : Estimated Loads field should accept more than 1 as value.");
        }

        batch.enterInvalidValue(ESTIMATED_LOADS, "-100");

        if (verification.verifyValidationMessageForInvalidField(ESTIMATED_LOADS)) {
            success("Estimated Loads field should accept more than 1 as value.");
        } else {
            failure("ERROR : Estimated Loads field should accept more than 1 as value.");
        }

        batch.enterInvalidValue(ESTIMATED_LOADS, "abcd");

        if (verification.verifyValidationMessageForInvalidField(ESTIMATED_LOADS)) {
            success("Estimated Loads field should numeric value.");
        } else {
            failure("ERROR : Estimated Loads field should numeric value.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_estimation_weight_validations_in_load_information_on_edit() {

        testCaseLog("Verify Estimation Weight validations in the Load Information section on edit.");

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

        batch.clickOnField(SAVE_BUTTON);

        if (verification.verifyBatchRequestSaved()) {
            success("Verify Batch Request Save Successfully.");
        } else {
            failure("ERROR : Verify Batch Request Save Successfully.");
        }

        batch.searchCreatedBatch();
        batch.openBatch();

        batch.removeText(ESTIMATED_WEIGHT);
        batch.clickOnField(ESTIMATED_LOADS);

        if (verification.verifyFieldIsMandatory(ESTIMATED_WEIGHT)) {
            success("Estimated Weight field should be mandatory.");
        } else {
            failure("ERROR : Estimated Weight field field should be mandatory.");
        }

        batch.enterMoreDigitsThan(ESTIMATED_WEIGHT, 6);

        if (verification.verifyMaxSixDigitsAccepted(ESTIMATED_WEIGHT)) {
            success("Estimated Weight field should accept 6 digits maximum.");
        } else {
            failure("ERROR : Estimated Weight field should accept 6 digits maximum.");
        }

        batch.enterMoreDecimalThan(ESTIMATED_WEIGHT, 2);

        if (verification.verifyMaxTwoDecimalAccepted(ESTIMATED_WEIGHT)) {
            success("Estimated Weight field should accept 2 decimal maximum.");
        } else {
            failure("ERROR : Estimated Weight field should accept 2 decimal maximum.");
        }

        batch.enterInvalidValue(ESTIMATED_WEIGHT, "0.00");

        if (verification.verifyValidationMessageForInvalidField(ESTIMATED_WEIGHT)) {
            success("Estimated Weight field should accept more than 1 as value.");
        } else {
            failure("ERROR : Estimated Weight field should accept more than 1 as value.");
        }

        batch.enterInvalidValue(ESTIMATED_WEIGHT, "-100.00");

        if (verification.verifyNegativeValueNotAccepted(ESTIMATED_WEIGHT)) {
            success("Estimated Weight field should accept more than 1 as value.");
        } else {
            failure("ERROR : Estimated Weight field should accept more than 1 as value.");
        }

        batch.enterInvalidValue(ESTIMATED_WEIGHT, "abcd");

        if (verification.verifyValidationMessageForInvalidField(ESTIMATED_WEIGHT)) {
            success("Estimated Weight field should numeric value.");
        } else {
            failure("ERROR : Estimated Weight field should numeric value.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_estimation_volume_validations_in_load_information_on_edit() {

        testCaseLog("Verify Estimation Volume validations in the Load Information section on edit.");

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

        batch.clickOnField(SAVE_BUTTON);

        if (verification.verifyBatchRequestSaved()) {
            success("Verify Batch Request Save Successfully.");
        } else {
            failure("ERROR : Verify Batch Request Save Successfully.");
        }

        batch.searchCreatedBatch();
        batch.openBatch();

        batch.removeText(ESTIMATED_VOLUME);
        batch.clickOnField(ESTIMATED_LOADS);

        if (verification.verifyFieldIsMandatory(ESTIMATED_VOLUME)) {
            success("Estimated Volume field should be mandatory.");
        } else {
            failure("ERROR : Estimated Volume field field should be mandatory.");
        }

        batch.enterMoreDigitsThan(ESTIMATED_VOLUME, 6);

        if (verification.verifyMaxSixDigitsAccepted(ESTIMATED_VOLUME)) {
            success("Estimated Volume field should accept 6 digits maximum.");
        } else {
            failure("ERROR : Estimated Volume field should accept 6 digits maximum.");
        }

        batch.enterMoreDecimalThan(ESTIMATED_VOLUME, 2);

        if (verification.verifyMaxTwoDecimalAccepted(ESTIMATED_VOLUME)) {
            success("Estimated Volume field should accept 2 decimal maximum.");
        } else {
            failure("ERROR : Estimated Volume field should accept 2 decimal maximum.");
        }

        batch.enterInvalidValue(ESTIMATED_VOLUME, "0.00");

        if (verification.verifyValidationMessageForInvalidField(ESTIMATED_VOLUME)) {
            success("Estimated Volume field should accept more than 1 as value.");
        } else {
            failure("ERROR : Estimated Volume field should accept more than 1 as value.");
        }

        batch.enterInvalidValue(ESTIMATED_VOLUME, "-100.00");

        if (verification.verifyNegativeValueNotAccepted(ESTIMATED_VOLUME)) {
            success("Estimated Volume field should accept more than 1 as value.");
        } else {
            failure("ERROR : Estimated Volume field should accept more than 1 as value.");
        }

        batch.enterInvalidValue(ESTIMATED_VOLUME, "abcd");

        if (verification.verifyValidationMessageForInvalidField(ESTIMATED_VOLUME)) {
            success("Estimated Volume field should numeric value.");
        } else {
            failure("ERROR : Estimated Volume field should numeric value.");
        }

        sa.assertAll();

    }

}
