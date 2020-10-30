package cleanfill.PageObjects;

import cleanfill.base.Generics;
import cleanfill.testcases.SignUp.SignUp;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignupPage extends SignUp {

    WebDriver localDriver;
    Generics generics;

    public static String email = "";
    public static String password = "";
    public static String givenName = "";
    public static String surName = "";
    public static String sourceSiteName = "";
    public static String addressCity = "";
    public static String addressState = "";
    public static String addressPostalCode = "";
    public static String municipality = "";
    public static String name = "";
    public static String phoneNumber = "";
    public static String extNumber = "";

    public static final String SOURCE_SITE_ADDRESS = "90 Eglinton Avenue West, Suite 302";
    public static final String US_ADDRESS = "1819  Graystone Lakes Macon, GA, 31210";
    public static final String CANADA_ADDRESS = "20 Simmonds Dr, Dartmouth, NS B3B 1R3";

    public SignupPage(WebDriver baseDriver) {
        this.localDriver = baseDriver;
        PageFactory.initElements(baseDriver, this);
        generics = new Generics(baseDriver);
        log4j = Logger.getLogger(this.getClass().getName());
    }

    @FindBy(id = "createAccount")
    public WebElement btnSignUpNow;

    @FindBy(id = "continue")
    public WebElement btnCreate;

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

    @FindBy(id = "acceptTerms")
    public WebElement chkTerms;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement btnNext;

    @FindBy(xpath = "//mat-button-toggle//h2[text()='Source Site']")
    public WebElement btnSourceSite;

    @FindBy(xpath = "//mat-button-toggle//h2[text()='Receiving Site']")
    public WebElement btnReceivingSite;

    @FindBy(xpath = "//div[contains(@class,'businessType-next')]")
    public WebElement btnBusinessTypeNext;

    @FindBy(xpath = "//panels//div[contains(@class,'panel-menu__option')]")
    public List<WebElement> lstSourceSitePanels;

    @FindBy(xpath = "//input[@formcontrolname='name']")
    public WebElement txtCompanyName;

    @FindBy(xpath = "//input[@role='combobox']")
    public WebElement txtAddress;

    @FindBy(xpath = "//div[contains(@class,'ng-option')]")
    public WebElement comboAddress;

    @FindBy(xpath = "//div[contains(@class,'panel-navigation')]")
    public WebElement txtNextPanelButton;

    @FindBy(xpath = "//input[@formcontrolname='postalCode']")
    public WebElement txtPostalCode;

    @FindBy(xpath = "//mat-select[@formcontrolname='provinceUniqueId']//span/span")
    public WebElement txtState;

    @FindBy(xpath = "//input[@formcontrolname='city']")
    public WebElement txtCity;

    @FindBy(xpath = "//input[@formcontrolname='municipalityName']")
    public WebElement txtMunicipality;

    @FindBy(xpath = "//div[@role='tab']//mat-icon")
    public WebElement btnAddNewSite;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    public List<WebElement> txtEmailID;

    @FindBy(xpath = "//input[@formcontrolname='phoneNumber']")
    public List<WebElement> txtPhoneNumber;

    @FindBy(xpath = "//input[@formcontrolname='extension']")
    public List<WebElement> txtExtension;

    @FindBy(xpath = "//input[@formcontrolname='name']")
    public List<WebElement> txtSiteName;

    @FindBy(xpath = "//mat-checkbox")
    public WebElement checkSameAsAbove;

    public void clickOnSignUpNowButton() {
        testStepsLog("Click on Sign up now button.");
        generics.clickOn(btnSignUpNow);
    }

    public void clickOnCreateButton() {
        testStepsLog("Click on Create button.");
        generics.clickOn(btnCreate);
    }

    public void enterInvalidEmailAddress() {
        String email = generics.getRandomCharacters(50) + "@mailinator.com";
        testStepsLog("Enter email address more than 50 characters - " + email);
        generics.type(txtEmail, email);
    }

    public void enterValidEmailAddress() {
        email = generics.getRandomCharacters(10) + "@grr.la";
        testStepsLog("Enter email address - " + email);
        generics.type(txtEmail, email);
    }

    public void enterInvalidPassword() {
        String password = generics.getRandomCharacters(15).toLowerCase();
        testStepsLog("Enter Password - " + password);
        generics.type(txtPassword, password);
    }

    public void enterInvalidPasswordLength() {
        String password = generics.getRandomCharacters(3).toLowerCase() + "@123";
        testStepsLog("Enter Password - " + password);
        generics.type(txtPassword, password);
    }

    public void enterValidPassword() {
        password = generics.getRandomCharacters(2).toUpperCase() +
                generics.getRandomCharacters(3).toLowerCase() + "@123";
        testStepsLog("Enter Password - " + password);
        generics.type(txtPassword, password);
    }

    public void enterConfirmPassword() {
        String password = generics.getRandomCharacters(2).toUpperCase() +
                generics.getRandomCharacters(3).toLowerCase() + "@123";
        testStepsLog("Enter Confirm Password - " + password);
        generics.type(txtConfirmPassword, password);
    }

    public void enterInvalidConfirmPassword() {
        String password = generics.getRandomCharacters(15).toLowerCase();
        testStepsLog("Enter Confirm Password - " + password);
        generics.type(txtConfirmPassword, password);
    }

    public void enterInvalidConfirmPasswordLength() {
        String password = generics.getRandomCharacters(3).toLowerCase() + "@123";
        testStepsLog("Enter Confirm Password - " + password);
        generics.type(txtConfirmPassword, password);
    }

    public void enterValidConfirmPassword() {
        testStepsLog("Enter Confirm Password - " + password);
        generics.type(txtConfirmPassword, password);
    }

    public void enterMaxCharsForName() {
        String name = generics.getRandomCharacters(60);
        testStepsLog("Enter Given Name more than 50 characters - " + name);
        generics.type(txtGivenName, name);
    }

    public void enterMaxCharsForSurname() {
        String name = generics.getRandomCharacters(60);
        testStepsLog("Enter Surname more than 50 characters - " + name);
        generics.type(txtSurname, name);
    }

    public void enterValidGivenName() {
        givenName = generics.getRandomCharacters(8);
        testStepsLog("Enter Given Name - " + givenName);
        generics.type(txtGivenName, givenName);
    }

    public void enterValidSurname() {
        surName = generics.getRandomCharacters(8);
        testStepsLog("Enter Surname - " + surName);
        generics.type(txtSurname, surName);
    }

    public void clickOnTermsConditions() {
        generics.scrollToBottom();
        testStepsLog("Click on 'I agree with the Term & Conditions' checkbox.");
        generics.clickOn(chkTerms);
    }

    public void clickOnNextButton() {
        testStepsLog("Click on Next button.");
        generics.clickOn(btnNext);
    }

    public void completeSignUp() {
        clickOnSignUpNowButton();
        enterValidEmailAddress();
        enterValidPassword();
        enterValidConfirmPassword();
        enterValidGivenName();
        enterValidSurname();
        clickOnCreateButton();
    }

    public void selectSourceSiteAsBusinessType() {
        testStepsLog("Click on 'Source Site' button.");
        generics.clickOn(btnSourceSite);
    }

    public void selectReceivingSiteAsBusinessType() {
        testStepsLog("Click on 'Receiving Site' button.");
        generics.clickOn(btnReceivingSite);
    }

    public void clickOnNextBusinessType() {
        testStepsLog("Click on Next button.");
        generics.clickOn(btnBusinessTypeNext);
    }

    public void clickOnNextPanel() {
        testStepsLog("Click on Next button.");
        generics.clickOn(txtNextPanelButton);
    }

    public void clickOnCompanyName() {
        testStepsLog("Click on Company Name.");
        generics.clickOn(txtCompanyName);
    }

    public void clickOnPanel(int count) {
        new BatchPage(localDriver).waitTillPageLoad();
        testStepsLog("Click on Panel " + count);
        generics.clickOn(getPanel(count));
    }

    public WebElement getPanel(int count) {
        return lstSourceSitePanels.get(count - 1);
    }

    public void enterCompanyName() {
        String companyName = generics.getRandomCharacters(8);
        testStepsLog("Enter Company Name - " + companyName);
        generics.type(txtCompanyName, companyName);
    }

    public void enterAddress() {
        testStepsLog("Enter Address - " + SOURCE_SITE_ADDRESS);
        generics.type(txtAddress, SOURCE_SITE_ADDRESS);
        generics.pause(3);
        generics.clickOn(comboAddress);
        generics.pause(3);
    }

    public void enterMoreCharactersFoMunicipality(int number) {
        String data = generics.getRandomCharacters(number + generics.getRandomBetween(1, 9));
        testStepsLog("Enter Municipality : " + data);
        generics.type(txtMunicipality, data);
    }

    public void typeAddress() {
        testStepsLog("Enter Address - " + SOURCE_SITE_ADDRESS);
        generics.type(txtAddress, SOURCE_SITE_ADDRESS);
        generics.pause(3);
    }

    public void selectAddress() {
        generics.clickOn(comboAddress);
        generics.pause(3);
    }

    public void enterNoCADAddress() {
        testStepsLog("Enter Non Canadian Address - " + US_ADDRESS);
        generics.type(txtAddress, US_ADDRESS);
        generics.pause(3);
    }

    public void updatedAddressDetails() {
        testStepsLog("Enter New Address - " + CANADA_ADDRESS);
        generics.type(txtAddress, CANADA_ADDRESS);
        generics.pause(3);
        generics.clickOn(comboAddress);
        generics.pause(3);
    }

    public void getAddressDetails() {
        addressCity = generics.getValue(txtCity);
        addressState = generics.getText(txtState);
        addressPostalCode = generics.getValue(txtPostalCode);
    }

    public void enterMunicipality() {
        municipality = generics.getRandomCharacters(10);
        testStepsLog("Enter Municipality : " + municipality);
        generics.type(txtMunicipality, municipality);
    }

    public void clickOnAddNewSite() {
        generics.scrollToTop();
        testStepsLog("Click on Add Site.");
        generics.clickOn(btnAddNewSite);
    }

    public void enterSourceSiteName() {
        sourceSiteName = generics.getRandomCharacters(12);
        testStepsLog("Enter Source Site Name - " + sourceSiteName);
        generics.type(txtSiteName.get(0), sourceSiteName);
    }

    public void enterFullName(int index) {
        name = generics.getRandomCharacters(8) + " " + generics.getRandomCharacters(10);
        testStepsLog("Enter Full Name : " + name);
        generics.type(txtSiteName.get(index), name);
    }

    public void enterEmailID(int index) {
        email = generics.getRandomCharacters(8) + "@grr.la.com";
        testStepsLog("Enter Email ID : " + email);
        generics.type(txtEmailID.get(index), email);
    }

    public void enterPhoneNumber(int index) {
        phoneNumber = generics.getRandomBetween(10000, 99999) + "" + generics.getRandomBetween(10000, 99999);
        testStepsLog("Enter Phone Number - " + phoneNumber);
        generics.type(txtPhoneNumber.get(index), phoneNumber);
    }

    public void enterExtension(int index) {
        extNumber = String.valueOf(generics.getRandomBetween(10000, 99999));
        testStepsLog("Enter Extension - " + extNumber);
        generics.type(txtExtension.get(index), extNumber);
    }

    public void clickOnSourceSiteName(int index) {
        testStepsLog("Click on Source Site Name.");
        generics.clickOn(txtSiteName.get(index));
    }

    public void clickOnFullName(int index) {
        testStepsLog("Click on Full Name.");
        generics.clickOn(txtSiteName.get(index));
    }

    public void clickOnPhone(int index) {
        testStepsLog("Click on Phone.");
        generics.clickOn(txtPhoneNumber.get(index));
    }

    public void clickOnEmail(int index) {
        testStepsLog("Click on Email ID.");
        generics.clickOn(txtEmailID.get(index));
    }

    public void enterMaxPhoneNumber(int index) {
        String phoneNumber = generics.getRandomBetween(100000, 999999) + "" + generics.getRandomBetween(100000, 999999);
        testStepsLog("Enter Phone Number - " + phoneNumber);
        generics.type(txtPhoneNumber.get(index), phoneNumber);
    }

    public void enterInvalidExtension(int index) {
        String extNumber = String.valueOf(generics.getRandomBetween(1000000, 9999999));
        testStepsLog("Enter Extension - " + extNumber);
        generics.type(txtExtension.get(index), extNumber);
    }

    public void enterMoreCharactersForSourceSiteThan(int number, int index) {
        String data = generics.getRandomCharacters(number + generics.getRandomBetween(1, 9));
        testStepsLog("Enter Source Site Name : " + data);
        generics.type(txtSiteName.get(index), data);
    }

    public void enterMaxCharsForFullName(int index) {
        String name = generics.getRandomCharacters(51) + " " + generics.getRandomCharacters(51);
        testStepsLog("Enter Full Name : " + name);
        generics.type(txtSiteName.get(index), name);
    }

    public void checkOnSameAsAbove() {
        testStepsLog("Click on Same as above.");
        generics.clickOn(checkSameAsAbove);
    }

    public boolean isBillingSameAsAbove() {
        return generics.getRandomBoolean();
    }

}