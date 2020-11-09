package cleanfill.PageObjects;

import cleanfill.base.BaseClass;
import cleanfill.base.Generics;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedList;
import java.util.List;

public class SignupVerification extends BaseClass implements Validations, FieldOR {

    WebDriver localDriver;
    Generics generics;
    BatchPage batch;

    public SignupVerification(WebDriver baseDriver) {
        this.localDriver = baseDriver;
        PageFactory.initElements(baseDriver, this);
        generics = new Generics(baseDriver);
        batch = new BatchPage(baseDriver);
        log4j = Logger.getLogger(this.getClass().getName());
    }

    @FindBy(id = "email")
    public WebElement txtEmail;

    @FindBy(id = "newPassword")
    public WebElement txtPassword;

    @FindBy(id = "reenterPassword")
    public WebElement txtConfirmPassword;

    @FindBy(id = "givenName")
    public WebElement txtGivenName;

    @FindBy(id = "surname")
    public WebElement txtSurname;

    @FindBy(id = "passwordEntryMismatch")
    public WebElement lblPasswordMatchValidation;

    @FindBy(xpath = "//label[@for='newPassword']//following-sibling::div")
    public WebElement lblPasswordValidation;

    @FindBy(xpath = "//label[@for='reenterPassword']//following-sibling::div")
    public WebElement lblConfirmPasswordValidation;

    @FindBy(xpath = "//app-terms//h1")
    public WebElement lblTerms;

    @FindBy(id = "acceptTerms")
    public WebElement chkTerms;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement btnNext;

    @FindBy(xpath = "//mat-button-toggle//h2")
    public List<WebElement> lstBusinessTypes;

    @FindBy(xpath = "//div[contains(@class,'businessType-next')]")
    public WebElement btnBusinessTypeNext;

    @FindBy(xpath = "//panels//div[contains(@class,'panel-menu__option')]/span")
    public List<WebElement> lstSitePanels;

    @FindBy(xpath = "//input[@formcontrolname='name']")
    public List<WebElement> txtSiteName;

    @FindBy(xpath = "//input[@formcontrolname='postalCode']")
    public WebElement txtPostalCode;

    @FindBy(xpath = "//input[@role='combobox']")
    public WebElement txtAddress;

    @FindBy(xpath = "//div[contains(@class,'mat-tab-label-active')]/div")
    public WebElement tab;

    @FindBy(xpath = "//div[contains(@class,'ng-option')]")
    public List<WebElement> comboAddress;

    @FindBy(xpath = "//mat-select[@formcontrolname='provinceUniqueId']//span/span")
    public WebElement txtState;

    @FindBy(xpath = "//input[@formcontrolname='city']")
    public WebElement txtCity;

    @FindBy(xpath = "//input[@formcontrolname='municipalityName']")
    public WebElement txtMunicipality;

    @FindBy(xpath = "//input[@formcontrolname='phoneNumber']")
    public List<WebElement> txtPhoneNumber;

    @FindBy(xpath = "//input[@formcontrolname='extension']")
    public List<WebElement> txtExtension;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    public List<WebElement> txtEmailID;

    @FindBy(xpath = "//mat-checkbox")
    public WebElement checkSameAsAbove;

    @FindBy(xpath = "//p[contains(@class,'readOnlyContact')]")
    public List<WebElement> lstContact;

    @FindBy(xpath = "//registration-complete//h2")
    public WebElement lblSuccessfulSubmitRegistration;

    @FindBy(xpath = "//registration-complete//button[2]")
    public WebElement btnGoToHomepage;

    @FindBy(xpath = "//dashboard//h4")
    public WebElement lblUsername;

    @FindBy(xpath = "//input[@formcontrolname='registrationNumber']")
    public WebElement txtReceivingSiteRegNumber;

    @FindBy(xpath = "//mat-radio-group[@formcontrolname='visibilityToClients']//mat-radio-button[contains(@class,'mat-radio-checked')]//div[@class='company-visibility']/span[1]")
    public WebElement btnVisibilitySelection;

    @FindBy(xpath = "//mat-radio-group[@formcontrolname='isTPQPApprovalRequired']//mat-radio-button[contains(@class,'mat-radio-checked')]//div[@class='mat-radio-label-content']")
    public WebElement btnThirdPartyReportingSelection;

    @FindBy(xpath = "//h2[text()='Soil Classification']//following-sibling::mat-chip-list//mat-basic-chip")
    public List<WebElement> lblSoilClassification;

    @FindBy(xpath = "//div[contains(@class,'panel-navigation')]//button")
    public List<WebElement> btnPanelNavigation;

    public String getAcceptedSoilTypeLocator(String type) {
        return "//h2[text()='Accepted Soil Types']//following-sibling::mat-chip-list//mat-basic-chip[text()='" + type + "']";
    }

    public boolean verifyEmailFieldIsMandatory() {
        return generics.getAttribute(txtEmail, "required").equals("true");
    }

    public boolean verifyPasswordFieldIsMandatory() {
        return generics.getAttribute(txtPassword, "required").equals("true");
    }

    public boolean verifyConfirmPasswordFieldIsMandatory() {
        return generics.getAttribute(txtConfirmPassword, "required").equals("true");
    }

    //TODO - No validation currently for more than 50 chars
    public boolean verifyEmailAddressMaxCharValidation() {
        return false;
    }

    //TODO - No validation currently for more than 50 chars
    public boolean verifyGivenNameMaxCharValidation() {
        return false;
    }

    //TODO - No validation currently for more than 50 chars
    public boolean verifySurnameMaxCharValidation() {
        return false;
    }

    public boolean verifyPasswordValidationMessage() {
        testStepsLog(generics.getText(lblPasswordValidation));
        return generics.getText(lblPasswordValidation).equalsIgnoreCase(PASSWORD_VALIDATION) ||
                generics.getText(lblPasswordValidation).equalsIgnoreCase(PASSWORD_CHARACTER_VALIDATION);
    }

    public boolean verifyConfirmPasswordValidationMessage() {
        testStepsLog(generics.getText(lblConfirmPasswordValidation));
        return generics.getText(lblConfirmPasswordValidation).equalsIgnoreCase(PASSWORD_VALIDATION) ||
                generics.getText(lblConfirmPasswordValidation).equalsIgnoreCase(PASSWORD_CHARACTER_VALIDATION);
    }

    public boolean verifyPasswordMismatchValidation() {
        testStepsLog(generics.getText(lblPasswordMatchValidation));
        return generics.getText(lblPasswordMatchValidation).equalsIgnoreCase(PASSWORD_MISMATCH_VALIDATION);
    }

    public boolean verifyGivenNameFieldIsMandatory() {
        return generics.getAttribute(txtGivenName, "required").equals("true");
    }

    public boolean verifySurnameFieldIsMandatory() {
        return generics.getAttribute(txtSurname, "required").equals("true");
    }

    public boolean verifySignUpSuccess() {
        batch.waitTillPageLoad();
        testStepsLog(generics.getText(lblTerms));
        generics.scrollToBottom();
        return generics.isPresent(chkTerms) && generics.getAttribute(btnNext, "disabled").equalsIgnoreCase("true");
    }

    public boolean verifyNextButtonEnabled() {
        return !generics.getAttribute(btnNext, "disabled").equalsIgnoreCase("true");
    }

    public boolean verifyBusinessTypeListDisplay() {
        lstBusinessTypes.forEach(option -> testStepsLog(generics.getText(option)));
        return lstBusinessTypes.size() == 4;
    }

    public boolean verifyBusinessTypeNextButtonDisabled() {
        return generics.getAttribute(btnBusinessTypeNext, "class").contains("false");
    }

    public boolean verifyBusinessTypeNextButtonEnabled() {
        return generics.getAttribute(btnBusinessTypeNext, "class").contains("true");
    }

    public boolean verifySourceSitePanelDisplay() {
        batch.waitTillPageLoad();
        return generics.getText(lstSitePanels.get(2)).equalsIgnoreCase("Source Site") &&
                lstSitePanels.size() == 4;
    }

    public boolean verifyReceivingSitePanelDisplay() {
        batch.waitTillPageLoad();
        return generics.getText(lstSitePanels.get(2)).equalsIgnoreCase("Receiving Site") &&
                lstSitePanels.size() == 4;
    }


    public WebElement lblErrorMessage(String fieldName) {
        return localDriver.findElement(By.xpath("//h2[contains(text(),'" + fieldName + "')]" +
                "//following-sibling::mat-form-field//mat-error"));
    }

    public boolean verifyFieldIsMandatory(String fieldName) {
        testStepsLog(generics.getText(lblErrorMessage(fieldName)));
        return generics.getText(lblErrorMessage(fieldName)).equals(REQUIRED) ||
                generics.getText(lblErrorMessage(fieldName)).equals(ESTIMATED_WEIGHT_VOLUME_MANDATORY);
    }

    public boolean verifySourceSiteDisplay() {
        return generics.isPresent(txtSiteName.get(0)) && generics.isPresent(txtAddress) &&
                generics.isPresent(txtPostalCode);
    }

    public boolean verifyReceivingSiteDisplay() {
        return generics.isPresent(txtSiteName.get(0)) && generics.isPresent(txtAddress) &&
                generics.isPresent(txtPostalCode);
    }

    public boolean tabNameSameAsSourceSiteName() {
        return generics.getText(tab).trim().equalsIgnoreCase(SignupPage.sourceSiteName);
    }

    public boolean tabNameSameAsReceivingSiteName() {
        return generics.getText(tab).trim().equalsIgnoreCase(SignupPage.receivingSiteName);
    }

    public boolean verifyMaxCharacterSourceSiteThan(int number) {
        return generics.getValue(txtSiteName.get(0)).length() == number;
    }

    public boolean verifyMaxCharacterMunicipalityThan() {
        testStepsLog(generics.getText(lblErrorMessage("Municipality")));
        return generics.getText(lblErrorMessage("Municipality")).equals("No more than 100 characters are required");
    }

    public boolean verifyMaxCharacterFullNameThan() {
        testStepsLog(generics.getText(lblErrorMessage("Full Name")));
        return generics.getText(lblErrorMessage("Full Name")).equals("No more than 100 characters are required");
    }

    public boolean verifyAddressListDisplay() {
        List<String> lstAddress = new LinkedList<>();
        comboAddress.forEach(option -> lstAddress.add(generics.getText(option)));
        boolean bool = true;
        for (String address : lstAddress)
            if (!address.contains(SignupPage.SOURCE_SITE_ADDRESS.substring(0, 10))) {
                bool = false;
                break;
            }
        return bool;
    }

    public boolean verifyDetailsFilledWithAddress() {
        return !generics.getText(txtState).isEmpty() && !generics.getValue(txtCity).isEmpty() &&
                !generics.getValue(txtPostalCode).isEmpty();
    }

    public boolean verifyNonCADAddressNoFound() {
        return generics.getText(comboAddress.get(0)).equalsIgnoreCase("No items found");
    }

    public boolean verifyAddressDetailsUpdated() {
        return !generics.getText(txtState).equalsIgnoreCase(SignupPage.addressState) &&
                !generics.getValue(txtCity).equalsIgnoreCase(SignupPage.addressCity) &&
                !generics.getValue(txtPostalCode).equalsIgnoreCase(SignupPage.addressPostalCode);
    }

    public boolean verifyMunicipalityNameIsAdded() {
        return generics.getValue(txtMunicipality).equalsIgnoreCase(SignupPage.municipality);
    }

    public boolean verifyMaxCharacterPhoneNumber() {
        return generics.getValue(txtPhoneNumber.get(0)).length() == 10;
    }

    public boolean verifyPhoneNumberFormat() {
        String number = generics.getValue(txtPhoneNumber.get(0));
        return number.matches("\\([0-9]{3}\\) [0-9]{3} - [0-9]{4}");
    }

    public boolean verifyMaxCharacterExtension() {
        return generics.getValue(txtExtension.get(0)).length() == 5;
    }

    public boolean verifyExtensionFormat() {
        String number = generics.getValue(txtExtension.get(0));
        return number.matches("[0-9]{5}");
    }

    public boolean verifyPersonalInformationPanelDisplay() {
        return txtEmailID.size() == 2 && txtPhoneNumber.size() == 2 &&
                txtSiteName.size() == 2 && txtExtension.size() == 2 &&
                generics.isPresent(checkSameAsAbove);
    }

    public boolean verifyPersonalInformationCopiedToBillingInformation() {
        List<String> contactDetails = new LinkedList<>();
        lstContact.forEach(option -> contactDetails.add(generics.getText(option)));
        return contactDetails.get(0).equalsIgnoreCase(SignupPage.name) &&
                contactDetails.get(1).equalsIgnoreCase(SignupPage.email) &&
                contactDetails.get(2).equalsIgnoreCase(SignupPage.phoneNumber) &&
                contactDetails.get(3).equalsIgnoreCase(SignupPage.extNumber);
    }

    public boolean verifySourceSiteCreatedSuccessfully() {
        testStepsLog(generics.getText(lblSuccessfulSubmitRegistration));
        boolean bool = generics.getText(lblSuccessfulSubmitRegistration).equals("Registration Complete!");
        generics.clickOn(btnGoToHomepage);
        return bool;
    }

    public boolean verifySourceSiteUserNameDisplay() {
        return generics.getText(lblUsername).equalsIgnoreCase(SignupPage.givenName + " " + SignupPage.surName);
    }

    public boolean verifyReceivingSiteUserNameDisplay() {
        return generics.getText(lblUsername).equalsIgnoreCase(SignupPage.givenName + " " + SignupPage.surName);
    }

    public boolean verifyReceivingRegNumberIsOptional() {
        return generics.getAttribute(txtReceivingSiteRegNumber,
                "aria-required").equalsIgnoreCase("false");
    }

    public boolean verifyMaxCharactersInReceivingSiteRegNo() {
        return generics.getAttribute(txtReceivingSiteRegNumber,
                "aria-invalid").equalsIgnoreCase("true");
    }

    public boolean verifyRegistrationNoEntered() {
        return generics.getValue(txtReceivingSiteRegNumber).equalsIgnoreCase(SignupPage.receivingSiteRegNo) &&
                generics.getAttribute(txtReceivingSiteRegNumber,
                        "aria-invalid").equalsIgnoreCase("false");
    }

    public boolean verifyInvalidPostalCodeEntry() {
        testStepsLog(generics.getText(lblErrorMessage("Postal Code")));
        return generics.getText(lblErrorMessage("Postal Code")).equals("Invalid entry");
    }

    public boolean verifyCompanyVisibilitySelected() {
        return generics.isPresent(btnVisibilitySelection);
    }

    public boolean verifyThirdPartyReportingSelected() {
        return generics.isPresent(btnThirdPartyReportingSelection);
    }

    public boolean verifySoilClassificationDisplay() {
        return lblSoilClassification.size() == 4;
    }

    public boolean verifySoilClassificationSelected() {
        return localDriver.findElement(By.xpath("//h2[text()='Soil Classification']//" +
                "following-sibling::mat-chip-list//mat-basic-chip[text()=' " + SignupPage.soilClassification + " ']")).
                getAttribute("class").contains("chip-list-chip--active");
    }

    public boolean verifySoilClassificationDeselected() {
        return localDriver.findElements(By.xpath("//h2[text()='Soil Classification']//" +
                "following-sibling::mat-chip-list//mat-basic-chip[contains(@class,'chip-list-chip--active')]")).
                size() == 1;
    }

    public boolean verifyAcceptedSoilTypeIsMandatory() {
        return generics.getAttribute(btnPanelNavigation.get(0), "disabled").equalsIgnoreCase("true") &&
                generics.getAttribute(btnPanelNavigation.get(1), "disabled").equalsIgnoreCase("true");
    }

    public boolean verifyAcceptedSoilTypesList() {
        return generics.isPresent(getAcceptedSoilTypeLocator(SOIL_QTY_ALL_SOIL_TYPES_2)) &&
                generics.isPresent(getAcceptedSoilTypeLocator(SOIL_QTY_OREG153_T1)) &&
                generics.isPresent(getAcceptedSoilTypeLocator(SOIL_QTY_OREG153_T2)) &&
                generics.isPresent(getAcceptedSoilTypeLocator(SOIL_QTY_OREG153_T3)) &&
                generics.isPresent(getAcceptedSoilTypeLocator(SOIL_QTY_OREG153_T4)) &&
                generics.isPresent(getAcceptedSoilTypeLocator(SOIL_QTY_OREG153_T5)) &&
                generics.isPresent(getAcceptedSoilTypeLocator(SOIL_QTY_OREG153_T6)) &&
                generics.isPresent(getAcceptedSoilTypeLocator(SOIL_QTY_OREG153_T7)) &&
                generics.isPresent(getAcceptedSoilTypeLocator(SOIL_QTY_OREG153_T8)) &&
                generics.isPresent(getAcceptedSoilTypeLocator(SOIL_QTY_OREG153_T9)) &&
                generics.isPresent(getAcceptedSoilTypeLocator(SOIL_QTY_OREG406_T1_1)) &&
                generics.isPresent(getAcceptedSoilTypeLocator(SOIL_QTY_OREG406_T2_1)) &&
                generics.isPresent(getAcceptedSoilTypeLocator(SOIL_QTY_OREG406_T3_1)) &&
                generics.isPresent(getAcceptedSoilTypeLocator(SOIL_QTY_OREG406_T4_1)) &&
                generics.isPresent(getAcceptedSoilTypeLocator(SOIL_QTY_OREG406_T5_1)) &&
                generics.isPresent(getAcceptedSoilTypeLocator(SOIL_QTY_OREG406_T6_1)) &&
                generics.isPresent(getAcceptedSoilTypeLocator(SOIL_QTY_OREG406_T7_1)) &&
                generics.isPresent(getAcceptedSoilTypeLocator(SOIL_QTY_OREG406_T8_1)) &&
                generics.isPresent(getAcceptedSoilTypeLocator(SOIL_QTY_OREG406_T9_1));
    }

    public boolean verifyAllSoilTypesAreSelected() {
        return localDriver.findElements(By.xpath("//h2[text()='Accepted Soil Types']//" +
                "following-sibling::mat-chip-list//mat-basic-chip[contains(@class,'chip-list-chip--active')]")).
                size() == 19;
    }

    public boolean verifyAllSoilTypesAreDeselected() {
        return localDriver.findElements(By.xpath("//h2[text()='Accepted Soil Types']//" +
                "following-sibling::mat-chip-list//mat-basic-chip[contains(@class,'chip-list-chip--active')]")).
                isEmpty();
    }

    public boolean verifyAcceptedSoilTypesSelected() {
        return localDriver.findElements(By.xpath("//h2[text()='Accepted Soil Types']//" +
                "following-sibling::mat-chip-list//mat-basic-chip[contains(@class,'chip-list-chip--active')]")).
                size() == 2;
    }

    public boolean verifyReceivingSiteCreatedSuccessfully() {
        testStepsLog(generics.getText(lblSuccessfulSubmitRegistration));
        boolean bool = generics.getText(lblSuccessfulSubmitRegistration).equals("Registration Complete!");
        generics.clickOn(btnGoToHomepage);
        return bool;
    }
}