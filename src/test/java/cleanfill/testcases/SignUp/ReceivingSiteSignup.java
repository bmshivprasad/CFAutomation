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


}
