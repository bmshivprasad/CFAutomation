package cleanfill.PageObjects;

import cleanfill.base.Generics;
import cleanfill.testcases.SignUp.SignUp;
import cleanfill.utilities.ExcelColumns;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SignupPage extends SignUp {

    WebDriver localDriver;
    Generics generics;

    public static int index = 0;

    public static String email = "";
    public static String password = "";
    public static String givenName = "";
    public static String surName = "";
    public static String sourceSiteName = "";
    public static String receivingSiteName = "";
    public static String receivingSiteRegNo = "";
    public static String companyVisibility = "";
    public static String thirdPartyVisibility = "";
    public static String addressCity = "";
    public static String addressState = "";
    public static String addressPostalCode = "";
    public static String municipality = "";
    public static String name = "";
    public static String phoneNumber = "";
    public static String extNumber = "";
    public static String soilClassification = "";
    public static String acceptedSoilType = "";

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

    @FindBy(xpath = "//mat-button-toggle//h2[text()='Qualified Person (QPs)']")
    public WebElement btnQualifiedPerson;

    @FindBy(xpath = "//div[contains(@class,'businessType-next')]")
    public WebElement btnBusinessTypeNext;

    @FindBy(xpath = "//panels//div[contains(@class,'panel-menu__option')]")
    public List<WebElement> lstSourceSitePanels;

    @FindBy(xpath = "//input[@formcontrolname='name']")
    public WebElement txtCompanyName;

    @FindBy(xpath = "//input[@formcontrolname='pgoNumber']")
    public WebElement txtPGO;

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

    @FindBy(xpath = "//input[@formcontrolname='registrationNumber']")
    public WebElement txtReceivingSiteRegNumber;

    @FindBy(xpath = "//mat-radio-group[@formcontrolname='visibilityToClients']//mat-radio-button//div[@class='company-visibility']/span[1]")
    public List<WebElement> btnVisibility;

    @FindBy(xpath = "//mat-radio-group[@formcontrolname='isTPQPApprovalRequired']//mat-radio-button//div[@class='mat-radio-label-content']")
    public List<WebElement> btnThirdPartyReporting;

    @FindBy(xpath = "//h2[text()='Soil Classification']//following-sibling::mat-chip-list//mat-basic-chip")
    public List<WebElement> lblSoilClassification;

    @FindBy(xpath = "//div[@role='tab']//div[text()=' New Source Site ']")
    public WebElement btnNewSourceSiteTab;

    @FindBy(xpath = "//div[@role='tab']//div[text()=' New Receiving Site ']")
    public WebElement btnNewReceivingSiteTab;

    @FindBy(xpath = "//div[contains(@class,'panel-navigation')]//button")
    public List<WebElement> btnPanelNavigation;

    @FindBy(xpath = "//h2[text()='Accepted Soil Types']//following-sibling::mat-chip-list//mat-basic-chip")
    public List<WebElement> lblAcceptedSoilTypes;

    @FindBy(xpath = "//mat-radio-button//div[@class='mat-radio-label-content']")
    public List<WebElement> btnQPType;

    @FindBy(xpath = "//span[@class='logout-round']")
    public WebElement btnLogout;

    public WebElement getAcceptedSoilTypeLocator(String type) {
        return localDriver.findElement(By.xpath("//h2[text()='Accepted Soil Types']" +
                "//following-sibling::mat-chip-list//mat-basic-chip[text()='" + type + "']"));
    }

    public WebElement getSoilClassification(String type) {
        return localDriver.findElement(By.xpath("//h2[text()='Soil Classification']" +
                "//following-sibling::mat-chip-list//mat-basic-chip[text()=' " + type + " ']"));
    }

    public void clickOnSignUpNowButton() {
        testStepsLog("Click on Sign up now button.");
        generics.clickOn(btnSignUpNow);
    }

    public void clickOnCreateButton() {
        testStepsLog("Click on Create button.");
        generics.clickOn(btnCreate);
    }

    public void enterInvalidEmailAddress() {
        String email = generics.getRandomCharacters(50) + "@grr.la";
        testStepsLog("Enter email address more than 50 characters - " + email);
        generics.type(txtEmail, email);
    }

    public void enterValidEmailAddress() {
        email = generics.getRandomCharacters(10) + "@grr.la";
        testStepsLog("Enter email address - " + email);
        generics.type(txtEmail, email);
    }

    public void enterValidEmailAddress(String type, int count) {
        email = excelUtils.getTestData(TEST_DATA, type, count, ExcelColumns.SIGNUP_EMAIL);
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

    public void enterValidPassword(String type, int count) {
        password = excelUtils.getTestData(TEST_DATA, type, count, ExcelColumns.SIGNUP_PASSWORD);
        testStepsLog("Enter Password - " + password);
        generics.type(txtPassword, password);
    }

    public void enterConfirmPassword(String type, int count) {
        String password = excelUtils.getTestData(TEST_DATA, type, count, ExcelColumns.SIGNUP_PASSWORD);
        testStepsLog("Enter Confirm Password - " + password);
        generics.type(txtConfirmPassword, password);
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

    public void enterValidGivenName(String type, int count) {
        givenName = excelUtils.getTestData(TEST_DATA, type, count, ExcelColumns.SIGNUP_GIVENNAME);
        testStepsLog("Enter Given Name - " + givenName);
        generics.type(txtGivenName, givenName);
    }

    public void enterValidSurname(String type, int count) {
        surName = excelUtils.getTestData(TEST_DATA, type, count, ExcelColumns.SIGNUP_SURNAME);
        testStepsLog("Enter Surname - " + surName);
        generics.type(txtSurname, surName);
    }

    public void clickOnTermsConditions() {
        generics.scrollToBottom();
        new WebDriverWait(localDriver, WEBDRIVER_WAIT).
                until(ExpectedConditions.elementToBeClickable(chkTerms));
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

    public void completeSignUp(String type, int count) {
        clickOnSignUpNowButton();
        enterValidEmailAddress(type, count);
        enterValidPassword(type, count);
        enterConfirmPassword(type, count);
        enterValidGivenName(type, count);
        enterValidSurname(type, count);
        clickOnCreateButton();
    }

    public void selectSourceSiteAsBusinessType() {
        new WebDriverWait(localDriver, WEBDRIVER_WAIT).
                until(ExpectedConditions.elementToBeClickable(btnSourceSite));
        testStepsLog("Click on 'Source Site' button.");
        generics.clickOn(btnSourceSite);
    }

    public void selectReceivingSiteAsBusinessType() {
        new WebDriverWait(localDriver, WEBDRIVER_WAIT).
                until(ExpectedConditions.elementToBeClickable(btnReceivingSite));
        testStepsLog("Click on 'Receiving Site' button.");
        generics.clickOn(btnReceivingSite);
    }

    public void selectQualifiedPersonAsBusinessType() {
        new WebDriverWait(localDriver, WEBDRIVER_WAIT).
                until(ExpectedConditions.elementToBeClickable(btnQualifiedPerson));
        testStepsLog("Click on 'Qualified Person' button.");
        generics.clickOn(btnQualifiedPerson);
    }

    public void clickOnNextBusinessType() {
        testStepsLog("Click on Next button.");
        generics.clickOn(btnBusinessTypeNext);
    }

    public void clickOnNextPanel() {
        testStepsLog("Click on Next button.");
        generics.clickOn(txtNextPanelButton);
    }

    public void clickOnNextPanelNavigation() {
        testStepsLog("Click on Next button.");
        generics.clickOn(btnPanelNavigation.get(0));
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
        generics.pause(3);
        String companyName = generics.getRandomCharacters(8);
        testStepsLog("Enter Company Name - " + companyName);
        generics.type(txtCompanyName, companyName);
    }

    public void enterCompanyName(int company, String type, int count) {
        generics.pause(3);
        String companyName = excelUtils.getTestData(TEST_DATA, type, count, company);
        testStepsLog("Enter Company Name - " + companyName);
        generics.type(txtCompanyName, companyName);
    }

    public void enterPGOName() {
        generics.pause(3);
        String pgo = generics.getRandomCharacters(8);
        testStepsLog("Enter PGO - " + pgo);
        generics.type(txtPGO, pgo);
    }

    public void enterPGOName(String type, int count) {
        generics.pause(3);
        String pgo = excelUtils.getTestData(TEST_DATA, type, count, ExcelColumns.QP_PGO);
        testStepsLog("Enter PGO - " + pgo);
        generics.type(txtPGO, pgo);
    }

    public void enterAddress() {
        testStepsLog("Enter Address - " + SOURCE_SITE_ADDRESS);
        generics.type(txtAddress, SOURCE_SITE_ADDRESS);
        generics.pause(5);
        generics.clickOn(comboAddress);
        generics.pause(3);
    }

    public void enterAddress(int addressType, String type, int count) {
        String address = excelUtils.getTestData(TEST_DATA, type, count, addressType);
        testStepsLog("Enter Address - " + address);
        generics.type(txtAddress, address);
        generics.pause(5);
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

    public void enterMunicipality(int municipalType, String type, int count) {
        municipality = excelUtils.getTestData(TEST_DATA, type, count, municipalType);
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

    public void enterSourceSiteName(String type, int count) {
        sourceSiteName = excelUtils.getTestData(TEST_DATA, type, count, ExcelColumns.SOURCE_SITE_NAME);
        testStepsLog("Enter Source Site Name - " + sourceSiteName);
        generics.type(txtSiteName.get(0), sourceSiteName);
    }

    public void enterReceivingSiteName(String type, int count) {
        receivingSiteName = excelUtils.getTestData(TEST_DATA, type, count, ExcelColumns.RECEIVING_SITE_NAME);
        testStepsLog("Enter Receiving Site Name - " + receivingSiteName);
        generics.type(txtSiteName.get(0), receivingSiteName);
    }

    public void enterReceivingSiteName() {
        receivingSiteName = generics.getRandomCharacters(12);
        testStepsLog("Enter Receiving Site Name - " + receivingSiteName);
        generics.type(txtSiteName.get(0), receivingSiteName);
    }

    public void enterFullName(int index) {
        name = generics.getRandomCharacters(8) + " " + generics.getRandomCharacters(10);
        testStepsLog("Enter Full Name : " + name);
        generics.type(txtSiteName.get(index), name);
    }

    public void enterFullName(int index, int nameType, String type, int count) {
        name = excelUtils.getTestData(TEST_DATA, type, count, nameType);
        testStepsLog("Enter Full Name : " + name);
        generics.type(txtSiteName.get(index), name);
    }

    public void enterEmailID(int index, int mailType, String type, int count) {
        email = excelUtils.getTestData(TEST_DATA, type, count, mailType);
        testStepsLog("Enter Email ID : " + email);
        generics.type(txtEmailID.get(index), email);
    }

    public void enterEmailID(int index) {
        email = generics.getRandomCharacters(8) + "@grr.la";
        testStepsLog("Enter Email ID : " + email);
        generics.type(txtEmailID.get(index), email);
    }

    public void enterPhoneNumber(int index) {
        phoneNumber = generics.getRandomBetween(10000, 99999) + "" + generics.getRandomBetween(10000, 99999);
        testStepsLog("Enter Phone Number - " + phoneNumber);
        generics.type(txtPhoneNumber.get(index), phoneNumber);
    }

    public void enterPhoneNumber(int index, int phoneType, String type, int count) {
        phoneNumber = excelUtils.getTestData(TEST_DATA, type, count, phoneType);
        testStepsLog("Enter Phone Number - " + phoneNumber);
        generics.type(txtPhoneNumber.get(index), phoneNumber);
    }

    public void enterExtension(int index) {
        extNumber = String.valueOf(generics.getRandomBetween(10000, 99999));
        testStepsLog("Enter Extension - " + extNumber);
        generics.type(txtExtension.get(index), extNumber);
    }

    public void enterExtension(int index, int extType, String type, int count) {
        extNumber = excelUtils.getTestData(TEST_DATA, type, count, extType);
        testStepsLog("Enter Extension - " + extNumber);
        generics.type(txtExtension.get(index), extNumber);
    }

    public void clickOnSourceSiteName(int index) {
        testStepsLog("Click on Source Site Name.");
        generics.clickOn(txtSiteName.get(index));
    }

    public void clickOnReceivingSiteName(int index) {
        testStepsLog("Click on Receiving Site Name.");
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
        testStepsLog("Enter Site Name : " + data);
        generics.type(txtSiteName.get(index), data);
    }

    public void enterMoreCharactersForReceivingSiteRegNoThan(int number) {
        String data = generics.getRandomCharacters(number + generics.getRandomBetween(1, 9));
        testStepsLog("Enter Registration Number : " + data);
        generics.type(txtReceivingSiteRegNumber, data);
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

    public boolean isBillingSameAsAbove(int billingType, String type, int count) {
        String condition = excelUtils.getTestData(TEST_DATA, type, count, billingType);
        return condition.equalsIgnoreCase("YES");
    }

    public void enterReceivingSiteRegNumber(String type, int count) {
        receivingSiteRegNo = excelUtils.getTestData(TEST_DATA, type, count, ExcelColumns.RECEIVING_SITE_NUMBER);
        testStepsLog("Enter Registration Number : " + receivingSiteRegNo);
        generics.type(txtReceivingSiteRegNumber, receivingSiteRegNo);
    }

    public void enterReceivingSiteRegNumber() {
        receivingSiteRegNo = generics.getRandomCharacters(10).toUpperCase() + generics.getRandomBetween(10000, 99999);
        testStepsLog("Enter Registration Number : " + receivingSiteRegNo);
        generics.type(txtReceivingSiteRegNumber, receivingSiteRegNo);
    }

    public void enterPostalCode() {
        addressPostalCode = String.valueOf(generics.getRandomBetween(10000, 99999));
        testStepsLog("Enter Postal Code : " + addressPostalCode);
        generics.type(txtPostalCode, addressPostalCode);
    }

    public void enterInvalidPostalCode() {
        addressPostalCode = String.valueOf(generics.getRandomBetween(100, 999));
        testStepsLog("Enter Postal Code : " + addressPostalCode);
        generics.type(txtPostalCode, addressPostalCode);
    }

    public void selectVisibility() {
        int index = generics.getRandomBetween(0, 1);
        generics.clickOn(btnVisibility.get(index));
        companyVisibility = generics.getText(btnVisibility.get(index));
        testStepsLog("Select 'Company’s Visibility To Clients' as : " + companyVisibility);
    }

    public void selectVisibility(String type, int count) {
        companyVisibility = excelUtils.getTestData(TEST_DATA, type, count, ExcelColumns.RECEIVING_SITE_VISIBILITY);
        if (companyVisibility.equalsIgnoreCase("public")) generics.clickOn(btnVisibility.get(0));
        else generics.clickOn(btnVisibility.get(1));
        testStepsLog("Select 'Company’s Visibility To Clients' as : " + companyVisibility);
    }

    public void selectThirdPartyReporting(String type, int count) {
        thirdPartyVisibility = excelUtils.getTestData(TEST_DATA, type, count, ExcelColumns.RECEIVING_SITE_THIRD_PARTY_REPORTING);
        if (thirdPartyVisibility.equalsIgnoreCase("yes")) {
            generics.clickOn(btnThirdPartyReporting.get(0));
            generics.clickOn(btnThirdPartyReporting.get(0));
        } else {
            generics.clickOn(btnThirdPartyReporting.get(1));
            generics.clickOn(btnThirdPartyReporting.get(1));
        }
        testStepsLog("Select 'Does this site require 3rd party reporting?' as : " + thirdPartyVisibility);
    }

    public void selectThirdPartyReporting() {
        int index = generics.getRandomBetween(0, 1);
        generics.clickOn(btnThirdPartyReporting.get(index));
        thirdPartyVisibility = generics.getText(btnThirdPartyReporting.get(index));
        testStepsLog("Select 'Does this site require 3rd party reporting?' as : " + thirdPartyVisibility);
    }

    public void clickOnNewSourceTab() {
        testStepsLog("Click on New Source Site Tab.");
        generics.clickOn(btnNewSourceSiteTab);
        new BatchPage(localDriver).waitTillPageLoad();
    }

    public void clickOnNewReceivingTab() {
        testStepsLog("Click on New Receiving Site Tab.");
        generics.clickOn(btnNewReceivingSiteTab);
        new BatchPage(localDriver).waitTillPageLoad();
    }

    public void selectAnySoilClassification() {
        index = generics.getRandomBetween(0, lblSoilClassification.size() - 1);
        generics.clickOn(lblSoilClassification.get(index));
        soilClassification = generics.getText(lblSoilClassification.get(index));
        testStepsLog("Select Soil Classification as : " + soilClassification);
    }

    public void selectAnySoilClassification(String type, int count) {
        soilClassification = excelUtils.getTestData(TEST_DATA, type, count, ExcelColumns.RECEIVING_SITE_SOIL_CLASSIFICATION);
        generics.clickOn(getSoilClassification(soilClassification));
        testStepsLog("Select Soil Classification as : " + soilClassification);
    }

    public void clickOnAllSoilType() {
        generics.clickOn(getAcceptedSoilTypeLocator(SOIL_QTY_ALL_SOIL_TYPES_2));
        acceptedSoilType = SOIL_QTY_ALL_SOIL_TYPES_2;
        testStepsLog("Select Accepted Soil Type as : " + acceptedSoilType);
    }

    public void selectAnySoilTypes() {
        int prevIndex = index;
        for (int i = 0; i < 2; i++) {
            while (prevIndex == index) {
                index = generics.getRandomBetween(1, lblAcceptedSoilTypes.size() - 1);
            }
            generics.clickOn(lblAcceptedSoilTypes.get(index));
            acceptedSoilType = acceptedSoilType.concat(", " + generics.getText(lblAcceptedSoilTypes.get(index)));
            prevIndex = index;
        }
        testStepsLog("Select Accepted Soil Types as : " + acceptedSoilType);
    }

    public void selectIndividual() {
        testStepsLog("Click on Individual option.");
        generics.clickOn(btnQPType.get(0));
    }

    public void selectCompany() {
        testStepsLog("Click on Company option.");
        generics.clickOn(btnQPType.get(1));
    }

    public boolean isCompanyUser() {
        if (generics.getRandomBoolean()) {
            selectCompany();
            return true;
        } else {
            selectIndividual();
            return false;
        }
    }

    public void selectUserTye(int company, String type, int count) {
        String companyName = excelUtils.getTestData(TEST_DATA, type, count, ExcelColumns.QP_COMPANY_NAME);
        if (companyName.isEmpty()) {
            selectIndividual();
            enterPGOName(type, count);
        } else {
            selectCompany();
            enterCompanyName(company, type, count);
        }
    }

    public void clickLogout() {
        generics.pause(10);
        testStepsLog("Click on Logout Button.");
        generics.scrollToTop();
        generics.clickOn(btnLogout);
        new BatchPage(localDriver).waitTillPageLoad();
    }

    public int getLastRow(String type) {
        return excelUtils.lastRowNumber(TEST_DATA, type);
    }
}