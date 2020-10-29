package cleanfill.testcases.EditBatch;

import cleanfill.PageObjects.*;
import cleanfill.base.BaseClass;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class SourceSiteBatchContacts extends BaseClass {

    public SourceSiteBatchContacts() {
        log4j = Logger.getLogger(this.getClass().getName());
    }

    @Test
    public void verify_source_site_information_stored_after_save() {

        testCaseLog("Verify Source Site Information saved after clicking on Save button.");

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

        batch.openBatch();
        batch.clickOnPanel(SOURCE_SITE_BATCH_CONTACT);

        if (verification.verifyPanelTwoInformationDisplay()) {
            success("Verify Source Site information display same as before saved.");
        } else {
            failure("ERROR : Verify Source Site information display same as before saved.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_source_site_information_validations_in_source_site_information_on_edit() {

        testCaseLog("Verify Source Site Information validations in the Source Information section On Edit.");

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

        batch.clickOnField(SAVE_BUTTON);

        if (verification.verifyBatchRequestSaved()) {
            success("Verify Batch Request Save Successfully.");
        } else {
            failure("ERROR : Verify Batch Request Save Successfully.");
        }

        batch.searchCreatedBatch();
        batch.openBatch();

        batch.clickOnPanel(SOURCE_SITE_BATCH_CONTACT);

        batch.clickOnField(SOURCE_SITE);

        if (verification.verifyAllOptionDisplayAlphabetically()) {
            success("Select a Source Site values are in alphabetical order.");
        } else {
            failure("ERROR : Select a Source Site values are in alphabetical order.");
        }

        batch.selectAnOption();

        if (verification.verifySelectedValueDisplayOnDropdown(SELECTED_SOURCE_SITE)) {
            success("Selected dropdown value should display on the field.");
        } else {
            failure("ERROR : Selected dropdown value should display on the field.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_source_type_information_validations_in_source_site_information_on_edit() {

        testCaseLog("Verify Source Type Information validations in the Source Information section On Edit.");

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

        batch.clickOnField(SAVE_BUTTON);

        if (verification.verifyBatchRequestSaved()) {
            success("Verify Batch Request Save Successfully.");
        } else {
            failure("ERROR : Verify Batch Request Save Successfully.");
        }

        batch.searchCreatedBatch();
        batch.openBatch();

        batch.clickOnPanel(SOURCE_SITE_BATCH_CONTACT);

        batch.clickOnField(SOURCE_TYPE);

        if (verification.verifySourceTypeOptionDisplay()) {
            success("Select a Source Type values are display.");
        } else {
            failure("ERROR : Select a Source Type values are display.");
        }

        batch.selectOtherAsType();

        if (verification.verifyOtherOptionDisplayTextField(SOURCE_TYPE_OTHER)) {
            success("Text field display while selecting the Other as option.");
        } else {
            failure("ERROR : Text field display while selecting the Other as option.");
        }

        batch.enterMoreCharactersThan(SOURCE_TYPE_OTHER, 25);

        if (verification.verifyMaxCharacter(SOURCE_TYPE_OTHER, 25)) {
            success("Other can have max 25 characters");
        } else {
            failure("ERROR : Other can have max 25 characters");
        }

        sa.assertAll();

    }

    @Test
    public void verify_source_history_information_validations_in_source_site_information_on_edit() {

        testCaseLog("Verify Source Site History Information validations in the Source Information section.");

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

        batch.clickOnField(SAVE_BUTTON);

        if (verification.verifyBatchRequestSaved()) {
            success("Verify Batch Request Save Successfully.");
        } else {
            failure("ERROR : Verify Batch Request Save Successfully.");
        }

        batch.searchCreatedBatch();
        batch.openBatch();

        batch.clickOnPanel(SOURCE_SITE_BATCH_CONTACT);

        batch.clickOnField(SITE_HISTORY);

        if (verification.verifySiteHistoryOptionDisplay()) {
            success("Select a Site History values are display.");
        } else {
            failure("ERROR : Select a Site History values are display.");
        }

        batch.selectOtherAsType();

        if (verification.verifyOtherOptionDisplayTextField(SITE_HISTORY_OTHER)) {
            success("Text field display while selecting the Other as option.");
        } else {
            failure("ERROR : Text field display while selecting the Other as option.");
        }

        batch.enterMoreCharactersThan(SITE_HISTORY_OTHER, 25);

        if (verification.verifyMaxCharacter(SITE_HISTORY_OTHER, 25)) {
            success("Other can have max 25 characters");
        } else {
            failure("ERROR : Other can have max 25 characters");
        }

        sa.assertAll();

    }

    @Test
    public void verify_present_use_information_validations_in_source_site_information_on_edit() {

        testCaseLog("Verify Present Use Information validations in the Source Information section.");

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

        batch.clickOnField(SAVE_BUTTON);

        if (verification.verifyBatchRequestSaved()) {
            success("Verify Batch Request Save Successfully.");
        } else {
            failure("ERROR : Verify Batch Request Save Successfully.");
        }

        batch.searchCreatedBatch();
        batch.openBatch();

        batch.clickOnPanel(SOURCE_SITE_BATCH_CONTACT);

        batch.clickOnField(PRESENT_USE);
        batch.enterMoreCharactersThan(PRESENT_USE, 50);

        if (verification.verifyValidationMessageForMoreChars(PRESENT_USE)) {
            success("Present Use can have max 50 characters");
        } else {
            failure("ERROR : Present Use can have max 50 characters");
        }

        sa.assertAll();

    }

    @Test
    public void verify_primary_contact_information_validations_in_source_site_information_on_edit() {

        testCaseLog("Verify Primary Contact Information validations in the Source Information section.");

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

        batch.clickOnField(SAVE_BUTTON);

        if (verification.verifyBatchRequestSaved()) {
            success("Verify Batch Request Save Successfully.");
        } else {
            failure("ERROR : Verify Batch Request Save Successfully.");
        }

        batch.searchCreatedBatch();
        batch.openBatch();

        batch.clickOnPanel(SOURCE_SITE_BATCH_CONTACT);

        batch.clickOnField(PRIMARY_CONTACT);

        if (batch.isDropdownValuesAvailable()) {
            if (verification.verifyContactListDisplay()) {
                success("Primary Contact values display in the drop down.");
            } else {
                failure("ERROR : Primary Contact values display in the drop down.");
            }

            batch.typeOptionFromList(PRIMARY_CONTACT);

            if (verification.verifyListOfContactDisplayByText()) {
                success("List of contact display based on entered text.");
            } else {
                failure("ERROR : List of contact display based on entered text.");
            }

            batch.selectAnOption();

            if (verification.verifyContactDetailsDisplay()) {
                success("Selected contact email and phone number should display.");
            } else {
                failure("ERROR : Selected contact email and phone number should display.");
            }

        } else {
            testWarningLog("No Primary Contact display on the field, Test can't be completed.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_qualified_person_information_validations_in_source_site_information_on_edit() {

        testCaseLog("Verify Qualified Person Information validations in the Source Information section.");

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

        batch.waitTillPageLoad();
        batch.clickOnField(SOURCE_SITE, 1);
        batch.selectAnOption();
        batch.clickOnField(SOURCE_TYPE, 1);
        batch.selectAnOption();
        batch.clickOnField(SITE_HISTORY);
        batch.selectAnOption();
        batch.enterValidValue(FieldOR.PRESENT_USE, SITE_HISTORY_RESIDENTIAL);
        batch.clickOnField(PRIMARY_CONTACT);
        batch.selectAnOption();
        batch.clickOnField(QUALIFIED_PERSON);

        if (batch.isDropdownValuesAvailable()) {

            batch.selectAnOption();

            batch.clickOnField(SAVE_BUTTON);

            if (verification.verifyBatchRequestSaved()) {
                success("Verify Batch Request Save Successfully.");
            } else {
                failure("ERROR : Verify Batch Request Save Successfully.");
            }

            batch.searchCreatedBatch();
            batch.openBatch();

            batch.clickOnPanel(SOURCE_SITE_BATCH_CONTACT);
            batch.clickOnField(QUALIFIED_PERSON);

            if (verification.verifyContactListDisplay()) {
                success("Qualified Person display in the drop down.");
            } else {
                failure("ERROR : Qualified Person display in the drop down.");
            }

            batch.typeOptionFromList(QUALIFIED_PERSON);

            if (verification.verifyListOfContactDisplayByText()) {
                success("List of contact display based on entered text.");
            } else {
                failure("ERROR : List of contact display based on entered text.");
            }
        } else {
            testWarningLog("No Qualified Person display on the field, Test can't be completed.");
        }

        sa.assertAll();

    }
}
