package cleanfill.testcases.SignUp;

import cleanfill.PageObjects.*;
import cleanfill.base.BaseClass;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class SourceSiteSignup extends BaseClass {

    public SourceSiteSignup() {
        log4j = Logger.getLogger(this.getClass().getName());
    }

    @Test
    public void verify_user_selects_the_business_type_as_source_site() {

        testCaseLog("Verify user selects the business type as source site.");

        SignupPage signup = new SignupPage(driver);
        SignupVerification verification = new SignupVerification(driver);

        signup.completeSignUp();

        if (verification.verifySignUpSuccess()) {
            success("Verify Signup complete successfully.");
        } else {
            failure("ERROR : Verify Signup complete successfully.");
        }

        signup.clickOnTermsConditions();

        if (verification.verifyNextButtonEnabled()) {
            success("Verify Next button enabled after checking terms and condition.");
        } else {
            failure("ERROR : Verify Next button enabled after checking terms and condition.");
        }

        signup.clickOnNextButton();

        if (verification.verifyBusinessTypeListDisplay()) {
            success("Verify list of business type display on the screen.");
        } else {
            failure("ERROR : Verify list of business type display on the screen.");
        }

        if (verification.verifyBusinessTypeNextButtonDisabled()) {
            success("Verify Next button disabled for business type.");
        } else {
            failure("ERROR : Verify Next button disabled for business type.");
        }

        signup.selectSourceSiteAsBusinessType();

        if (verification.verifyBusinessTypeNextButtonEnabled()) {
            success("Verify Next button enabled for business type.");
        } else {
            failure("ERROR : Verify Next button enabled for business type.");
        }

        signup.clickOnNextBusinessType();

        if (verification.verifySourceSitePanelDisplay()) {
            success("Verify user redirect to 'Register Your Business' screen.");
        } else {
            failure("ERROR : Verify user redirect to 'Register Your Business' screen.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_user_enters_the_company_information_as_source_site() {

        testCaseLog("Verify user enters the company information as source site.");

        SignupPage signup = new SignupPage(driver);
        SignupVerification verification = new SignupVerification(driver);

        signup.completeSignUp();

        if (verification.verifySignUpSuccess()) {
            success("Verify Signup complete successfully.");
        } else {
            failure("ERROR : Verify Signup complete successfully.");
        }

        signup.clickOnTermsConditions();

        if (verification.verifyNextButtonEnabled()) {
            success("Verify Next button enabled after checking terms and condition.");
        } else {
            failure("ERROR : Verify Next button enabled after checking terms and condition.");
        }

        signup.clickOnNextButton();

        if (verification.verifyBusinessTypeListDisplay()) {
            success("Verify list of business type display on the screen.");
        } else {
            failure("ERROR : Verify list of business type display on the screen.");
        }

        if (verification.verifyBusinessTypeNextButtonDisabled()) {
            success("Verify Next button disabled for business type.");
        } else {
            failure("ERROR : Verify Next button disabled for business type.");
        }

        signup.selectSourceSiteAsBusinessType();

        if (verification.verifyBusinessTypeNextButtonEnabled()) {
            success("Verify Next button enabled for business type.");
        } else {
            failure("ERROR : Verify Next button enabled for business type.");
        }

        signup.clickOnNextBusinessType();

        if (verification.verifySourceSitePanelDisplay()) {
            success("Verify user redirect to 'Register Your Business' screen.");
        } else {
            failure("ERROR : Verify user redirect to 'Register Your Business' screen.");
        }

        signup.clickOnCompanyName();
        signup.clickOnPanel(2);

        if (verification.verifyFieldIsMandatory("Company Name")) {
            success("Verify Company Name is mandatory.");
        } else {
            failure("ERROR : Verify Company Name is mandatory.");
        }

        signup.enterPostalCode();

        if (verification.verifyInvalidPostalCodeEntry()) {
            success("Verify Postal Code display Invalid Entry.");
        } else {
            failure("ERROR : Verify Postal Code display Invalid Entry.");
        }

        signup.enterMaxPhoneNumber(0);

        if (verification.verifyMaxCharacterPhoneNumber()) {
            success("Verify Max character validation message for the Phone Number field.");
        } else {
            failure("ERROR : Verify Max character validation message for the Phone Number field.");
        }

        signup.enterPhoneNumber(0);

        if (verification.verifyPhoneNumberFormat()) {
            success("Verify Phone Number format field.");
        } else {
            failure("ERROR : Verify Phone Number format field.");
        }

        signup.enterInvalidExtension(0);

        if (verification.verifyMaxCharacterExtension()) {
            success("Verify Max character validation message for the Extension field.");
        } else {
            failure("ERROR : Verify Max character validation message for the Extension field.");
        }

        signup.enterExtension(0);

        if (verification.verifyExtensionFormat()) {
            success("Verify Extension format field.");
        } else {
            failure("ERROR : Verify Extension format field.");
        }

        signup.enterCompanyName();
        signup.enterAddress();
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);
        signup.clickOnNextPanel();
        new BatchPage(driver).waitTillPageLoad();

        if (verification.verifySourceSiteDisplay()) {
            success("Verify Source Site Panel is display.");
        } else {
            failure("ERROR : Verify Source Site Panel is display.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_user_enters_the_site_name_as_source_site() {

        testCaseLog("Verify user enters the Site Name as source site.");

        SignupPage signup = new SignupPage(driver);
        SignupVerification verification = new SignupVerification(driver);

        signup.completeSignUp();
        signup.clickOnTermsConditions();
        signup.clickOnNextButton();
        signup.selectSourceSiteAsBusinessType();
        signup.clickOnNextBusinessType();
        signup.enterCompanyName();
        signup.enterAddress();
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);
        signup.clickOnNextPanel();
        new BatchPage(driver).waitTillPageLoad();

        if (verification.verifySourceSiteDisplay()) {
            success("Verify Source Site Panel is display.");
        } else {
            failure("ERROR : Verify Source Site Panel is display.");
        }

        signup.clickOnSourceSiteName(0);
        signup.clickOnPanel(3);

        if (verification.verifyFieldIsMandatory("Source Site Name")) {
            success("Verify Source Site Name is mandatory.");
        } else {
            failure("ERROR : Verify Source Site Name is mandatory.");
        }

        signup.enterMoreCharactersForSourceSiteThan(25, 0);

        if (verification.verifyMaxCharacterSourceSiteThan(25)) {
            success("Source Site Name can have max 25 characters");
        } else {
            failure("ERROR : Source Site Name can have max 25 characters");
        }

        signup.enterSourceSiteName();

        if (verification.tabNameSameAsSourceSiteName()) {
            success("Verify Tab Name should be same as entered Site Name");
        } else {
            failure("ERROR : Verify Tab Name should be same as entered Site Name");
        }

        sa.assertAll();

    }

    @Test
    public void verify_user_enters_the_address_as_source_site() {

        testCaseLog("Verify user enters the Address as source site.");

        SignupPage signup = new SignupPage(driver);
        SignupVerification verification = new SignupVerification(driver);

        signup.completeSignUp();
        signup.clickOnTermsConditions();
        signup.clickOnNextButton();
        signup.selectSourceSiteAsBusinessType();
        signup.clickOnNextBusinessType();
        signup.enterCompanyName();
        signup.enterAddress();
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);
        signup.clickOnNextPanel();
        new BatchPage(driver).waitTillPageLoad();

        if (verification.verifySourceSiteDisplay()) {
            success("Verify Source Site Panel is display.");
        } else {
            failure("ERROR : Verify Source Site Panel is display.");
        }

        signup.enterSourceSiteName();
        signup.typeAddress();

        if (verification.verifyAddressListDisplay()) {
            success("Verify Address list display based on entered address.");
        } else {
            failure("ERROR : Verify Address list display based on entered address.");
        }

        signup.selectAddress();

        if (verification.verifyDetailsFilledWithAddress()) {
            success("Verify City, State and Zipcode updated based on address.");
        } else {
            failure("ERROR : Verify City, State and Zipcode updated based on address.");
        }

        signup.getAddressDetails();
        signup.enterNoCADAddress();

        if (verification.verifyNonCADAddressNoFound()) {
            success("Verify Non Canadian Address couldn't found.");
        } else {
            failure("ERROR : Verify Non Canadian Address couldn't found.");
        }

        signup.updatedAddressDetails();

        if (verification.verifyAddressDetailsUpdated()) {
            success("Verify Address Details are updated with address update.");
        } else {
            failure("ERROR : Verify Address Details are updated with address update.");
        }

        signup.enterMoreCharactersFoMunicipality(100);
        signup.clickOnPanel(3);

        if (verification.verifyMaxCharacterMunicipalityThan()) {
            success("Verify Max character validation message for the Municipality field.");
        } else {
            failure("ERROR : Verify Max character validation message for the Municipality field.");
        }

        signup.enterMunicipality();

        if (verification.verifyMunicipalityNameIsAdded()) {
            success("Verify user can add municipality Name.");
        } else {
            failure("ERROR : Verify user can add municipality Name.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_user_enters_the_contact_information_as_source_site() {

        testCaseLog("Verify user enters the Contact Information as source site.");

        SignupPage signup = new SignupPage(driver);
        SignupVerification verification = new SignupVerification(driver);

        signup.completeSignUp();
        signup.clickOnTermsConditions();
        signup.clickOnNextButton();
        signup.selectSourceSiteAsBusinessType();
        signup.clickOnNextBusinessType();
        signup.enterCompanyName();
        signup.enterAddress();
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);
        signup.clickOnNextPanel();
        new BatchPage(driver).waitTillPageLoad();

        if (verification.verifySourceSiteDisplay()) {
            success("Verify Source Site Panel is display.");
        } else {
            failure("ERROR : Verify Source Site Panel is display.");
        }

        signup.enterSourceSiteName();
        signup.enterAddress();
        signup.enterMunicipality();

        signup.clickOnFullName(1);
        signup.clickOnPanel(3);

        if (verification.verifyFieldIsMandatory("Full Name")) {
            success("Verify Full Name is mandatory.");
        } else {
            failure("ERROR : Verify Full Name is mandatory.");
        }

        signup.enterFullName(1);
        signup.clickOnEmail(0);
        signup.clickOnPanel(3);

        if (verification.verifyFieldIsMandatory("Email ID")) {
            success("Verify Email ID is mandatory.");
        } else {
            failure("ERROR : Verify Email ID is mandatory.");
        }

        signup.clickOnPhone(0);
        signup.clickOnPanel(3);

        if (verification.verifyFieldIsMandatory("Phone")) {
            success("Verify Phone is mandatory.");
        } else {
            failure("ERROR : Verify Phone is mandatory.");
        }

        signup.enterMaxCharsForFullName(1);

        if (verification.verifyMaxCharacterFullNameThan()) {
            success("Verify Max character validation message for the Full Name field.");
        } else {
            failure("ERROR : Verify Max character validation message for the Full Name field.");
        }

        signup.enterMaxPhoneNumber(0);

        if (verification.verifyMaxCharacterPhoneNumber()) {
            success("Verify Max character validation message for the Phone Number field.");
        } else {
            failure("ERROR : Verify Max character validation message for the Phone Number field.");
        }

        signup.enterPhoneNumber(0);

        if (verification.verifyPhoneNumberFormat()) {
            success("Verify Phone Number format field.");
        } else {
            failure("ERROR : Verify Phone Number format field.");
        }

        signup.enterInvalidExtension(0);

        if (verification.verifyMaxCharacterExtension()) {
            success("Verify Max character validation message for the Extension field.");
        } else {
            failure("ERROR : Verify Max character validation message for the Extension field.");
        }

        signup.enterExtension(0);

        if (verification.verifyExtensionFormat()) {
            success("Verify Extension format field.");
        } else {
            failure("ERROR : Verify Extension format field.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_document_files_validations_as_source_site() {

        testCaseLog("Verify Document File validations in the Source Site section.");

        SignupPage signup = new SignupPage(driver);
        SignupVerification verification = new SignupVerification(driver);
        BatchPage batch = new BatchPage(driver);
        BatchVerification batchVerification = new BatchVerification(driver);

        signup.completeSignUp();
        signup.clickOnTermsConditions();
        signup.clickOnNextButton();
        signup.selectSourceSiteAsBusinessType();
        signup.clickOnNextBusinessType();
        signup.enterCompanyName();
        signup.enterAddress();
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);
        signup.clickOnNextPanel();
        new BatchPage(driver).waitTillPageLoad();

        if (verification.verifySourceSiteDisplay()) {
            success("Verify Source Site Panel is display.");
        } else {
            failure("ERROR : Verify Source Site Panel is display.");
        }

        signup.enterSourceSiteName();
        signup.enterAddress();
        signup.enterMunicipality();

        signup.enterFullName(1);
        signup.enterEmailID(0);
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);

        batch.uploadFile(FILE_TYPE_JPEG);

        if (batchVerification.verifyFileUploadedSuccessfully()) {
            success("Verify uploaded file display on the Documents section.");
        } else {
            failure("ERROR : Verify uploaded file display on the Documents section.");
        }

        batch.clickOnField(DELETE_FILE);

        if (batchVerification.verifyDeleteActionButtons()) {
            success("Verify confirmation pop up with action buttons display.");
        } else {
            failure("ERROR : Verify confirmation pop up with action buttons display");
        }

        batch.clickOnField(DELETE_NO);

        if (batchVerification.verifyFileUploadedSuccessfully()) {
            success("Verify file isn't deleted.");
        } else {
            failure("ERROR : Verify file isn't deleted");
        }

        batch.clickOnField(DELETE_FILE);
        batch.clickOnField(DELETE_YES);

        if (batchVerification.verifyFileDeleted()) {
            success("Verify file deleted successfully.");
        } else {
            failure("ERROR : Verify file deleted successfully.");
        }

        batch.uploadFile(FieldOR.FILE_TYPE_MAX);

        if (batchVerification.verifyMaxSizeFileValidation()) {
            success("Verify user can upload file up to 10 MB of size.");
        } else {
            failure("ERROR : Verify user can upload file up to 10 MB of size.");
        }

        batch.uploadFile(FieldOR.FILE_TYPE_JPEG);
        batch.uploadFile(FieldOR.FILE_TYPE_PNG);
        batch.uploadFile(FieldOR.FILE_TYPE_DOC);
        batch.uploadFile(FieldOR.FILE_TYPE_PDF);
        batch.uploadFile(FieldOR.FILE_TYPE_EXTRA);
        batch.uploadFile(FieldOR.FILE_TYPE_EXTRA_2);

        if (batchVerification.verifyMaxFileUploadValidation()) {
            success("Verify user can upload maximum 5 files for the batch.");
        } else {
            failure("ERROR : Verify user can upload maximum 5 files for the batch.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_user_can_enter_multiple_source_site() {

        testCaseLog("Verify user can enter multiple source site.");

        SignupPage signup = new SignupPage(driver);
        SignupVerification verification = new SignupVerification(driver);
        BatchPage batch = new BatchPage(driver);
        BatchVerification batchVerification = new BatchVerification(driver);

        signup.completeSignUp();
        signup.clickOnTermsConditions();
        signup.clickOnNextButton();
        signup.selectSourceSiteAsBusinessType();
        signup.clickOnNextBusinessType();
        signup.enterCompanyName();
        signup.enterAddress();
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);
        signup.clickOnNextPanel();
        new BatchPage(driver).waitTillPageLoad();

        if (verification.verifySourceSiteDisplay()) {
            success("Verify Source Site Panel is display.");
        } else {
            failure("ERROR : Verify Source Site Panel is display.");
        }

        signup.enterSourceSiteName();
        signup.enterAddress();
        signup.enterMunicipality();

        signup.enterFullName(1);
        signup.enterEmailID(0);
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);

        batch.uploadFile(FILE_TYPE_JPEG);

        if (batchVerification.verifyFileUploadedSuccessfully()) {
            success("Verify uploaded file display on the Documents section.");
        } else {
            failure("ERROR : Verify uploaded file display on the Documents section.");
        }

        signup.clickOnAddNewSite();
        signup.clickOnNewSourceTab();

        signup.enterSourceSiteName();
        signup.enterAddress();
        signup.enterMunicipality();

        signup.enterFullName(1);
        signup.enterEmailID(0);
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);

        batch.uploadFile(FILE_TYPE_JPEG);

        if (batchVerification.verifyFileUploadedSuccessfully()) {
            success("Verify uploaded file display on the Documents section.");
        } else {
            failure("ERROR : Verify uploaded file display on the Documents section.");
        }

        if (batchVerification.verifyTwoTabSelected()) {
            success("Verify two source site added successfully.");
        } else {
            failure("ERROR : Verify two source site added successfully.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_user_can_enter_personal_information() {

        testCaseLog("Verify user can enter personal information.");

        SignupPage signup = new SignupPage(driver);
        SignupVerification verification = new SignupVerification(driver);
        BatchPage batch = new BatchPage(driver);

        signup.completeSignUp();
        signup.clickOnTermsConditions();
        signup.clickOnNextButton();
        signup.selectSourceSiteAsBusinessType();
        signup.clickOnNextBusinessType();
        signup.enterCompanyName();
        signup.enterAddress();
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);
        signup.clickOnNextPanel();
        new BatchPage(driver).waitTillPageLoad();

        if (verification.verifySourceSiteDisplay()) {
            success("Verify Source Site Panel is display.");
        } else {
            failure("ERROR : Verify Source Site Panel is display.");
        }

        signup.enterSourceSiteName();
        signup.enterAddress();
        signup.enterMunicipality();

        signup.enterFullName(1);
        signup.enterEmailID(0);
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);

        batch.uploadFile(FILE_TYPE_JPEG);

        signup.clickOnNextPanel();

        if (verification.verifyPersonalInformationPanelDisplay()) {
            success("Verify Personal Information Panel is display.");
        } else {
            failure("ERROR : Verify Personal Information Panel is display.");
        }

        signup.clickOnSourceSiteName(0);
        signup.clickOnPanel(4);

        if (verification.verifyFieldIsMandatory("Full Name")) {
            success("Verify Full Name is mandatory.");
        } else {
            failure("ERROR : Verify Full Name is mandatory.");
        }

        signup.enterSourceSiteName();
        signup.clickOnEmail(0);
        signup.clickOnPanel(4);

        if (verification.verifyFieldIsMandatory("Email ID")) {
            success("Verify Email ID is mandatory.");
        } else {
            failure("ERROR : Verify Email ID is mandatory.");
        }

        signup.enterEmailID(0);
        signup.clickOnPhone(0);
        signup.clickOnPanel(4);

        if (verification.verifyFieldIsMandatory("Phone")) {
            success("Verify Phone is mandatory.");
        } else {
            failure("ERROR : Verify Phone is mandatory.");
        }

        signup.enterMaxCharsForFullName(0);

        if (verification.verifyMaxCharacterFullNameThan()) {
            success("Verify Max character validation message for the Full Name field.");
        } else {
            failure("ERROR : Verify Max character validation message for the Full Name field.");
        }

        signup.enterMaxPhoneNumber(0);

        if (verification.verifyMaxCharacterPhoneNumber()) {
            success("Verify Max character validation message for the Phone Number field.");
        } else {
            failure("ERROR : Verify Max character validation message for the Phone Number field.");
        }

        signup.enterPhoneNumber(0);

        if (verification.verifyPhoneNumberFormat()) {
            success("Verify Phone Number format field.");
        } else {
            failure("ERROR : Verify Phone Number format field.");
        }

        signup.enterInvalidExtension(0);

        if (verification.verifyMaxCharacterExtension()) {
            success("Verify Max character validation message for the Extension field.");
        } else {
            failure("ERROR : Verify Max character validation message for the Extension field.");
        }

        signup.enterExtension(0);

        if (verification.verifyExtensionFormat()) {
            success("Verify Extension format field.");
        } else {
            failure("ERROR : Verify Extension format field.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_user_can_enter_billing_contact_information() {

        testCaseLog("Verify user can enter Billing Contact information.");

        SignupPage signup = new SignupPage(driver);
        SignupVerification verification = new SignupVerification(driver);
        BatchPage batch = new BatchPage(driver);

        signup.completeSignUp();
        signup.clickOnTermsConditions();
        signup.clickOnNextButton();
        signup.selectSourceSiteAsBusinessType();
        signup.clickOnNextBusinessType();
        signup.enterCompanyName();
        signup.enterAddress();
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);
        signup.clickOnNextPanel();
        new BatchPage(driver).waitTillPageLoad();

        if (verification.verifySourceSiteDisplay()) {
            success("Verify Source Site Panel is display.");
        } else {
            failure("ERROR : Verify Source Site Panel is display.");
        }

        signup.enterSourceSiteName();
        signup.enterAddress();
        signup.enterMunicipality();

        signup.enterFullName(1);
        signup.enterEmailID(0);
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);

        batch.uploadFile(FILE_TYPE_JPEG);

        signup.clickOnNextPanel();

        signup.enterFullName(0);
        signup.enterEmailID(0);
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);

        signup.clickOnFullName(1);
        signup.clickOnPanel(4);

        if (verification.verifyFieldIsMandatory("Full Name")) {
            success("Verify Full Name is mandatory.");
        } else {
            failure("ERROR : Verify Full Name is mandatory.");
        }

        signup.clickOnEmail(1);
        signup.clickOnPanel(4);

        if (verification.verifyFieldIsMandatory("Email ID")) {
            success("Verify Email ID is mandatory.");
        } else {
            failure("ERROR : Verify Email ID is mandatory.");
        }

        signup.clickOnPhone(1);
        signup.clickOnPanel(4);

        if (verification.verifyFieldIsMandatory("Phone")) {
            success("Verify Phone is mandatory.");
        } else {
            failure("ERROR : Verify Phone is mandatory.");
        }

        signup.enterMaxCharsForFullName(1);

        if (verification.verifyMaxCharacterFullNameThan()) {
            success("Verify Max character validation message for the Full Name field.");
        } else {
            failure("ERROR : Verify Max character validation message for the Full Name field.");
        }

        signup.enterMaxPhoneNumber(1);

        if (verification.verifyMaxCharacterPhoneNumber()) {
            success("Verify Max character validation message for the Phone Number field.");
        } else {
            failure("ERROR : Verify Max character validation message for the Phone Number field.");
        }

        signup.enterInvalidExtension(1);

        if (verification.verifyMaxCharacterExtension()) {
            success("Verify Max character validation message for the Extension field.");
        } else {
            failure("ERROR : Verify Max character validation message for the Extension field.");
        }

        signup.checkOnSameAsAbove();

        if (verification.verifyPersonalInformationCopiedToBillingInformation()) {
            success("Verify Billing information updated with Personal Information.");
        } else {
            failure("ERROR : Verify Billing information updated with Personal Information.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_user_can_complete_source_site_registration() {

        testCaseLog("Verify user can complete source site registration.");

        SignupPage signup = new SignupPage(driver);
        SignupVerification verification = new SignupVerification(driver);
        BatchPage batch = new BatchPage(driver);

        signup.completeSignUp();
        signup.clickOnTermsConditions();
        signup.clickOnNextButton();
        signup.selectSourceSiteAsBusinessType();
        signup.clickOnNextBusinessType();
        signup.enterCompanyName();
        signup.enterAddress();
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);
        signup.clickOnNextPanel();

        signup.enterSourceSiteName();
        signup.enterAddress();
        signup.enterMunicipality();

        signup.enterFullName(1);
        signup.enterEmailID(0);
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);

        batch.uploadFile(FILE_TYPE_JPEG);

        signup.clickOnNextPanel();

        signup.enterFullName(0);
        signup.enterEmailID(0);
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);

        if (signup.isBillingSameAsAbove()) {
            signup.checkOnSameAsAbove();
        } else {
            signup.enterFullName(1);
            signup.enterEmailID(1);
            signup.enterPhoneNumber(1);
            signup.enterExtension(1);
        }

        signup.clickOnNextPanel();

        if (verification.verifySourceSiteCreatedSuccessfully()) {
            success("Verify Source Site Registration completed successfully.");
        } else {
            failure("ERROR : Verify Source Site Registration completed successfully.");
        }

        if (verification.verifySourceSiteUserNameDisplay()) {
            success("Verify Source Site Name display on the Dashboard.");
        } else {
            failure("ERROR : Verify Source Site Name display on the Dashboard.");
        }

        sa.assertAll();

    }
}
