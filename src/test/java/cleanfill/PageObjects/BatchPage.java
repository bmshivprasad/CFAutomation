package cleanfill.PageObjects;

import cleanfill.base.BaseClass;
import cleanfill.base.Generics;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BatchPage extends BaseClass implements Validations, FieldOR {

    WebDriver localDriver;
    Generics generics;

    public static String _batchName = "";
    public static String _selectedValue = "";
    public static String _soilQuality = "";

    public BatchPage(WebDriver baseDriver) {
        this.localDriver = baseDriver;
        PageFactory.initElements(baseDriver, this);
        generics = new Generics(baseDriver);
        log4j = Logger.getLogger("BatchPage");
    }

    @FindBy(xpath = "//button//span[contains(text(),'New Batch Request ')]")
    public WebElement btnNewBatchRequest;

    @FindBy(xpath = "//input[@formcontrolname='estimatedStartDate']")
    public WebElement txtEstDate;

    @FindBy(xpath = "//input[@formcontrolname='batchName']")
    public WebElement txtBatchName;

    @FindBy(xpath = "//input[@formcontrolname='batchId']")
    public WebElement txtBatchId;

    @FindBy(xpath = "//panels//div[contains(@class,'panel-menu__option')]")
    public List<WebElement> lstBatchPanels;

    @FindBy(xpath = "//button[@aria-label='Open calendar']")
    public WebElement btnCalender;

    @FindBy(xpath = "//p[contains(@class,'batch-identifiers__name')]")
    public WebElement lblBatchName;

    @FindBy(xpath = "//button//span[contains(text(),'Next')]")
    public WebElement btnNext;

    @FindBy(xpath = "//mat-radio-group//label")
    public List<WebElement> lstRadioLabel;

    @FindBy(xpath = "//input[@formcontrolname='estimatedLoads']")
    public WebElement txtEstLoads;

    @FindBy(xpath = "//input[@formcontrolname='estimatedWeight']")
    public WebElement txtEstWeight;

    @FindBy(xpath = "//input[@formcontrolname='estimatedVolume']")
    public WebElement txtEstVolume;

    @FindBy(xpath = "//ng-select[@formcontrolname='sourceSite']//input")
    public WebElement selectSourceSite;

    @FindBy(xpath = "//ng-select[@attr.data-meta='SourceTypeDD']//input")
    public WebElement selectSourceType;

    @FindBy(xpath = "//ng-select[@attr.data-meta='SourceSiteHistoryDD']//input")
    public WebElement selectSiteHistory;

    @FindBy(xpath = "//ng-select[@formcontrolname='primaryContact']//input")
    public WebElement selectPrimaryContact;

    @FindBy(xpath = "//ng-select[@formcontrolname='assignedQp']//input")
    public WebElement selectQualifiedPerson;

    @FindBy(xpath = "//ng-dropdown-panel//div[contains(@class,'ng-option')]//span")
    public List<WebElement> lstDropdownValues;

    @FindBy(xpath = "//div[@id='spinner']")
    public WebElement spinner;

    @FindBy(xpath = "//input[@formcontrolname='sourceTypeOther']")
    public WebElement txtSourceTypeOther;

    @FindBy(xpath = "//input[@formcontrolname='siteHistoryOther']")
    public WebElement txtSiteHistoryOther;

    @FindBy(xpath = "//input[@formcontrolname='presentUse']")
    public WebElement txtPresentUse;

    @FindBy(xpath = "//ng-select[@formcontrolname='soilDescription']//input")
    public WebElement selectSoilDescription;

    @FindBy(xpath = "//common-dropdown[contains(@class,'batch-soilQuality-Type')]//ng-select//input")
    public WebElement selectSoilQuality;

    @FindBy(xpath = "//common-dropdown[contains(@class,'batch-soilQuality-Type')]//ng-select//span[contains(@class,'ng-value-label')]")
    public WebElement lblSelectedSoilQuality;

    public WebElement getPanel(int count) {
        return lstBatchPanels.get(count - 1);
    }

    public WebElement getFieldElement(String fieldName) {
        WebElement element = null;
        switch (fieldName) {
            case ESTIMATED_LOADS:
                element = txtEstLoads;
                break;
            case ESTIMATED_WEIGHT:
                element = txtEstWeight;
                break;
            case ESTIMATED_VOLUME:
                element = txtEstVolume;
                break;
            case BATCH_ID:
                element = txtBatchId;
                break;
            case BATCH_NAME:
                element = txtBatchName;
                break;
            case CALENDER:
                element = btnCalender;
                break;
            case NEXT_STEP_1:
                element = btnNext;
                break;
            case ESTIMATED_START_DATE:
                element = txtEstDate;
                break;
            case SOURCE_SITE:
                element = selectSourceSite;
                break;
            case SOURCE_TYPE:
                element = selectSourceType;
                break;
            case SITE_HISTORY:
                element = selectSiteHistory;
                break;
            case PRIMARY_CONTACT:
                element = selectPrimaryContact;
                break;
            case QUALIFIED_PERSON:
                element = selectQualifiedPerson;
                break;
            case SOURCE_TYPE_OTHER:
                element = txtSourceTypeOther;
                break;
            case SITE_HISTORY_OTHER:
                element = txtSiteHistoryOther;
                break;
            case PRESENT_USE:
                element = txtPresentUse;
                break;
            case SOIL_DESCRIPTION:
                element = selectSoilDescription;
                break;
            case SOIL_QUALITY:
                element = selectSoilQuality;
                break;
        }
        return element;
    }

    public void waitTillPageLoad() {
        while (generics.isPresent(spinner)) generics.pause(1);
    }

    public void clickOnNewBatchRequest() {
        testStepsLog("Click on New Batch Request button.");
        generics.clickOn(btnNewBatchRequest);
        generics.pause(1);
    }

    public void clickOnField(String fieldName) {
        testStepsLog("Click on " + fieldName);
        generics.clickOn(getFieldElement(fieldName));
        generics.pause(1);
    }

    public void clickOnPanel(int count) {
        testStepsLog("Click on Panel " + count);
        generics.clickOn(getPanel(count));
        generics.pause(1);
    }

    public void selectPastDate() {
        String pastDate = LocalDate.now().minusDays(generics.getRandomBetween(1, 10))
                .format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        testStepsLog("Enter estimated date : " + pastDate);
        txtEstDate.clear();
        generics.type(txtEstDate, pastDate);
        generics.pause(1);
    }

    public void enterInvalidFormatDate() {
        String invalidDate = LocalDate.now().minusDays(generics.getRandomBetween(1, 10))
                .format(DateTimeFormatter.ofPattern("yyyy/dd/MM"));
        testStepsLog("Enter estimated date : " + invalidDate);
        txtEstDate.clear();
        generics.type(txtEstDate, invalidDate);
        generics.pause(1);
    }

    public void selectDate() {
        clickOnField("Calender");
        String todayDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM d, yyyy"));
        WebElement btnTodayDate = localDriver.findElement(By.xpath("//td[@aria-label='" + todayDate + "']"));
        testStepsLog("Select Today Date - " + todayDate);
        generics.clickOn(btnTodayDate);
        generics.pause(1);
    }

    public void clickOnEscape() {
        testStepsLog("Click on ESCAPE button.");
        localDriver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
        generics.pause(1);
    }

    public void enterMoreCharactersThan(String fieldName, int number) {
        String data = generics.getRandomCharacters(number + generics.getRandomBetween(1, 9));
        testStepsLog("Enter " + fieldName + " : " + data);
        generics.type(getFieldElement(fieldName), data);
        generics.pause(1);
    }

    public void enterDuplicateBatchName() {
        testStepsLog("Enter Batch Name : " + _batchName);
        generics.type(txtBatchName, _batchName);
        generics.pause(1);
    }

    public void getAlreadyCreatedBatchName() {
        _batchName = generics.getText(lblBatchName);
    }

    public boolean isBatchListAvailable() {
        return generics.isPresent(lblBatchName);
    }

    public boolean isBatchNameEmpty() {
        return _batchName.isEmpty();
    }

    public void selectAnyMeasurementSetting() {
        if (generics.getRandomBoolean()) {
            testStepsLog("Click on " + generics.getText(lstRadioLabel.get(0)));
            generics.clickOnJS(lstRadioLabel.get(0));
        } else {
            testStepsLog("Click on " + generics.getText(lstRadioLabel.get(1)));
            generics.clickOnJS(lstRadioLabel.get(1));
        }
        generics.pause(1);
    }

    public void enterMoreDigitsThan(String fieldName, double number) {
        int data = generics.getRandomBetween(((int) Math.pow(10, number)) + 1, ((int) Math.pow(10, number + 1)) - 1);
        testStepsLog("Enter " + fieldName + " : " + data);
        generics.type(getFieldElement(fieldName), String.valueOf(data));
        generics.pause(1);
    }

    public void enterMoreDecimalThan(String fieldName, double number) {
        String data = generics.getRandomBetween(10, 99) + "." +
                generics.getRandomBetween(((int) Math.pow(10, number)) + 1,
                        ((int) Math.pow(10, number + 1)) - 1);
        testStepsLog("Enter " + fieldName + " : " + data);
        generics.type(getFieldElement(fieldName), data);
        generics.pause(1);
    }

    public void enterInvalidValue(String fieldName, String value) {
        testStepsLog("Enter " + fieldName + " : " + value);
        generics.type(getFieldElement(fieldName), value);
        generics.pause(1);
    }

    public void enterValidValue(String fieldName, String value) {
        testStepsLog("Enter " + fieldName + " : " + value);
        generics.type(getFieldElement(fieldName), value);
        generics.pause(1);
    }

    public void enterPanelOneInformation() {
        selectDate();
        enterBatchName();
        selectAnyMeasurementSetting();
        enterValidValue(ESTIMATED_LOADS, String.valueOf(generics.getRandomBetween(100, 999)));
        enterValidValue(ESTIMATED_WEIGHT, String.valueOf(generics.getRandomBetween(100, 999)));
        enterValidValue(ESTIMATED_VOLUME, String.valueOf(generics.getRandomBetween(1000, 9999)));
        clickOnField(NEXT_STEP_1);
    }

    public void enterBatchName() {
        _batchName = generics.getRandomCharacters(10).toUpperCase() + generics.getRandomBetween(10000, 99999);
        testStepsLog("Enter Batch Name : " + _batchName);
        generics.type(txtBatchName, _batchName);
        generics.pause(1);
    }

    public void selectAnOption() {
        WebElement selectedValue = lstDropdownValues.get(generics.getRandomBetween(0, lstDropdownValues.size() - 1));
        _selectedValue = generics.getText(selectedValue);
        testStepsLog("Click on " + _selectedValue);
        generics.clickOn(selectedValue);
        waitTillPageLoad();
    }

    public void selectOtherAsType() {
        WebElement selectedValue = lstDropdownValues.get(lstDropdownValues.size() - 1);
        _selectedValue = generics.getText(selectedValue);
        testStepsLog("Click on " + _selectedValue);
        generics.clickOn(selectedValue);
        waitTillPageLoad();
    }

    public boolean isDropdownValuesAvailable() {
        return !lstDropdownValues.isEmpty();
    }

    public void typeOptionFromList(String fieldName) {
        WebElement selectedValue = lstDropdownValues.get(generics.getRandomBetween(0, lstDropdownValues.size() - 1));
        _selectedValue = generics.getText(selectedValue).substring(0, 3);
        testStepsLog("Enter " + fieldName + " : " + _selectedValue);
        generics.type(getFieldElement(fieldName), _selectedValue);
    }

    public void enterPanelTwoInformation() {
        clickOnField(SOURCE_SITE);
        selectAnOption();
        clickOnField(SOURCE_TYPE);
        selectAnOption();
        clickOnField(SITE_HISTORY);
        selectAnOption();
        enterValidValue(PRESENT_USE, SITE_HISTORY_RESIDENTIAL);
        clickOnField(PRIMARY_CONTACT);
        selectAnOption();
        clickOnField(NEXT_STEP_1);
    }

    public void selectSoilQuality(int num) {
        int count = num;
        while (num > 0) {
            WebElement selectedValue = lstDropdownValues.get(generics.getRandomBetween(0, lstDropdownValues.size() - 1));
            _selectedValue = generics.getText(selectedValue);
            testStepsLog("Click on " + _selectedValue);
            generics.clickOn(selectedValue);
            waitTillPageLoad();
            if (count > 1) _selectedValue = count + " " + SOIL_TYPE_SELECTED;
            num--;
        }
    }
}