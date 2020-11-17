package cleanfill.testcases.SignUp;

import cleanfill.PageObjects.*;
import cleanfill.base.BaseClass;
import cleanfill.utilities.Configurations;
import cleanfill.utilities.ExcelColumns;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class QPSignup extends BaseClass {

    public QPSignup() {
        log4j = Logger.getLogger(this.getClass().getName());
    }

    @Test
    public void verify_user_selects_the_business_type_as_qualified_person() {

        testCaseLog("Verify user selects the business type as qualified person.");

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

        signup.selectQualifiedPersonAsBusinessType();

        if (verification.verifyBusinessTypeNextButtonEnabled()) {
            success("Verify Next button enabled for business type.");
        } else {
            failure("ERROR : Verify Next button enabled for business type.");
        }

        signup.clickOnNextBusinessType();

        if (verification.verifyQPPanelDisplay()) {
            success("Verify user redirect to 'Register Your Business' screen.");
        } else {
            failure("ERROR : Verify user redirect to 'Register Your Business' screen.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_user_enters_the_company_information_as_qp() {

        testCaseLog("Verify user enters the company information as QP.");

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

        signup.selectQualifiedPersonAsBusinessType();

        if (verification.verifyBusinessTypeNextButtonEnabled()) {
            success("Verify Next button enabled for business type.");
        } else {
            failure("ERROR : Verify Next button enabled for business type.");
        }

        signup.clickOnNextBusinessType();

        if (verification.verifyQPPanelDisplay()) {
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

        signup.enterInvalidPostalCode();
        signup.clickOnPanel(2);

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

        if (verification.verifyPersonalInformationPanelAsQPDisplay()) {
            success("Verify Personal Information Panel is display.");
        } else {
            failure("ERROR : Verify Personal Information Panel is display.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_user_enters_the_individual_information_as_qp() {

        testCaseLog("Verify user enters the individual information as QP.");

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

        signup.selectQualifiedPersonAsBusinessType();

        if (verification.verifyBusinessTypeNextButtonEnabled()) {
            success("Verify Next button enabled for business type.");
        } else {
            failure("ERROR : Verify Next button enabled for business type.");
        }

        signup.clickOnNextBusinessType();

        if (verification.verifyQPPanelDisplay()) {
            success("Verify user redirect to 'Register Your Business' screen.");
        } else {
            failure("ERROR : Verify user redirect to 'Register Your Business' screen.");
        }

        signup.selectIndividual();
//        signup.clickOnPGO();
//        signup.clickOnPanel(2);
//
//        if (verification.verifyFieldIsMandatory("PGO")) {
//            success("Verify PGO is mandatory.");
//        } else {
//            failure("ERROR : Verify PGO is mandatory.");
//        }

        signup.enterInvalidPostalCode();
        signup.clickOnPanel(2);

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

        signup.enterPGOName();
        signup.enterAddress();
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);
        signup.clickOnNextPanel();
        new BatchPage(driver).waitTillPageLoad();

        if (verification.verifyPersonalInformationPanelAsQPDisplay()) {
            success("Verify Personal Information Panel is display.");
        } else {
            failure("ERROR : Verify Personal Information Panel is display.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_user_can_enter_personal_information() {

        testCaseLog("Verify user can enter personal information.");

        SignupPage signup = new SignupPage(driver);
        SignupVerification verification = new SignupVerification(driver);

        signup.completeSignUp();
        signup.clickOnTermsConditions();
        signup.clickOnNextButton();
        signup.selectQualifiedPersonAsBusinessType();
        signup.clickOnNextBusinessType();

        if (verification.verifyQPPanelDisplay()) {
            success("Verify user redirect to 'Register Your Business' screen.");
        } else {
            failure("ERROR : Verify user redirect to 'Register Your Business' screen.");
        }

        if (signup.isCompanyUser()) signup.enterCompanyName();
        else signup.enterPGOName();
        signup.enterAddress();
        signup.enterPhoneNumber(0);
        signup.enterExtension(0);
        signup.clickOnNextPanel();
        new BatchPage(driver).waitTillPageLoad();

        if (verification.verifyPersonalInformationPanelAsQPDisplay()) {
            success("Verify Personal Information Panel is display.");
        } else {
            failure("ERROR : Verify Personal Information Panel is display.");
        }

        signup.clickOnFullName(0);
        signup.clickOnPanel(3);

        if (verification.verifyFieldIsMandatory("Full Name")) {
            success("Verify Full Name is mandatory.");
        } else {
            failure("ERROR : Verify Full Name is mandatory.");
        }

        signup.enterFullName(0);
        signup.clickOnEmail(0);
        signup.clickOnPanel(3);

        if (verification.verifyFieldIsMandatory("Email ID")) {
            success("Verify Email ID is mandatory.");
        } else {
            failure("ERROR : Verify Email ID is mandatory.");
        }

        signup.enterEmailID(0);
        signup.clickOnPhone(0);
        signup.clickOnPanel(3);

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
    public void verify_user_can_complete_qp_registration() {

        testCaseLog("Verify user can complete QP registration.");

        SignupPage signup = new SignupPage(driver);
        SignupVerification verification = new SignupVerification(driver);

        for (int count = 2; count <= signup.getLastRow(RECEIVING_SITE_SIGNUP); count++) {

            signup.completeSignUp(QP_SIGNUP, count);
            signup.clickOnTermsConditions();
            signup.clickOnNextButton();
            signup.selectQualifiedPersonAsBusinessType();
            signup.clickOnNextBusinessType();
            signup.selectUserTye(ExcelColumns.QP_COMPANY_NAME, QP_SIGNUP, count);
            signup.enterAddress(ExcelColumns.QP_COMPANY_ADDRESS, QP_SIGNUP, count);
            signup.enterMunicipality(ExcelColumns.QP_COMPANY_MUNICIPALITY, QP_SIGNUP, count);
            signup.enterPhoneNumber(0, ExcelColumns.QP_PHONE_NUMBER, Configurations.QP_SIGNUP, count);
            signup.enterExtension(0, ExcelColumns.QP_EXTENSION, Configurations.QP_SIGNUP, count);
            signup.clickOnNextPanel();

            signup.enterFullName(0, ExcelColumns.QP_PERSONAL_FULL_NAME, QP_SIGNUP, count);
            signup.enterEmailID(0, ExcelColumns.QP_PERSONAL_EMAIL_ID, QP_SIGNUP, count);
            signup.enterPhoneNumber(0, ExcelColumns.QP_PERSONAL_PHONE_NUMBER, QP_SIGNUP, count);
            signup.enterExtension(0, ExcelColumns.QP_PERSONAL_EXTENSION, QP_SIGNUP, count);

            signup.clickOnNextPanel();

            if (verification.verifyQPCreatedSuccessfully()) {
                success("Verify QP Registration completed successfully.");
            } else {
                failure("ERROR : Verify QP Registration completed successfully.");
            }

            if (verification.verifyQPUserNameDisplay()) {
                success("Verify QP Name display on the Dashboard.");
            } else {
                failure("ERROR : Verify QP Name display on the Dashboard.");
            }

            signup.clickLogout();
        }

        sa.assertAll();

    }
}
