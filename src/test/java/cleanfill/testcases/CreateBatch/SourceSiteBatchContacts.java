package cleanfill.testcases.CreateBatch;

import cleanfill.PageObjects.BatchPage;
import cleanfill.PageObjects.BatchVerification;
import cleanfill.PageObjects.LandingPage;
import cleanfill.PageObjects.LoginPage;
import cleanfill.base.BaseClass;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class SourceSiteBatchContacts extends BaseClass {

    public SourceSiteBatchContacts() {
        log4j = Logger.getLogger(this.getClass().getName());
    }

    @Test
    public void verify_source_site_information_validations_in_source_site_information() {

        testCaseLog("Verify Source Site Information validations in the Source Information section.");

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

        if (verification.verifyPanelTwoDisplay()) {
            success("User can see the Panel 2 Screen to enter Site Information.");
        } else {
            failure("ERROR : User can see the Panel 2 Screen to enter Site Information.");
        }

        if (verification.verifyFieldIsMandatory(SOURCE_SITE)) {
            success("Select a Source Site should be mandatory.");
        } else {
            failure("ERROR : Select a Source Site should be mandatory.");
        }

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
    public void verify_source_type_information_validations_in_source_site_information() {

        testCaseLog("Verify Source Type Information validations in the Source Information section.");

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

        if (verification.verifyPanelTwoDisplay()) {
            success("User can see the Panel 2 Screen to enter Site Information.");
        } else {
            failure("ERROR : User can see the Panel 2 Screen to enter Site Information.");
        }

        if (verification.verifyFieldIsMandatory(SOURCE_TYPE)) {
            success("Select a Source Type should be mandatory.");
        } else {
            failure("ERROR : Select a Source Type should be mandatory.");
        }

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
    public void verify_source_history_information_validations_in_source_site_information() {

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

        batch.enterPanelOneInformation();

        if (verification.verifyPanelTwoDisplay()) {
            success("User can see the Panel 2 Screen to enter Site Information.");
        } else {
            failure("ERROR : User can see the Panel 2 Screen to enter Site Information.");
        }

        if (verification.verifyFieldIsMandatory(SITE_HISTORY)) {
            success("Select a Site History should be mandatory.");
        } else {
            failure("ERROR : Select a Site History should be mandatory.");
        }

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
    public void verify_present_use_information_validations_in_source_site_information() {

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

        batch.enterPanelOneInformation();

        if (verification.verifyPanelTwoDisplay()) {
            success("User can see the Panel 2 Screen to enter Site Information.");
        } else {
            failure("ERROR : User can see the Panel 2 Screen to enter Site Information.");
        }

        batch.clickOnField(PRESENT_USE);
        batch.clickOnPanel(2);

        if (verification.verifyFieldIsMandatory(PRESENT_USE)) {
            success("Select a Present Use should be mandatory.");
        } else {
            failure("ERROR : Select a Present Use should be mandatory.");
        }

        batch.enterMoreCharactersThan(PRESENT_USE, 50);

        if (verification.verifyValidationMessageForMoreChars(PRESENT_USE)) {
            success("Present Use can have max 50 characters");
        } else {
            failure("ERROR : Present Use can have max 50 characters");
        }

        sa.assertAll();

    }

    @Test
    public void verify_primary_contact_information_validations_in_source_site_information() {

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

        batch.enterPanelOneInformation();

        if (verification.verifyPanelTwoDisplay()) {
            success("User can see the Panel 2 Screen to enter Site Information.");
        } else {
            failure("ERROR : User can see the Panel 2 Screen to enter Site Information.");
        }

        if (verification.verifyFieldIsMandatory(PRIMARY_CONTACT)) {
            success("Select a Primary Contact should be mandatory.");
        } else {
            failure("ERROR : Select a Primary Contact should be mandatory.");
        }

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
    public void verify_qualified_person_information_validations_in_source_site_information() {

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

        batch.enterPanelOneInformation();

        if (verification.verifyPanelTwoDisplay()) {
            success("User can see the Panel 2 Screen to enter Site Information.");
        } else {
            failure("ERROR : User can see the Panel 2 Screen to enter Site Information.");
        }

        batch.clickOnField(QUALIFIED_PERSON);

        if (batch.isDropdownValuesAvailable()) {
            if (verification.verifyContactListDisplay()) {
                success("Primary Contact values display in the drop down.");
            } else {
                failure("ERROR : Primary Contact values display in the drop down.");
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
