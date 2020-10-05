package cleanfill.PageObjects;

import cleanfill.base.BaseClass;
import cleanfill.base.Generics;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BatchVerification extends BaseClass implements Validations, FieldOR {

    WebDriver localDriver;
    Generics generics;

    public BatchVerification(WebDriver baseDriver) {
        this.localDriver = baseDriver;
        PageFactory.initElements(baseDriver, this);
        generics = new Generics(baseDriver);
        log4j = Logger.getLogger("BatchVerification");
    }

    @FindBy(xpath = "//button//span[contains(text(),'New Batch Request ')]")
    public WebElement btnNewBatchRequest;

    @FindBy(xpath = "//status-overview//span[contains(@class,'count')]")
    public WebElement lblTotalBatches;

    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement txtSearch;

    @FindBy(xpath = "//button[@savedraftbtn]")
    public WebElement btnSave;

    @FindBy(xpath = "//input[@formcontrolname='estimatedStartDate']")
    public WebElement txtEstDate;

    @FindBy(xpath = "//input[@formcontrolname='batchName']")
    public WebElement txtBatchName;

    @FindBy(xpath = "//input[@formcontrolname='batchId']")
    public WebElement txtBatchId;

    @FindBy(xpath = "//panels//div[contains(@class,'panel-menu__option')]")
    public List<WebElement> lstBatchPanels;

    @FindBy(xpath = "//mat-calendar")
    public WebElement popupCalender;

    @FindBy(xpath = "//div[@id='spinner']")
    public WebElement spinner;

    @FindBy(xpath = "//button[@aria-label='Open calendar']")
    public WebElement btnCalender;

    @FindBy(xpath = "//button//span[contains(text(),'Next')]")
    public WebElement btnNext;

    @FindBy(xpath = "//input[@formcontrolname='estimatedLoads']")
    public WebElement txtEstLoads;

    @FindBy(xpath = "//input[@formcontrolname='estimatedWeight']")
    public WebElement txtEstWeight;

    @FindBy(xpath = "//input[@formcontrolname='estimatedVolume']")
    public WebElement txtEstVolume;

    @FindBy(xpath = "//input[@formcontrolname='presentUse']")
    public WebElement txtPresentUse;

    @FindBy(xpath = "//mat-basic-chip")
    public List<WebElement> soilParameters;

    @FindBy(xpath = "//ng-select")
    public List<WebElement> selectSiteInformation;

    @FindBy(xpath = "//ng-dropdown-panel//div[contains(@class,'ng-option')]//span")
    public List<WebElement> lstDropdownValues;

    @FindBy(xpath = "//ng-select[@formcontrolname='sourceSite']//input")
    public WebElement selectSourceSite;

    @FindBy(xpath = "//ng-select[@formcontrolname='sourceSite']//span[contains(@class,'ng-value-label')]")
    public WebElement lblSelectedSourceSite;

    @FindBy(xpath = "//ng-select[@attr.data-meta='SourceTypeDD']//input")
    public WebElement selectSourceType;

    @FindBy(xpath = "//ng-select[@formcontrolname='SourceTypeDD']//span[contains(@class,'ng-value-label')]")
    public WebElement lblSelectedSourceType;

    @FindBy(xpath = "//ng-select[@attr.data-meta='SourceSiteHistoryDD']//input")
    public WebElement selectSiteHistory;

    @FindBy(xpath = "//ng-select[@formcontrolname='SourceSiteHistoryDD']//span[contains(@class,'ng-value-label')]")
    public WebElement lblSelectedSiteHistory;

    @FindBy(xpath = "//ng-select[@formcontrolname='primaryContact']//input")
    public WebElement selectPrimaryContact;

    @FindBy(xpath = "//ng-select[@formcontrolname='primaryContact']//span[contains(@class,'ng-value-label')]")
    public WebElement lblSelectedPrimaryContact;

    @FindBy(xpath = "//ng-select[@formcontrolname='assignedQp']//input")
    public WebElement selectQualifiedPerson;

    @FindBy(xpath = "//ng-select[@formcontrolname='assignedQp']//span[contains(@class,'ng-value-label')]")
    public WebElement lblSelectedQualifiedPerson;

    @FindBy(xpath = "//input[@formcontrolname='sourceTypeOther']")
    public WebElement txtSourceTypeOther;

    @FindBy(xpath = "//input[@formcontrolname='siteHistoryOther']")
    public WebElement txtSiteHistoryOther;

    @FindBy(xpath = "//p[text()='Phone']//following-sibling::p")
    public WebElement lblPhoneNumber;

    @FindBy(xpath = "//p[text()='Email']//following-sibling::p")
    public WebElement lblEmail;

    @FindBy(xpath = "//ng-select[@formcontrolname='soilDescription']//span[contains(@class,'ng-value-label')]")
    public WebElement lblSelectedSoilDescription;

    @FindBy(xpath = "//ng-select[@formcontrolname='soilDescription']//input")
    public WebElement selectSoilDescription;

    @FindBy(xpath = "//common-dropdown[contains(@class,'batch-soilQuality-Type')]//ng-select//input")
    public WebElement selectSoilQuality;

    @FindBy(xpath = "//common-dropdown[contains(@class,'batch-soilQuality-Type')]//ng-select//span[contains(@class,'ng-value-label')]")
    public WebElement lblSelectedSoilQuality;

    public WebElement getFieldElement(String fieldName) {
        WebElement element = null;
        if (fieldName.equalsIgnoreCase(ESTIMATED_LOADS)) element = txtEstLoads;
        else if (fieldName.equalsIgnoreCase(ESTIMATED_WEIGHT)) element = txtEstWeight;
        else if (fieldName.equalsIgnoreCase(ESTIMATED_VOLUME)) element = txtEstVolume;
        else if (fieldName.equalsIgnoreCase(BATCH_ID)) element = txtBatchId;
        else if (fieldName.equalsIgnoreCase(BATCH_NAME)) element = txtBatchName;
        else if (fieldName.equalsIgnoreCase(CALENDER)) element = btnCalender;
        else if (fieldName.equalsIgnoreCase(NEXT_STEP_1)) element = btnNext;
        else if (fieldName.equalsIgnoreCase(ESTIMATED_START_DATE)) element = txtEstDate;
        else if (fieldName.equalsIgnoreCase(SOURCE_SITE)) element = selectSourceSite;
        else if (fieldName.equalsIgnoreCase(SOURCE_TYPE)) element = selectSourceType;
        else if (fieldName.equalsIgnoreCase(SITE_HISTORY)) element = selectSiteHistory;
        else if (fieldName.equalsIgnoreCase(PRIMARY_CONTACT)) element = selectPrimaryContact;
        else if (fieldName.equalsIgnoreCase(QUALIFIED_PERSON)) element = selectQualifiedPerson;
        else if (fieldName.equalsIgnoreCase(SELECTED_SOURCE_SITE)) element = lblSelectedSourceSite;
        else if (fieldName.equalsIgnoreCase(SELECTED_SOURCE_TYPE)) element = lblSelectedSourceType;
        else if (fieldName.equalsIgnoreCase(SELECTED_SITE_HISTORY)) element = lblSelectedSiteHistory;
        else if (fieldName.equalsIgnoreCase(SELECTED_PRIMARY_CONTACT)) element = lblSelectedPrimaryContact;
        else if (fieldName.equalsIgnoreCase(SELECTED_QUALIFIED_PERSON)) element = lblSelectedQualifiedPerson;
        else if (fieldName.equalsIgnoreCase(SOURCE_TYPE_OTHER)) element = txtSourceTypeOther;
        else if (fieldName.equalsIgnoreCase(SITE_HISTORY_OTHER)) element = txtSiteHistoryOther;
        else if (fieldName.equalsIgnoreCase(SOIL_DESCRIPTION)) element = selectSoilDescription;
        else if (fieldName.equalsIgnoreCase(SELECTED_SOIL_DESCRIPTION)) element = lblSelectedSoilDescription;
        else if (fieldName.equalsIgnoreCase(SOIL_QUALITY)) element = selectSoilQuality;
        else if (fieldName.equalsIgnoreCase(SELECTED_SOIL_QUALITY)) element = lblSelectedSoilQuality;
        else if (fieldName.contains("Panel"))
            element = lstBatchPanels.get(Integer.parseInt(fieldName.split(" ")[1]) - 1);
        return element;
    }

    public WebElement lblErrorMessage(String fieldName) {
        return localDriver.findElement(By.xpath("//h2[contains(text(),'" + fieldName + "')]" +
                "//following-sibling::mat-form-field//mat-error"));
    }

    public WebElement getRadioErrorMessage(String fieldName) {
        return localDriver.findElement(By.xpath("//h2[contains(text(),'" + fieldName + "')]" +
                "//following-sibling::mat-error"));
    }

    public String getErrorMessageLocator(String fieldName) {
        return "//h2[contains(text(),'" + fieldName + "')]" + "//following-sibling::mat-form-field//mat-error";
    }

    public void waitTillPageLoad() {
        while (generics.isPresent(spinner)) generics.pause(1);
    }

    public boolean verifyBatchesScreen() {
        waitTillPageLoad();
        return generics.isPresent(btnNewBatchRequest) && generics.isPresent(lblTotalBatches) &&
                generics.isPresent(txtSearch);
    }

    public boolean verifyCreateNewBatchScreen() {
        waitTillPageLoad();
        return generics.isPresent(btnSave) && lstBatchPanels.size() == 4;
    }

    public boolean verifyFieldIsMandatory(String fieldName) {
        try {
            testStepsLog(generics.getText(lblErrorMessage(fieldName)));
            return generics.getText(lblErrorMessage(fieldName)).equals(REQUIRED);
        } catch (Exception e) {
            testStepsLog(generics.getText(getRadioErrorMessage(fieldName)));
            return generics.getText(getRadioErrorMessage(fieldName)).equals(REQUIRED);
        }
    }

    public boolean verifyValidationMessageForPastDate(String fieldName) {
        testStepsLog(generics.getText(lblErrorMessage(fieldName)));
        return generics.getText(lblErrorMessage(fieldName)).equals(PAST_DATE);
    }

    public boolean verifyValidationMessageForInvalidDate(String fieldName) {
        testStepsLog(generics.getText(lblErrorMessage(fieldName)));
        return generics.getText(lblErrorMessage(fieldName)).equals(INVALID_DATE);
    }

    public boolean verifyCalenderDisplay() {
        return generics.isPresent(popupCalender);
    }

    public boolean verifySelectedDateDisplay() {
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String actualDate = generics.getValue(txtEstDate);
        return actualDate.equalsIgnoreCase(expectedDate);
    }

    public boolean verifyMaxCharacter(String fieldName, int number) {
        return generics.getValue(getFieldElement(fieldName)).length() == number;
    }

    public boolean verifyValidationMessageForDuplicateBatchName(String fieldName) {
        testStepsLog(generics.getText(lblErrorMessage(fieldName)));
        return generics.getText(lblErrorMessage(fieldName)).equals(duplicateBatchName(BatchPage._batchName));
    }

    public boolean verifyBatchIdGenerated() {
        return generics.getValue(txtBatchId).length() == 7 &&
                generics.getValue(txtBatchId).contains("[a-zA-Z]+");
    }

    public boolean verifyMaxSixDigitsAccepted(String fieldName) {
        return generics.getValue(getFieldElement(fieldName)).length() == 6;
    }

    public boolean verifyMaxTwoDecimalAccepted(String fieldName) {
        return generics.getValue(getFieldElement(fieldName)).split("\\.")[1].length() == 2;
    }

    public boolean verifyValidationMessageForInvalidField(String fieldName) {
        testStepsLog(generics.getText(lblErrorMessage(fieldName)));
        return generics.getText(lblErrorMessage(fieldName)).equals(VALUE_MORE_THAN_1) ||
                generics.getValue(getFieldElement(fieldName)).isEmpty();
    }

    public boolean verifyValidationMessageForMoreChars(String fieldName) {
        testStepsLog(generics.getText(lblErrorMessage(fieldName)));
        return generics.getText(lblErrorMessage(fieldName)).equals(VALUE_MORE_THAN_50);
    }

    public boolean verifyNegativeValueNotAccepted(String fieldName) {
        return !generics.isPresent(getErrorMessageLocator(fieldName));
    }

    public boolean verifyPanelTwoDisplay() {
        waitTillPageLoad();
        return generics.isPresent(txtPresentUse) && selectSiteInformation.size() == 5;
    }

    public boolean verifyAllOptionDisplayAlphabetically() {
        List<String> dropdownValues = new LinkedList<>();
        List<String> sortedList = new LinkedList<>();
        lstDropdownValues.forEach((option) -> {
            dropdownValues.add(generics.getText(option));
            sortedList.add(generics.getText(option));
        });
        Collections.sort(sortedList);
        return sortedList.equals(dropdownValues);
    }

    public boolean verifySelectedValueDisplayOnDropdown(String fieldName) {
        System.out.println(generics.getText(getFieldElement(fieldName)));
        System.out.println(BatchPage._selectedValue);
        return generics.getText(getFieldElement(fieldName)).equals(BatchPage._selectedValue);
    }

    public boolean verifySourceTypeOptionDisplay() {
        List<String> dropdownValues = new LinkedList<>();
        lstDropdownValues.forEach((option) -> dropdownValues.add(generics.getText(option)));
        return dropdownValues.contains(SOURCE_TYPE_EX_SITE) && dropdownValues.contains(SOURCE_TYPE_IN_SITE) &&
                dropdownValues.contains(OTHER);
    }

    public boolean verifyOtherOptionDisplayTextField(String fieldName) {
        return generics.isPresent(getFieldElement(fieldName));
    }

    public boolean verifySiteHistoryOptionDisplay() {
        List<String> dropdownValues = new LinkedList<>();
        lstDropdownValues.forEach((option) -> dropdownValues.add(generics.getText(option)));
        return dropdownValues.contains(SITE_HISTORY_AGRICULTURAL) && dropdownValues.contains(SITE_HISTORY_COMMUNITY) &&
                dropdownValues.contains(SITE_HISTORY_INDUSTRIAL) && dropdownValues.contains(SITE_HISTORY_PARKLAND) &&
                dropdownValues.contains(SITE_HISTORY_RESIDENTIAL) && dropdownValues.contains(OTHER);
    }

    public boolean verifyContactListDisplay() {
        return !lstDropdownValues.isEmpty();
    }

    public boolean verifyListOfContactDisplayByText() {
        boolean bool = true;
        List<String> dropdownValues = new LinkedList<>();
        lstDropdownValues.forEach((option) -> dropdownValues.add(generics.getText(option)));
        for (String dropdownValue : dropdownValues)
            if (!dropdownValue.contains(BatchPage._selectedValue)) {
                bool = false;
                break;
            }

        return bool;
    }

    public boolean verifyContactDetailsDisplay() {
        testStepsLog("Phone : " + generics.getText(lblPhoneNumber));
        testStepsLog("Email : " + generics.getText(lblEmail));
        return generics.isPresent(lblPhoneNumber) && generics.isPresent(lblEmail);
    }

    public boolean verifyPanelThreeDisplay() {
        waitTillPageLoad();
        return soilParameters.size() == 8 && selectSiteInformation.size() == 3;
    }

    public boolean verifyAllSoilDescriptionOptionDisplay() {
        List<String> dropdownValues = new LinkedList<>();
        lstDropdownValues.forEach((option) -> dropdownValues.add(generics.getText(option)));
        return dropdownValues.contains(SOIL_DESC_ASPHALT_MIX) && dropdownValues.contains(SOIL_DESC_BRICK_BLOCK) &&
                dropdownValues.contains(SOIL_DESC_CLAY) && dropdownValues.contains(SOIL_DESC_GRANULAR) &&
                dropdownValues.contains(SOIL_DESC_CLEANFILL) && dropdownValues.contains(SOIL_DESC_MIXED_SILTY_CLAY) &&
                dropdownValues.contains(SOIL_DESC_MIXED_SLIT_SHALE) && dropdownValues.contains(SOIL_DESC_SAND) &&
                dropdownValues.contains(SOIL_DESC_SANDY_SLIT) && dropdownValues.contains(SOIL_DESC_SHALE) &&
                dropdownValues.contains(SOIL_DESC_TOPSOIL) && dropdownValues.contains(SOIL_DESC_TOPSOIL_SAND);
    }

    public boolean verifyAllSoilQualityOptionDisplay() {
        List<String> dropdownValues = new LinkedList<>();
        lstDropdownValues.forEach((option) -> dropdownValues.add(generics.getText(option)));
        return dropdownValues.contains(SOIL_QTY_OREG153_T1) && dropdownValues.contains(SOIL_QTY_OREG153_T2) &&
                dropdownValues.contains(SOIL_QTY_OREG153_T3) && dropdownValues.contains(SOIL_QTY_OREG153_T4) &&
                dropdownValues.contains(SOIL_QTY_OREG153_T5) && dropdownValues.contains(SOIL_QTY_OREG153_T6) &&
                dropdownValues.contains(SOIL_QTY_OREG153_T7) && dropdownValues.contains(SOIL_QTY_OREG153_T8) &&
                dropdownValues.contains(SOIL_QTY_OREG153_T9) && dropdownValues.contains(SOIL_QTY_OREG406_T1_1) &&
                dropdownValues.contains(SOIL_QTY_OREG406_T2_1) && dropdownValues.contains(SOIL_QTY_OREG406_T3_1) &&
                dropdownValues.contains(SOIL_QTY_OREG406_T4_1) && dropdownValues.contains(SOIL_QTY_OREG406_T5_1) &&
                dropdownValues.contains(SOIL_QTY_OREG406_T6_1) && dropdownValues.contains(SOIL_QTY_OREG406_T7_1) &&
                dropdownValues.contains(SOIL_QTY_OREG406_T8_1) && dropdownValues.contains(SOIL_QTY_OREG406_T9_1) &&
                dropdownValues.contains(SOIL_QTY_ALL_SOIL_TYPES);
    }
}