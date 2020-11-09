package cleanfill.testcases.SignUp;

import cleanfill.PageObjects.*;
import cleanfill.base.BaseClass;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class ReceivingSiteSignup extends BaseClass {

    public ReceivingSiteSignup() {
        log4j = Logger.getLogger(this.getClass().getName());
    }

    @Test
    public void verify_user_selects_the_business_type_as_receiving_site() {

        testCaseLog("Verify user selects the business type as receiving site.");

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

        signup.selectReceivingSiteAsBusinessType();

        if (verification.verifyBusinessTypeNextButtonEnabled()) {
            success("Verify Next button enabled for business type.");
        } else {
            failure("ERROR : Verify Next button enabled for business type.");
        }

        signup.clickOnNextBusinessType();

        if (verification.verifyReceivingSitePanelDisplay()) {
            success("Verify user redirect to 'Register Your Business' screen.");
        } else {
            failure("ERROR : Verify user redirect to 'Register Your Business' screen.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_user_enters_the_company_information_as_receiving_site() {

        testCaseLog("Verify user enters the company information as receiving site.");

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

        signup.selectReceivingSiteAsBusinessType();

        if (verification.verifyBusinessTypeNextButtonEnabled()) {
            success("Verify Next button enabled for business type.");
        } else {
            failure("ERROR : Verify Next button enabled for business type.");
        }

        signup.clickOnNextBusinessType();

        if (verification.verifyReceivingSitePanelDisplay()) {
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

        if (verification.verifyReceivingSiteDisplay()) {
            success("Verify Receiving Site Panel is display.");
        } else {
            failure("ERROR : Verify Receiving Site Panel is display.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_user_enters_the_site_name_as_receiving_site() {

        testCaseLog("Verify user enters the Site Name as receiving site.");

        SignupPage signup = new SignupPage(driver);
        SignupVerification verification = new SignupVerification(driver);

        signup.completeSignUp();
        signup.clickOnTermsConditions();
        signup.clickOnNextButton();
        signup.selectReceivingSiteAsBusinessType();
        signup.clickOnNextBusinessType();
        signup.enterCompanyName();
        signup.enterAddress();
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);
        signup.clickOnNextPanel();
        new BatchPage(driver).waitTillPageLoad();

        if (verification.verifyReceivingSitePanelDisplay()) {
            success("Verify Receiving Site Panel is display.");
        } else {
            failure("ERROR : Verify Receiving Site Panel is display.");
        }

        signup.clickOnReceivingSiteName(0);
        signup.clickOnPanel(3);

        if (verification.verifyFieldIsMandatory("Receiving Site Name")) {
            success("Verify Receiving Site Name is mandatory.");
        } else {
            failure("ERROR : Verify Receiving Site Name is mandatory.");
        }

        signup.enterMoreCharactersForSourceSiteThan(25, 0);

        if (verification.verifyMaxCharacterSourceSiteThan(25)) {
            success("Receiving Site Name can have max 25 characters");
        } else {
            failure("ERROR : Receiving Site Name can have max 25 characters");
        }

        signup.enterReceivingSiteName();

        if (verification.tabNameSameAsReceivingSiteName()) {
            success("Verify Tab Name should be same as entered Site Name");
        } else {
            failure("ERROR : Verify Tab Name should be same as entered Site Name");
        }

        sa.assertAll();

    }

    @Test
    public void verify_user_enters_the_receiving_site_reg_number_as_receiving_site() {

        testCaseLog("Verify user enters the Receiving Site Registration Number as receiving site.");

        SignupPage signup = new SignupPage(driver);
        SignupVerification verification = new SignupVerification(driver);

        signup.completeSignUp();
        signup.clickOnTermsConditions();
        signup.clickOnNextButton();
        signup.selectReceivingSiteAsBusinessType();
        signup.clickOnNextBusinessType();
        signup.enterCompanyName();
        signup.enterAddress();
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);
        signup.clickOnNextPanel();
        new BatchPage(driver).waitTillPageLoad();

        if (verification.verifyReceivingSitePanelDisplay()) {
            success("Verify Receiving Site Panel is display.");
        } else {
            failure("ERROR : Verify Receiving Site Panel is display.");
        }

        if (verification.verifyReceivingRegNumberIsOptional()) {
            success("Verify Receiving Site Registration Number isn't mandatory.");
        } else {
            failure("ERROR : Verify Receiving Site Registration Number isn't mandatory.");
        }

        signup.enterMoreCharactersForReceivingSiteRegNoThan(25);
        signup.clickOnReceivingSiteName(0);

        if (verification.verifyMaxCharactersInReceivingSiteRegNo()) {
            success("Receiving Site Reg No can have max 25 characters");
        } else {
            failure("ERROR : Receiving Site Reg No can have max 25 characters");
        }

        signup.enterReceivingSiteRegNumber();

        if (verification.verifyRegistrationNoEntered()) {
            success("Receiving Site Reg No entered successfully.");
        } else {
            failure("ERROR : Receiving Site Reg No entered successfully.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_user_enters_the_address_as_receiving_site() {

        testCaseLog("Verify user enters the Address as receiving site.");

        SignupPage signup = new SignupPage(driver);
        SignupVerification verification = new SignupVerification(driver);

        signup.completeSignUp();
        signup.clickOnTermsConditions();
        signup.clickOnNextButton();
        signup.selectReceivingSiteAsBusinessType();
        signup.clickOnNextBusinessType();
        signup.enterCompanyName();
        signup.enterAddress();
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);
        signup.clickOnNextPanel();
        new BatchPage(driver).waitTillPageLoad();

        if (verification.verifyReceivingSitePanelDisplay()) {
            success("Verify Receiving Site Panel is display.");
        } else {
            failure("ERROR : Verify Receiving Site Panel is display.");
        }

        signup.enterReceivingSiteName();
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

        signup.enterPostalCode();

        if (verification.verifyInvalidPostalCodeEntry()) {
            success("Verify Postal Code display Invalid Entry.");
        } else {
            failure("ERROR : Verify Postal Code display Invalid Entry.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_user_enters_the_contact_information_as_receiving_site() {

        testCaseLog("Verify user enters the Contact Information as receiving site.");

        SignupPage signup = new SignupPage(driver);
        SignupVerification verification = new SignupVerification(driver);

        signup.completeSignUp();
        signup.clickOnTermsConditions();
        signup.clickOnNextButton();
        signup.selectReceivingSiteAsBusinessType();
        signup.clickOnNextBusinessType();
        signup.enterCompanyName();
        signup.enterAddress();
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);
        signup.clickOnNextPanel();
        new BatchPage(driver).waitTillPageLoad();

        if (verification.verifyReceivingSitePanelDisplay()) {
            success("Verify Receiving Site Panel is display.");
        } else {
            failure("ERROR : Verify Receiving Site Panel is display.");
        }

        signup.enterReceivingSiteName();
        signup.enterReceivingSiteRegNumber();
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
    public void verify_user_selects_company_visibility_as_receiving_site() {

        testCaseLog("Verify user selects company visibility to clients as receiving site.");

        SignupPage signup = new SignupPage(driver);
        SignupVerification verification = new SignupVerification(driver);

        signup.completeSignUp();
        signup.clickOnTermsConditions();
        signup.clickOnNextButton();
        signup.selectReceivingSiteAsBusinessType();
        signup.clickOnNextBusinessType();
        signup.enterCompanyName();
        signup.enterAddress();
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);
        signup.clickOnNextPanel();
        new BatchPage(driver).waitTillPageLoad();

        if (verification.verifyReceivingSitePanelDisplay()) {
            success("Verify Receiving Site Panel is display.");
        } else {
            failure("ERROR : Verify Receiving Site Panel is display.");
        }

        signup.enterReceivingSiteName();
        signup.enterReceivingSiteRegNumber();
        signup.enterAddress();
        signup.enterMunicipality();

        signup.enterFullName(1);
        signup.enterEmailID(0);
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);

        signup.selectVisibility();

        if (verification.verifyCompanyVisibilitySelected()) {
            success("Verify 'Company’s Visibility To Clients' selected properly.");
        } else {
            failure("ERROR : Verify 'Company’s Visibility To Clients' selected properly.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_user_selects_3rd_party_reporting_as_receiving_site() {

        testCaseLog("Verify user selects Does this site require 3rd party reporting? as receiving site.");

        SignupPage signup = new SignupPage(driver);
        SignupVerification verification = new SignupVerification(driver);

        signup.completeSignUp();
        signup.clickOnTermsConditions();
        signup.clickOnNextButton();
        signup.selectReceivingSiteAsBusinessType();
        signup.clickOnNextBusinessType();
        signup.enterCompanyName();
        signup.enterAddress();
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);
        signup.clickOnNextPanel();
        new BatchPage(driver).waitTillPageLoad();

        if (verification.verifyReceivingSitePanelDisplay()) {
            success("Verify Receiving Site Panel is display.");
        } else {
            failure("ERROR : Verify Receiving Site Panel is display.");
        }

        signup.enterReceivingSiteName();
        signup.enterReceivingSiteRegNumber();
        signup.enterAddress();
        signup.enterMunicipality();

        signup.enterFullName(1);
        signup.enterEmailID(0);
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);

        signup.selectVisibility();
        signup.selectThirdPartyReporting();

        if (verification.verifyThirdPartyReportingSelected()) {
            success("Verify 'Does this site require 3rd party reporting?' selected properly.");
        } else {
            failure("ERROR : Verify 'Does this site require 3rd party reporting?' selected properly.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_user_can_select_soil_classification_as_receiving_site() {

        testCaseLog("Verify user can select soil classification as receiving site.");

        SignupPage signup = new SignupPage(driver);
        SignupVerification verification = new SignupVerification(driver);

        signup.completeSignUp();
        signup.clickOnTermsConditions();
        signup.clickOnNextButton();
        signup.selectReceivingSiteAsBusinessType();
        signup.clickOnNextBusinessType();
        signup.enterCompanyName();
        signup.enterAddress();
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);
        signup.clickOnNextPanel();
        new BatchPage(driver).waitTillPageLoad();

        if (verification.verifyReceivingSitePanelDisplay()) {
            success("Verify Receiving Site Panel is display.");
        } else {
            failure("ERROR : Verify Receiving Site Panel is display.");
        }

        if (verification.verifySoilClassificationDisplay()) {
            success("Verify user can see the Soil Classification options in the screen.");
        } else {
            failure("ERROR : Verify user can see the Soil Classification options in the screen.");
        }

        signup.selectAnySoilClassification();

        if (verification.verifySoilClassificationSelected()) {
            success("Verify user can see the Soil Classification options in the screen.");
        } else {
            failure("ERROR : Verify user can see the Soil Classification options in the screen.");
        }

        signup.selectAnySoilClassification();

        if (verification.verifySoilClassificationDeselected()) {
            success("Verify user can deselect the Soil Classification options in the screen.");
        } else {
            failure("ERROR : Verify deselect can see the Soil Classification options in the screen.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_user_can_select_accepted_soil_types_as_receiving_site() {

        testCaseLog("Verify user can select accepted soil types as receiving site.");

        SignupPage signup = new SignupPage(driver);
        SignupVerification verification = new SignupVerification(driver);

        signup.completeSignUp();
        signup.clickOnTermsConditions();
        signup.clickOnNextButton();
        signup.selectReceivingSiteAsBusinessType();
        signup.clickOnNextBusinessType();
        signup.enterCompanyName();
        signup.enterAddress();
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);
        signup.clickOnNextPanel();
        new BatchPage(driver).waitTillPageLoad();

        if (verification.verifyReceivingSitePanelDisplay()) {
            success("Verify Receiving Site Panel is display.");
        } else {
            failure("ERROR : Verify Receiving Site Panel is display.");
        }

        if (verification.verifySoilClassificationDisplay()) {
            success("Verify user can see the Soil Classification options in the screen.");
        } else {
            failure("ERROR : Verify user can see the Soil Classification options in the screen.");
        }
        signup.enterReceivingSiteName();
        signup.enterReceivingSiteRegNumber();
        signup.enterAddress();
        signup.enterMunicipality();

        signup.enterFullName(1);
        signup.enterEmailID(0);
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);

        signup.selectVisibility();
        signup.selectThirdPartyReporting();

        if (verification.verifyAcceptedSoilTypeIsMandatory()) {
            success("Verify user can see the Accepted Soil Types options in the screen.");
        } else {
            failure("ERROR : Verify user can see the Accepted Soil Types options in the screen.");
        }

        if (verification.verifyAcceptedSoilTypesList()) {
            success("Verify user can all valid accepted soil types.");
        } else {
            failure("ERROR : Verify user can all valid accepted soil types.");
        }

        signup.clickOnAllSoilType();

        if (verification.verifyAllSoilTypesAreSelected()) {
            success("Verify all soil types are selected automatically.");
        } else {
            failure("ERROR : Verify all soil types are selected automatically.");
        }

        signup.clickOnAllSoilType();

        if (verification.verifyAllSoilTypesAreDeselected()) {
            success("Verify all soil types are deselected automatically.");
        } else {
            failure("ERROR : Verify all soil types are deselected automatically.");
        }

        signup.selectAnySoilTypes();

        if (verification.verifyAcceptedSoilTypesSelected()) {
            success("Verify accepted soil types are selected automatically.");
        } else {
            failure("ERROR : Verify accepted soil types are selected automatically.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_user_can_upload_attachments_as_receiving_site() {

        testCaseLog("Verify user can upload attachments as receiving site.");

        SignupPage signup = new SignupPage(driver);
        BatchPage batch = new BatchPage(driver);
        SignupVerification verification = new SignupVerification(driver);
        BatchVerification batchVerification = new BatchVerification(driver);

        signup.completeSignUp();
        signup.clickOnTermsConditions();
        signup.clickOnNextButton();
        signup.selectReceivingSiteAsBusinessType();
        signup.clickOnNextBusinessType();
        signup.enterCompanyName();
        signup.enterAddress();
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);
        signup.clickOnNextPanel();
        new BatchPage(driver).waitTillPageLoad();

        if (verification.verifyReceivingSitePanelDisplay()) {
            success("Verify Receiving Site Panel is display.");
        } else {
            failure("ERROR : Verify Receiving Site Panel is display.");
        }

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
    public void verify_user_can_add_multiple_receiving_site() {

        testCaseLog("Verify user can add multiple receiving site.");

        SignupPage signup = new SignupPage(driver);
        BatchPage batch = new BatchPage(driver);
        SignupVerification verification = new SignupVerification(driver);
        BatchVerification batchVerification = new BatchVerification(driver);

        signup.completeSignUp();
        signup.clickOnTermsConditions();
        signup.clickOnNextButton();
        signup.selectReceivingSiteAsBusinessType();
        signup.clickOnNextBusinessType();
        signup.enterCompanyName();
        signup.enterAddress();
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);
        signup.clickOnNextPanel();
        new BatchPage(driver).waitTillPageLoad();

        if (verification.verifyReceivingSitePanelDisplay()) {
            success("Verify Receiving Site Panel is display.");
        } else {
            failure("ERROR : Verify Receiving Site Panel is display.");
        }

        signup.enterReceivingSiteName();
        signup.enterReceivingSiteRegNumber();
        signup.enterAddress();
        signup.enterMunicipality();

        signup.enterFullName(1);
        signup.enterEmailID(0);
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);

        signup.selectVisibility();
        signup.selectThirdPartyReporting();
        signup.selectAnySoilClassification();

        batch.uploadFile(FILE_TYPE_JPEG);

        if (batchVerification.verifyFileUploadedSuccessfully()) {
            success("Verify uploaded file display on the Documents section.");
        } else {
            failure("ERROR : Verify uploaded file display on the Documents section.");
        }

        signup.clickOnAddNewSite();
        signup.clickOnNewReceivingTab();

        signup.enterReceivingSiteName();
        signup.enterReceivingSiteRegNumber();
        signup.enterAddress();
        signup.enterMunicipality();

        signup.enterFullName(1);
        signup.enterEmailID(0);
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);

        signup.selectVisibility();
        signup.selectThirdPartyReporting();
        signup.selectAnySoilClassification();

        batch.uploadFile(FILE_TYPE_JPEG);

        if (batchVerification.verifyFileUploadedSuccessfully()) {
            success("Verify uploaded file display on the Documents section.");
        } else {
            failure("ERROR : Verify uploaded file display on the Documents section.");
        }

        if (batchVerification.verifyTwoTabSelected()) {
            success("Verify two receiving site added successfully.");
        } else {
            failure("ERROR : Verify two receiving site added successfully.");
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
        signup.selectReceivingSiteAsBusinessType();
        signup.clickOnNextBusinessType();
        signup.enterCompanyName();
        signup.enterAddress();
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);
        signup.clickOnNextPanel();
        new BatchPage(driver).waitTillPageLoad();

        if (verification.verifyReceivingSitePanelDisplay()) {
            success("Verify Receiving Site Panel is display.");
        } else {
            failure("ERROR : Verify Receiving Site Panel is display.");
        }

        signup.enterReceivingSiteName();
        signup.enterReceivingSiteRegNumber();
        signup.enterAddress();
        signup.enterMunicipality();

        signup.enterFullName(1);
        signup.enterEmailID(0);
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);

        signup.selectVisibility();
        signup.selectThirdPartyReporting();
        signup.selectAnySoilClassification();

        batch.uploadFile(FILE_TYPE_JPEG);

        signup.clickOnNextPanelNavigation();

        if (verification.verifyPersonalInformationPanelDisplay()) {
            success("Verify Personal Information Panel is display.");
        } else {
            failure("ERROR : Verify Personal Information Panel is display.");
        }

        signup.clickOnReceivingSiteName(0);
        signup.clickOnPanel(4);

        if (verification.verifyFieldIsMandatory("Full Name")) {
            success("Verify Full Name is mandatory.");
        } else {
            failure("ERROR : Verify Full Name is mandatory.");
        }

        signup.enterReceivingSiteName();
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
        signup.selectReceivingSiteAsBusinessType();
        signup.clickOnNextBusinessType();
        signup.enterCompanyName();
        signup.enterAddress();
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);
        signup.clickOnNextPanel();
        new BatchPage(driver).waitTillPageLoad();

        if (verification.verifyReceivingSitePanelDisplay()) {
            success("Verify Receiving Site Panel is display.");
        } else {
            failure("ERROR : Verify Receiving Site Panel is display.");
        }

        signup.enterReceivingSiteName();
        signup.enterReceivingSiteRegNumber();
        signup.enterAddress();
        signup.enterMunicipality();

        signup.enterFullName(1);
        signup.enterEmailID(0);
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);

        signup.selectVisibility();
        signup.selectThirdPartyReporting();
        signup.selectAnySoilClassification();

        batch.uploadFile(FILE_TYPE_JPEG);

        signup.clickOnNextPanelNavigation();

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
    public void verify_user_can_complete_receiving_site_registration() {

        testCaseLog("Verify user can complete receiving site registration.");

        SignupPage signup = new SignupPage(driver);
        SignupVerification verification = new SignupVerification(driver);
        BatchPage batch = new BatchPage(driver);

        signup.completeSignUp();
        signup.clickOnTermsConditions();
        signup.clickOnNextButton();
        signup.selectReceivingSiteAsBusinessType();
        signup.clickOnNextBusinessType();
        signup.enterCompanyName();
        signup.enterAddress();
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);
        signup.clickOnNextPanel();
        new BatchPage(driver).waitTillPageLoad();

        if (verification.verifyReceivingSitePanelDisplay()) {
            success("Verify Receiving Site Panel is display.");
        } else {
            failure("ERROR : Verify Receiving Site Panel is display.");
        }

        signup.enterReceivingSiteName();
        signup.enterReceivingSiteRegNumber();
        signup.enterAddress();
        signup.enterMunicipality();

        signup.enterFullName(1);
        signup.enterEmailID(0);
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);

        signup.selectVisibility();
        signup.selectThirdPartyReporting();
        signup.selectAnySoilClassification();

        batch.uploadFile(FILE_TYPE_JPEG);

        signup.clickOnNextPanelNavigation();

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

        if (verification.verifyReceivingSiteCreatedSuccessfully()) {
            success("Verify Receiving Site Registration completed successfully.");
        } else {
            failure("ERROR : Verify Receiving Site Registration completed successfully.");
        }

        if (verification.verifyReceivingSiteUserNameDisplay()) {
            success("Verify Receiving Site Name display on the Dashboard.");
        } else {
            failure("ERROR : Verify Receiving Site Name display on the Dashboard.");
        }

        sa.assertAll();

    }

}