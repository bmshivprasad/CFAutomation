package cleanfill.testcases.SignUp;

import cleanfill.PageObjects.*;
import cleanfill.base.BaseClass;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class SignUp extends BaseClass {

    public SignUp() {
        log4j = Logger.getLogger(this.getClass().getName());
    }

    @Test
    public void verify_email_address_validations_for_signup() {

        testCaseLog("Verify Email Address validation for the signup.");

        SignupPage signup = new SignupPage(driver);
        SignupVerification verification = new SignupVerification(driver);

        signup.clickOnSignUpNowButton();
        signup.clickOnCreateButton();

        if (verification.verifyEmailFieldIsMandatory()) {
            success("Verify Email field is mandatory.");
        } else {
            failure("ERROR : Verify Email field is mandatory.");
        }

        signup.enterInvalidEmailAddress();

        if (verification.verifyEmailAddressMaxCharValidation()) {
            success("Verify max characters validation for email address.");
        } else {
            failure("ERROR : Verify max characters validation for email address.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_password_validations_for_signup() {

        testCaseLog("Verify Password validation for the signup.");

        SignupPage signup = new SignupPage(driver);
        SignupVerification verification = new SignupVerification(driver);

        signup.clickOnSignUpNowButton();
        signup.clickOnCreateButton();

        if (verification.verifyPasswordFieldIsMandatory()) {
            success("Verify Password field is mandatory.");
        } else {
            failure("ERROR : Verify Password field is mandatory.");
        }

        signup.enterInvalidPassword();

        if (verification.verifyPasswordValidationMessage()) {
            success("Verify max characters validation for password.");
        } else {
            failure("ERROR : Verify max characters validation for password.");
        }

        signup.enterInvalidPasswordLength();

        if (verification.verifyPasswordValidationMessage()) {
            success("Verify invalid password validation.");
        } else {
            failure("ERROR : Verify invalid password validation.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_confirm_password_validations_for_signup() {

        testCaseLog("Verify Confirm Password validation for the signup.");

        SignupPage signup = new SignupPage(driver);
        SignupVerification verification = new SignupVerification(driver);

        signup.clickOnSignUpNowButton();
        signup.clickOnCreateButton();

        if (verification.verifyConfirmPasswordFieldIsMandatory()) {
            success("Verify Confirm Password field is mandatory.");
        } else {
            failure("ERROR : Verify Confirm Password field is mandatory.");
        }

        signup.enterValidPassword();
        signup.enterInvalidConfirmPassword();

        if (verification.verifyConfirmPasswordValidationMessage()) {
            success("Verify max characters validation for confirm password.");
        } else {
            failure("ERROR : Verify max characters validation for confirm password.");
        }

        signup.enterInvalidConfirmPasswordLength();

        if (verification.verifyConfirmPasswordValidationMessage()) {
            success("Verify invalid confirm password validation.");
        } else {
            failure("ERROR : Verify invalid confirm password validation.");
        }

        signup.enterConfirmPassword();
        signup.clickOnCreateButton();

        if (verification.verifyPasswordMismatchValidation()) {
            success("Verify password mistmatch validation message display.");
        } else {
            failure("ERROR : Verify password mistmatch validation message display.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_given_name_validations_for_signup() {

        testCaseLog("Verify Given Name validation for the signup.");

        SignupPage signup = new SignupPage(driver);
        SignupVerification verification = new SignupVerification(driver);

        signup.clickOnSignUpNowButton();
        signup.clickOnCreateButton();

        if (verification.verifyGivenNameFieldIsMandatory()) {
            success("Verify Given Name field is mandatory.");
        } else {
            failure("ERROR : Verify Given Name field is mandatory.");
        }

        signup.enterMaxCharsForName();

        if (verification.verifyGivenNameMaxCharValidation()) {
            success("Verify max characters validation for given name.");
        } else {
            failure("ERROR : Verify max characters validation for given name.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_surname_validations_for_signup() {

        testCaseLog("Verify Surname validation for the signup.");

        SignupPage signup = new SignupPage(driver);
        SignupVerification verification = new SignupVerification(driver);

        signup.clickOnSignUpNowButton();
        signup.clickOnCreateButton();

        if (verification.verifySurnameFieldIsMandatory()) {
            success("Verify Surname field is mandatory.");
        } else {
            failure("ERROR : Verify Surname field is mandatory.");
        }

        signup.enterMaxCharsForSurname();

        if (verification.verifySurnameMaxCharValidation()) {
            success("Verify max characters validation for surname.");
        } else {
            failure("ERROR : Verify max characters validation for surname.");
        }

        sa.assertAll();

    }

    @Test
    public void verify_user_complete_signup_process() {

        testCaseLog("Verify User completes Signup process.");

        SignupPage signup = new SignupPage(driver);
        SignupVerification verification = new SignupVerification(driver);

        for (int count = 1; count <= signup.getLastRow(SIGNUP); count++) {

            signup.clickOnSignUpNowButton();
            signup.enterValidEmailAddress(SIGNUP, count);
            signup.enterValidPassword(SIGNUP, count);
            signup.enterConfirmPassword(SIGNUP, count);
            signup.enterValidGivenName(SIGNUP, count);
            signup.enterValidSurname(SIGNUP, count);

            signup.clickOnCreateButton();

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

            signup.clickLogout();
        }

        sa.assertAll();

    }

}
