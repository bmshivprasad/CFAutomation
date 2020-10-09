package cleanfill.PageObjects;

import cleanfill.base.BaseClass;
import cleanfill.base.Generics;
import cleanfill.utilities.ExcelColumns;
import cleanfill.utilities.ExcelUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class BatchPage extends BaseClass implements Validations, FieldOR, ExcelColumns {

    WebDriver localDriver;
    Generics generics;
    ExcelUtils excelUtils = new ExcelUtils();

    public static String _batchName = "";
    public static String _selectedValue = "";
    public static WebElement selectedElement;
    public static List<String> _links = new LinkedList<>();
    public static List<String> _files = new LinkedList<>();

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

    @FindBy(xpath = "//mat-basic-chip")
    public List<WebElement> soilParameters;

    @FindBy(xpath = "//input[@formcontrolname='otherAnalysisParamNum']")
    public WebElement txtOtherAnalysis;

    @FindBy(xpath = "//fill-site-input//ng-select//input")
    public WebElement selectReceivingSite;

    @FindBy(xpath = "//file-upload//input")
    public WebElement btnUploadDoc;

    @FindBy(xpath = "//mat-form-field//input")
    public WebElement txtLink;

    @FindBy(xpath = "//mat-form-field//button")
    public WebElement btnAddLink;

    @FindBy(xpath = "//link-preview//button")
    public WebElement btnDeleteLink;

    @FindBy(xpath = "//file-preview//button[2]")
    public WebElement btnDeleteFile;

    @FindBy(xpath = "//textarea[@formcontrolname='comments']")
    public WebElement txtComments;

    @FindBy(xpath = "//common-confirm//button//span")
    public List<WebElement> lstPopupButtons;

    @FindBy(xpath = "//button//span[contains(text(),'Submit Batch Request')]")
    public WebElement btnSubmitBatchRequest;

    @FindBy(xpath = "//common-search-bar//input")
    public WebElement txtSearchBatch;

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
            case FieldOR.BATCH_NAME:
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
            case FieldOR.PRESENT_USE:
                element = txtPresentUse;
                break;
            case FieldOR.SOIL_DESCRIPTION:
                element = selectSoilDescription;
                break;
            case SOIL_QUALITY:
                element = selectSoilQuality;
                break;
            case OTHER_SOIL_ANALYSIS:
                element = txtOtherAnalysis;
                break;
            case RECEIVING_SITE:
                element = selectReceivingSite;
                break;
            case ADD_LINK:
                element = btnAddLink;
                break;
            case CHOOSE_FILE:
                element = btnUploadDoc;
                break;
            case DELETE_LINK:
                element = btnDeleteLink;
                break;
            case DELETE_YES:
                element = lstPopupButtons.get(0);
                break;
            case DELETE_NO:
                element = lstPopupButtons.get(1);
                break;
            case DELETE_FILE:
                element = btnDeleteFile;
                break;
            case COMMENTS:
                element = txtComments;
                break;
            case SUBMIT_REQUEST:
                element = btnSubmitBatchRequest;
                break;
            case BATCH_SEARCH:
                element = txtSearchBatch;
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
        String todayDate = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("MMMM d, yyyy"));
        WebElement btnTomorrowDate = localDriver.findElement(By.xpath("//td[@aria-label='" + todayDate + "']"));
        testStepsLog("Select Est Date - " + todayDate);
        generics.clickOn(btnTomorrowDate);
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
        generics.pause(3);
    }

    public void selectOtherAsType() {
        WebElement selectedValue = lstDropdownValues.get(lstDropdownValues.size() - 1);
        _selectedValue = generics.getText(selectedValue);
        testStepsLog("Click on " + _selectedValue);
        generics.clickOn(selectedValue);
        generics.pause(3);
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
        enterValidValue(FieldOR.PRESENT_USE, SITE_HISTORY_RESIDENTIAL);
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
            generics.pause(2);
            if (count > 1) _selectedValue = count + " " + SOIL_TYPE_SELECTED;
            num--;
        }
    }

    public void selectSoilAnalysis() {
        selectedElement = soilParameters.get(generics.getRandomBetween(0, soilParameters.size() - 2));
        _selectedValue = generics.getText(selectedElement);
        testStepsLog("Click on " + _selectedValue);
        generics.clickOn(selectedElement);
        generics.pause(3);
    }

    public void selectSoilAnalysisAsOther() {
        selectedElement = soilParameters.get(soilParameters.size() - 1);
        _selectedValue = generics.getText(selectedElement);
        testStepsLog("Click on " + _selectedValue);
        generics.clickOn(selectedElement);
        generics.pause(3);
    }

    public void uncheckSelectedChoice() {
        _selectedValue = generics.getText(selectedElement);
        testStepsLog("Click on " + _selectedValue);
        generics.clickOn(selectedElement);
        generics.pause(3);
    }


    public void enterPanelThreeInformation() {
        clickOnField(FieldOR.SOIL_DESCRIPTION);
        selectAnOption();
        clickOnField(SOIL_QUALITY);
        selectSoilQuality(3);
        clickOnPanel(3);
        selectSoilAnalysis();
        clickOnField(RECEIVING_SITE);
        selectAnOption();
        clickOnField(NEXT_STEP_1);
    }

    public void enterLinks(int link) {
        while (link > 0) {
            String linkName = "https://" + generics.getRandomCharacters(20).toLowerCase() + ".com";
            testStepsLog("Enter link - " + linkName);
            generics.type(txtLink, linkName);
            clickOnField(ADD_LINK);
            _links.add(linkName);
            generics.pause(2);
            link--;
        }
    }

    public void uploadFile(String fileType) {
        String fileLocation = getFileLocation(fileType);
        testStepsLog("Upload File from - " + fileLocation);
        getFieldElement(CHOOSE_FILE).sendKeys(fileLocation);
        waitTillPageLoad();
        _files.add(fileLocation.replace(FILE_LOCATION + File.separator, ""));
    }

    private String getFileLocation(String fileType) {
        String temp = "";
        if (fileType.equalsIgnoreCase(FILE_TYPE_JPEG)) temp = FILE_JPEG;
        else if (fileType.equalsIgnoreCase(FILE_TYPE_PNG)) temp = FILE_PNG;
        else if (fileType.equalsIgnoreCase(FILE_TYPE_DOC)) temp = FILE_DOC;
        else if (fileType.equalsIgnoreCase(FILE_TYPE_PDF)) temp = FILE_PDF;
        else if (fileType.equalsIgnoreCase(FILE_TYPE_MAX)) temp = FILE_10MB;
        else if (fileType.equalsIgnoreCase(FILE_TYPE_EXTRA)) temp = FILE_EXTRA;
        return temp;
    }

    public void enterPanelFourInformation() {
        enterLinks(1);
        uploadFile(FILE_TYPE_JPEG);
        enterValidValue(COMMENTS, generics.getRandomCharacters(100));
    }

    public void searchCreatedBatch() {
        enterValidValue(BATCH_SEARCH, _batchName);
        generics.pause(2);
    }

    public void enterBatchLoadInformation(int count) {
        String date = excelUtils.getTestData(TEST_DATA, CREATE_BATCH, count, EST_START_DATE);
        generics.type(txtEstDate, date);
        testStepsLog("Select Est Date - " + date);
        generics.pause(1);

        _batchName = excelUtils.getTestData(TEST_DATA, CREATE_BATCH, count, ExcelColumns.BATCH_NAME);
        generics.type(txtBatchName, _batchName);
        testStepsLog("Enter Batch Name - " + _batchName);

        String trackBy = excelUtils.getTestData(TEST_DATA, CREATE_BATCH, count, TRACK_BY);
        if (trackBy.equalsIgnoreCase("Load")) {
            generics.scrollToElement(lstRadioLabel.get(0));
            generics.clickOn(lstRadioLabel.get(0));
            testStepsLog("Select Measurement Settings - Track by Load");
        } else {
            generics.scrollToElement(lstRadioLabel.get(1));
            generics.clickOnJS(lstRadioLabel.get(1));
            testStepsLog("Select Measurement Settings - Track by Weight");
        }

        int estLoads = Integer.parseInt(excelUtils.getTestData(TEST_DATA, CREATE_BATCH, count, EST_LOADS));
        double estWeight = Double.parseDouble(excelUtils.getTestData(TEST_DATA, CREATE_BATCH, count, EST_WEIGHT));
        double estVolume = Double.parseDouble(excelUtils.getTestData(TEST_DATA, CREATE_BATCH, count, EST_VOLUME));

        generics.type(txtEstLoads, String.valueOf(estLoads));
        testStepsLog("Enter Est Loads - " + estLoads);
        generics.type(txtEstWeight, String.valueOf(estWeight));
        testStepsLog("Enter Est Weight - " + estWeight);
        generics.type(txtEstVolume, String.valueOf(estVolume));
        testStepsLog("Enter Est Volume - " + estVolume);

        clickOnField(NEXT_STEP_1);

    }

    public int getLastRow() {
        return excelUtils.lastRowNumber(TEST_DATA, CREATE_BATCH);
    }

    public void enterSourceSiteDetails(int count) {
        clickOnField(SOURCE_SITE);
        selectAnOption();
        clickOnField(SOURCE_TYPE);
        selectAnOption();
        clickOnField(SITE_HISTORY);
        String siteHistory = excelUtils.getTestData(TEST_DATA, CREATE_BATCH, count, SOURCE_SITE_HISTORY);
        WebElement element = localDriver.findElement(By.xpath("//ng-dropdown-panel//div[contains(@class,'ng-option')]" +
                "//span[text()='" + siteHistory + "']"));
        generics.clickOn(element);
        testStepsLog("Click on - " + siteHistory);
        if (siteHistory.equalsIgnoreCase(OTHER)) {
            String otherHistory = excelUtils.getTestData(TEST_DATA, CREATE_BATCH, count, SOURCE_SITE_HISTORY_OTHER);
            generics.type(txtSiteHistoryOther, otherHistory);
            testStepsLog("Enter Site History - " + otherHistory);
        }
        String presentUse = excelUtils.getTestData(TEST_DATA, CREATE_BATCH, count, ExcelColumns.PRESENT_USE);
        generics.type(txtPresentUse, presentUse);
        testStepsLog("Enter Present Use - " + presentUse);

        clickOnField(PRIMARY_CONTACT);
        if (lstDropdownValues.isEmpty()) testStepsLog("No Primary Contact display to select.");
        else selectAnOption();

        clickOnField(QUALIFIED_PERSON);
        if (lstDropdownValues.isEmpty()) testStepsLog("No Qualified Person display to select.");
        else selectAnOption();

        clickOnField(NEXT_STEP_1);
    }

    public void enterSoilDescriptionParameters(int count) {
        clickOnField(FieldOR.SOIL_DESCRIPTION);
        String soilDesc = excelUtils.getTestData(TEST_DATA, CREATE_BATCH, count, ExcelColumns.SOIL_DESCRIPTION);
        WebElement element = localDriver.findElement(By.xpath("//ng-dropdown-panel//div[contains(@class,'ng-option')]" +
                "//span[text()='" + soilDesc + "']"));
        generics.clickOn(element);
        testStepsLog("Click on - " + soilDesc);

        clickOnField(SOIL_QUALITY);
        selectSoilQuality(1);
        clickOnPanel(3);

        String soilQty = excelUtils.getTestData(TEST_DATA, CREATE_BATCH, count, SOIL_PARAMETERS);
        element = localDriver.findElement(By.xpath("//mat-basic-chip[contains(text(),'" + soilQty + "')]"));
        generics.clickOn(element);
        testStepsLog("Click on - " + soilQty);
        if (soilQty.equalsIgnoreCase(OTHER)) {
            String otherQty = excelUtils.getTestData(TEST_DATA, CREATE_BATCH, count, SOIL_PARAMETERS_OTHER);
            generics.type(txtOtherAnalysis, otherQty);
            testStepsLog("Enter Parameters - " + otherQty);
        }

        clickOnField(RECEIVING_SITE);
        if (lstDropdownValues.isEmpty()) testStepsLog("No Receiving Site display to select.");
        else selectAnOption();

        clickOnField(NEXT_STEP_1);
    }

    public void enterAttachments(int count) {
        String linkName = excelUtils.getTestData(TEST_DATA, CREATE_BATCH, count, FILE_LINK);
        for (int link = 0; link < linkName.split(",").length; link++) {
            testStepsLog("Enter link - " + linkName.split(",")[link].trim());
            generics.type(txtLink, linkName.split(",")[link].trim());
            clickOnField(ADD_LINK);
            generics.pause(2);
        }

        String fileName = excelUtils.getTestData(TEST_DATA, CREATE_BATCH, count, FILE_UPLOAD);
        for (int file = 0; file < fileName.split(",").length; file++) {
            testStepsLog("Enter File - " + fileName.split(",")[file].trim());
            getFieldElement(CHOOSE_FILE).sendKeys(fileName.split(",")[file].trim());
            generics.pause(2);
        }

        enterValidValue(COMMENTS, generics.getRandomCharacters(100));
    }
}