package cleanfill.testcases.CreateBatch;

import cleanfill.PageObjects.*;
import cleanfill.base.BaseClass;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class AttachmentsComments extends BaseClass {

    public AttachmentsComments() {
        log4j = Logger.getLogger(this.getClass().getName());
    }

    @Test
    public void verify_document_link_validations_in_attachments() {

        testCaseLog("Verify Document Link validations in the Attachments section.");

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
        batch.enterPanelThreeInformation();

        if (verification.verifyPanelFourDisplay()) {
            success("User can see the Panel 4 Screen to select attachments.");
        } else {
            failure("ERROR : User can see the Panel 4 Screen to select attachments.");
        }

        batch.enterLinks(1);

        if (verification.verifyLinkAddedSuccessfully()) {
            success("Verify added link display on the Links section.");
        } else {
            failure("ERROR : Verify added link display on the Links section.");
        }

        batch.clickOnField(DELETE_LINK);

        if (verification.verifyDeleteActionButtons()) {
            success("Verify confirmation pop up with action buttons display.");
        } else {
            failure("ERROR : Verify confirmation pop up with action buttons display");
        }

        batch.clickOnField(DELETE_NO);

        if (verification.verifyLinkAddedSuccessfully()) {
            success("Verify link isn't deleted.");
        } else {
            failure("ERROR : Verify link isn't deleted");
        }

        batch.clickOnField(DELETE_LINK);
        batch.clickOnField(DELETE_YES);

        if (verification.verifyLinkDeleted()) {
            success("Verify link deleted successfully.");
        } else {
            failure("ERROR : Verify link deleted successfully.");
        }

        batch.enterLinks(4);

        if (verification.verifyMaxLinkValidation()) {
            success("Verify user can add max 3 links.");
        } else {
            failure("ERROR : Verify user can add max 3 links.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_document_files_validations_in_attachments() {

        testCaseLog("Verify Document File validations in the Attachments section.");

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
        batch.enterPanelThreeInformation();

        if (verification.verifyPanelFourDisplay()) {
            success("User can see the Panel 4 Screen to select attachments.");
        } else {
            failure("ERROR : User can see the Panel 4 Screen to select attachments.");
        }

        batch.uploadFile(FILE_TYPE_JPEG);

        if (verification.verifyFileUploadedSuccessfully()) {
            success("Verify uploaded file display on the Documents section.");
        } else {
            failure("ERROR : Verify uploaded file display on the Documents section.");
        }

        batch.clickOnField(DELETE_FILE);

        if (verification.verifyDeleteActionButtons()) {
            success("Verify confirmation pop up with action buttons display.");
        } else {
            failure("ERROR : Verify confirmation pop up with action buttons display");
        }

        batch.clickOnField(DELETE_NO);

        if (verification.verifyFileUploadedSuccessfully()) {
            success("Verify file isn't deleted.");
        } else {
            failure("ERROR : Verify file isn't deleted");
        }

        batch.clickOnField(DELETE_FILE);
        batch.clickOnField(DELETE_YES);

        if (verification.verifyFileDeleted()) {
            success("Verify file deleted successfully.");
        } else {
            failure("ERROR : Verify file deleted successfully.");
        }

        batch.uploadFile(FieldOR.FILE_TYPE_MAX);

        if (verification.verifyMaxSizeFileValidation()) {
            success("Verify user can upload file up to 10 MB of size.");
        } else {
            failure("ERROR : Verify user can upload file up to 10 MB of size.");
        }

        batch.uploadFile(FieldOR.FILE_TYPE_JPEG);
        batch.uploadFile(FieldOR.FILE_TYPE_PNG);
        batch.uploadFile(FieldOR.FILE_TYPE_DOC);
        batch.uploadFile(FieldOR.FILE_TYPE_PDF);
        batch.uploadFile(FieldOR.FILE_TYPE_EXTRA);
        batch.uploadFile(FieldOR.FILE_TYPE_MAX);

        if (verification.verifyMaxFileUploadValidation()) {
            success("Verify user can upload maximum 5 files for the batch.");
        } else {
            failure("ERROR : Verify user can upload maximum 5 files for the batch.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_comments_validations_in_attachments() {

        testCaseLog("Verify Comments validations in the Attachments section.");

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
        batch.enterPanelThreeInformation();

        if (verification.verifyPanelFourDisplay()) {
            success("User can see the Panel 4 Screen to select attachments.");
        } else {
            failure("ERROR : User can see the Panel 4 Screen to select attachments.");
        }

        batch.enterMoreCharactersThan(COMMENTS, 500);

        if (verification.verifyMaxCharacter(COMMENTS, 500)) {
            success("Comments can have max 500 characters");
        } else {
            failure("ERROR : Comments can have max 500 characters");
        }

        sa.assertAll();

    }

}
