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
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BatchVerification extends BaseClass implements Validations, FieldOR {

    WebDriver localDriver;
    Generics generics;
    BatchPage batch;
    public static List<String> receivingSite = new LinkedList<>();

    public BatchVerification(WebDriver baseDriver) {
        this.localDriver = baseDriver;
        PageFactory.initElements(baseDriver, this);
        generics = new Generics(baseDriver);
        batch = new BatchPage(baseDriver);
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

    @FindBy(xpath = "//mat-radio-button")
    public List<WebElement> lstRadioButtons;

    @FindBy(xpath = "//mat-calendar")
    public WebElement popupCalender;

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

    @FindBy(xpath = "//ng-select[@attr.data-meta='SourceTypeDD']//span[contains(@class,'ng-value-label')]")
    public WebElement lblSelectedSourceType;

    @FindBy(xpath = "//ng-select[@attr.data-meta='SourceSiteHistoryDD']//input")
    public WebElement selectSiteHistory;

    @FindBy(xpath = "//ng-select[@attr.data-meta='SourceSiteHistoryDD']//span[contains(@class,'ng-value-label')]")
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

    @FindBy(xpath = "//input[@formcontrolname='analysisParameter']")
    public WebElement lblSoilAnalysisParameter;

    @FindBy(xpath = "//input[@formcontrolname='count']")
    public WebElement txtNumberOfSampleCount;

    @FindBy(xpath = "//input[@formcontrolname='otherAnalysisParamNum']")
    public WebElement txtOtherAnalysis;

    @FindBy(xpath = "//mat-checkbox[@formcontrolname='isTCPL']//input")
    public WebElement chkTCLP;

    @FindBy(xpath = "//file-upload")
    public WebElement btnUploadDoc;

    @FindBy(xpath = "//mat-form-field//input")
    public WebElement txtLink;

    @FindBy(xpath = "//mat-form-field//button")
    public WebElement btnAddLink;

    @FindBy(xpath = "//textarea[@formcontrolname='comments']")
    public WebElement txtComments;

    @FindBy(xpath = "//link-preview//div[contains(@class,'link-url-txt')]")
    public List<WebElement> lstLinks;

    @FindBy(xpath = "//file-preview//h4")
    public List<WebElement> lstFiles;

    @FindBy(xpath = "//common-confirm//h3[not(text()='  ')]")
    public WebElement lblDeleteConfirmation;

    @FindBy(xpath = "//common-confirm//button//span")
    public List<WebElement> lstPopupButtons;

    @FindBy(xpath = "//link-preview//button")
    public WebElement btnDeleteLink;

    @FindBy(xpath = "//common-file-upload-list//button[contains(@class,'prev-fil-del')]")
    public WebElement btnDeleteFile;

    @FindBy(xpath = "//common-error//div[@class='message']")
    public WebElement lblError;

    @FindBy(xpath = "//batch-request-submission//h2")
    public WebElement lblSuccessfulSubmitBatchRequest;

    @FindBy(xpath = "//batch-request-submission//button")
    public WebElement btnBackToBatches;

    @FindBy(xpath = "//p[@class='batch-identifiers__name']")
    public WebElement lblBatchRequestName;

    @FindBy(xpath = "//td[contains(@class,'mat-column-status')]")
    public WebElement lblBatchStatus;

    @FindBy(xpath = "//app-fill-site-select")
    public WebElement siteSelectContainer;

    @FindBy(xpath = "//td//a[contains(@class,'user__name')]")
    public List<WebElement> lstReceivingSiteName;

    @FindBy(xpath = "//td[contains(@class,'mat-column-address ')]")
    public List<WebElement> lstReceivingSiteAddress;

    @FindBy(xpath = "//fill-site-input//h2")
    public WebElement receivingSiteName;

    @FindBy(xpath = "//fill-site-input//h3")
    public WebElement receivingSiteAddress;

    @FindBy(xpath = "//fill-site-input//button")
    public WebElement selectReceivingSite;

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
        else if (fieldName.equalsIgnoreCase(OTHER_SOIL_ANALYSIS)) element = txtOtherAnalysis;
        else if (fieldName.equalsIgnoreCase(COMMENTS)) element = txtComments;
        else if (fieldName.equalsIgnoreCase(RECEIVING_SITE)) element = siteSelectContainer;
        else if (fieldName.contains("Panel"))
            element = lstBatchPanels.get(Integer.parseInt(fieldName.split(" ")[1]) - 1);
        return element;
    }

    public WebElement lblErrorMessage(String fieldName) {
        return localDriver.findElement(By.xpath("//h2[contains(text(),'" + fieldName + "')]" +
                "//ancestor::mat-form-field//mat-error"));
    }

    public WebElement lblErrorMessage2(String fieldName) {
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

    public boolean verifyBatchesScreen() {
        batch.waitTillPageLoad();
        return generics.isPresent(btnNewBatchRequest) && generics.isPresent(lblTotalBatches) &&
                generics.isPresent(txtSearch);
    }

    public boolean verifyCreateNewBatchScreen() {
        batch.waitTillPageLoad();
        return generics.isPresent(btnSave) && lstBatchPanels.size() == 4;
    }

    public boolean verifyFieldIsMandatory(String fieldName) {
        try {
            testStepsLog(generics.getText(lblErrorMessage(fieldName)));
            return generics.getText(lblErrorMessage(fieldName)).equals(REQUIRED) ||
                    generics.getText(lblErrorMessage(fieldName)).equals(ESTIMATED_WEIGHT_VOLUME_MANDATORY) ||
                    generics.getText(lblErrorMessage(fieldName)).equals(SOIL_QUALITY_MANDATORY);
        } catch (Exception e) {
            try {
                testStepsLog(generics.getText(lblErrorMessage2(fieldName)));
                return generics.getText(lblErrorMessage2(fieldName)).equals(REQUIRED) ||
                        generics.getText(lblErrorMessage2(fieldName)).equals(ESTIMATED_WEIGHT_VOLUME_MANDATORY) ||
                        generics.getText(lblErrorMessage2(fieldName)).equals(SOIL_QUALITY_MANDATORY);
            } catch (Exception e2) {
                testStepsLog(generics.getText(getRadioErrorMessage(fieldName)));
                return generics.getText(getRadioErrorMessage(fieldName)).equals(REQUIRED) ||
                        generics.getText(lblErrorMessage(fieldName)).equals(ESTIMATED_WEIGHT_VOLUME_MANDATORY);
            }
        }
    }

    public boolean verifyMandatoryFieldValidation(String fieldName) {
        WebElement element = localDriver.findElement(By.xpath("//h2[contains(text(),'" +
                fieldName + "')]//following-sibling::div//mat-error"));
        testStepsLog(generics.getText(element));
        return generics.getText(element).equals("Required if available. Or, select the no analysis option");
    }

    public boolean verifyValidationMessageForPastDate(String fieldName) {
        testStepsLog(generics.getText(lblErrorMessage2(fieldName)));
        return generics.getText(lblErrorMessage2(fieldName)).equals(PAST_DATE);
    }

    public boolean verifyValidationMessageForInvalidDate(String fieldName) {
        testStepsLog(generics.getText(lblErrorMessage2(fieldName)));
        return generics.getText(lblErrorMessage2(fieldName)).equals(INVALID_DATE);
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

    public boolean verifyMaxCharacterValidationMessage(String fieldName, int number) {
        testStepsLog(generics.getText(lblErrorMessage(fieldName)));
        return generics.getText(lblErrorMessage(fieldName)).equalsIgnoreCase("No more than "
                + number + " characters are required");
    }

    public boolean verifyMaxCharacterValidationMessage2(String fieldName, int number) {
        testStepsLog(generics.getText(lblErrorMessage2(fieldName)));
        return generics.getText(lblErrorMessage2(fieldName)).equalsIgnoreCase("No more than "
                + number + " characters are required");
    }

    public boolean verifyValidationMessageForDuplicateBatchName(String fieldName) {
        testStepsLog(generics.getText(lblErrorMessage(fieldName)));
        return generics.getText(lblErrorMessage(fieldName)).equals(duplicateBatchName(BatchPage._duplicateBatchName));
    }

    public boolean verifyBatchIdGenerated() {
        return generics.getValue(txtBatchId).length() == 7;
    }

    public boolean verifyMaxSixDigitsAccepted(String fieldName) {
        return generics.getValue(getFieldElement(fieldName)).length() == 6;
    }

    public boolean verifyMaxTwoDecimalAccepted(String fieldName) {
        return generics.getValue(getFieldElement(fieldName)).split("\\.")[1].length() == 2;
    }

    public boolean verifyValidationMessageForInvalidField(String fieldName) {
        if (!generics.getValue(getFieldElement(fieldName)).isEmpty()) {
            testStepsLog(generics.getText(lblErrorMessage2(fieldName)));
            return generics.getText(lblErrorMessage2(fieldName)).equals(VALUE_MORE_THAN_1);
        } else {
            return generics.getValue(getFieldElement(fieldName)).isEmpty();
        }
    }

    public boolean verifyValidationMessageForMoreChars(String fieldName) {
        testStepsLog(generics.getText(lblErrorMessage(fieldName)));
        return generics.getText(lblErrorMessage(fieldName)).equals(VALUE_MORE_THAN_50);
    }

    public boolean verifyNegativeValueNotAccepted(String fieldName) {
        testStepsLog(generics.getText(lblErrorMessage2(fieldName)));
        return generics.getText(lblErrorMessage2(fieldName)).equals(ESTIMATED_WEIGHT_VOLUME_MANDATORY);
    }

    public boolean verifyPanelTwoDisplay() {
        batch.waitTillPageLoad();
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
        return generics.getText(getFieldElement(fieldName)).equals(BatchPage._soilQualityCount +
                " " + SOIL_TYPE_SELECTED) || generics.getText(getFieldElement(fieldName)).
                equals(BatchPage._selectedValue);
    }

    public boolean verifySourceTypeOptionDisplay() {
        List<String> dropdownValues = new LinkedList<>();
        lstDropdownValues.forEach((option) -> dropdownValues.add(generics.getText(option)));
        return dropdownValues.contains(SOURCE_TYPE_STOCKPILE) && dropdownValues.contains(SOURCE_TYPE_EXCAVATION) &&
                dropdownValues.contains(OTHER) && dropdownValues.contains(SOURCE_TYPE_DRILL_SPOILS);
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
        batch.waitTillPageLoad();
        return soilParameters.size() == 8 && selectSiteInformation.size() == 2 &&
                generics.isPresent(selectReceivingSite);
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

    public boolean verifyAnalysisParametersDisplay() {
        List<String> optionValue = new LinkedList<>();
        soilParameters.forEach((option) -> optionValue.add(generics.getText(option)));
        return optionValue.contains(F1F4) && optionValue.contains(VOC) && optionValue.contains(SVOC) &&
                optionValue.contains(METALS) && optionValue.contains(INORGS) && optionValue.contains(PCB) &&
                optionValue.contains(PEST) && optionValue.contains(OTHER);
    }

    public boolean verifyTCLPAndSampleDetailDisplay() {
        return generics.getValue(lblSoilAnalysisParameter).equals(BatchPage._selectedValue) &&
                generics.isPresent(txtNumberOfSampleCount) && generics.isPresent(chkTCLP);
    }

    public boolean verifyTCLPAndSampleDetailDisappear() {
        return !generics.isPresent(txtNumberOfSampleCount) && !generics.isPresent(chkTCLP);
    }

    public boolean verifyOtherSelectDetails() {
        return generics.getValue(lblSoilAnalysisParameter).equals(BatchPage._selectedValue) &&
                generics.isPresent(txtNumberOfSampleCount) && generics.isPresent(chkTCLP);
    }

    public boolean verifyModelWindowOpens() {
        return generics.isPresent(getFieldElement(RECEIVING_SITE));
    }

    public boolean verifyReceivingSiteUpdated() {
        List<String> dropdownValues = new LinkedList<>();
        lstDropdownValues.forEach((option) -> dropdownValues.add(generics.getText(option)));
        testStepsLog("Receiving Sites - " + receivingSite);
        return !receivingSite.equals(dropdownValues);
    }

    public boolean verifyPanelFourDisplay() {
        return generics.isPresent(txtComments) && generics.isPresent(txtLink) &&
                generics.isPresent(btnUploadDoc) && generics.isPresent(btnAddLink);
    }

    public boolean verifyLinkAddedSuccessfully() {
        List<String> links = new LinkedList<>();
        lstLinks.forEach((option) -> links.add(generics.getText(option)));
        return links.containsAll(BatchPage._links);
    }

    public boolean verifyDeleteActionButtons() {
        testStepsLog(generics.getText(lblDeleteConfirmation));
        return generics.getText(lblDeleteConfirmation).equalsIgnoreCase(DELETE_LINK_MESSAGE) &&
                generics.getText(lstPopupButtons.get(0)).contains(DELETE_YES) &&
                generics.getText(lstPopupButtons.get(1)).contains(DELETE_NO);
    }

    public boolean verifyLinkDeleted() {
        return lstLinks.isEmpty() && !generics.isPresent(btnDeleteLink);
    }

    public boolean verifyMaxLinkValidation() {
        testStepsLog(generics.getText(lblError));
        return generics.getText(lblError).equals(LINKS_MORE_THAN_3);
    }

    public boolean verifyFileUploadedSuccessfully() {
        List<String> files = new LinkedList<>();
        lstFiles.forEach((option) -> files.add(generics.getText(option)));
        return files.equals(BatchPage._files) || files.get(0).equals(BatchPage._files.get(0));
    }

    public boolean verifyFileDeleted() {
        return lstFiles.isEmpty() && !generics.isPresent(btnDeleteFile);
    }

    public boolean verifyMaxSizeFileValidation() {
        testStepsLog(generics.getText(lblDeleteConfirmation));
        boolean bool = generics.getText(lblDeleteConfirmation).equals(FILE_MORE_THAN_10MB);
        generics.clickOn(lstPopupButtons.get(0));
        return bool;
    }

    public boolean verifyMaxFileUploadValidation() {
        testStepsLog(generics.getText(lblDeleteConfirmation));
        boolean bool = generics.getText(lblDeleteConfirmation).equals(FILES_MORE_THAN_5);
        generics.clickOn(lstPopupButtons.get(0));
        return bool;
    }

    public boolean verifyBatchCreatedSuccessfully() {
        testStepsLog(generics.getText(lblSuccessfulSubmitBatchRequest));
        boolean bool = generics.getText(lblSuccessfulSubmitBatchRequest).equals(BATCH_REQUEST_SUCCESS);
        generics.clickOn(btnBackToBatches);
        return bool;
    }

    public boolean verifyCreatedBatchDisplayWithStatus(String status) {
        return BatchPage._batchName.equalsIgnoreCase(generics.getText(lblBatchRequestName)) &&
                generics.getText(lblBatchStatus).equalsIgnoreCase(status);
    }

    public boolean verifyBatchRequestSaved() {
        testStepsLog(generics.getText(lblSuccessfulSubmitBatchRequest));
        boolean bool = generics.getText(lblSuccessfulSubmitBatchRequest).equals(BATCH_REQUEST_SAVED);
        generics.clickOn(btnBackToBatches);
        return bool;
    }

    public boolean verifyMeasurementDisplaySelected() {
        return lstRadioButtons.get(0).getAttribute("class").contains("mat-radio-checked") ||
                lstRadioButtons.get(1).getAttribute("class").contains("mat-radio-checked");
    }

    public boolean verifyPanelOneInformationDisplay() {
        System.out.println(generics.getValue(txtEstLoads) + "   " + BatchPage._estLoads);
        System.out.println(generics.getValue(txtEstWeight) + "   " + BatchPage._estWeight);
        System.out.println(generics.getValue(txtEstVolume) + "   " + BatchPage._estVolume);
        return generics.getValue(txtEstDate).equalsIgnoreCase(BatchPage._estDate) &&
                generics.getValue(txtBatchName).equalsIgnoreCase(BatchPage._batchName) &&
                generics.getValue(txtBatchId).equalsIgnoreCase(BatchPage._batchId) &&
                generics.getValue(txtEstLoads).equalsIgnoreCase(BatchPage._estLoads) &&
                generics.getValue(txtEstWeight).equalsIgnoreCase(BatchPage._estWeight) &&
                generics.getValue(txtEstVolume).equalsIgnoreCase(BatchPage._estVolume);
    }

    public boolean verifyPanelTwoInformationDisplay() {
        boolean bool = true;
        if (!BatchPage._sourceType.equalsIgnoreCase(OTHER))
            bool = generics.getText(lblSelectedSourceType).equalsIgnoreCase(BatchPage._sourceType);
        if (!BatchPage._siteHistory.equalsIgnoreCase(OTHER))
            bool = bool && generics.getText(lblSelectedSiteHistory).equalsIgnoreCase(BatchPage._siteHistory);
        return generics.getText(lblSelectedSourceSite).equalsIgnoreCase(BatchPage._sourceSite) && bool &&
                generics.getText(lblSelectedPrimaryContact).equalsIgnoreCase(BatchPage._primaryContact) &&
                generics.getValue(txtPresentUse).equalsIgnoreCase(BatchPage._presentUse);
    }

    public boolean verifyReceivingSiteNameAndAddressDisplay() {
        List<String> siteName = new LinkedList<>();
        List<String> siteAddress = new LinkedList<>();
        lstReceivingSiteName.forEach((option) -> siteName.add(generics.getText(option)));
        lstReceivingSiteAddress.forEach((option) -> siteAddress.add(generics.getText(option)));
        return !siteName.isEmpty() && !siteAddress.isEmpty();
    }

    public boolean verifyReceivingSiteSearchedSuccessfully() {
        List<String> siteName = new LinkedList<>();
        lstReceivingSiteName.forEach((option) -> siteName.add(generics.getText(option)));
        boolean bool = true;
        for (String option : siteName) {
            if (!option.equalsIgnoreCase(BatchPage._receivingSite)) {
                bool = false;
                break;
            }
        }
        return bool;
    }

    public boolean verifyReceivingSiteSelected() {
        return receivingSiteName.getText().equalsIgnoreCase(BatchPage._receivingSite) &&
                receivingSiteAddress.getText().replace("location_on\n", "")
                        .equalsIgnoreCase(BatchPage._receivingSiteAddress);
    }

    public boolean verifyPanelThreeInformationDisplay() {
        return generics.getText(lblSelectedSoilDescription).equalsIgnoreCase(BatchPage._soilDescription) &&
                generics.getText(lblSelectedSoilQuality).equalsIgnoreCase(BatchPage._soilQuality) &&
                generics.getValue(lblSoilAnalysisParameter).equalsIgnoreCase(BatchPage._analysisParams) &&
                receivingSiteName.getText().equalsIgnoreCase(BatchPage._receivingSite) &&
                receivingSiteAddress.getText().equalsIgnoreCase(BatchPage._receivingSiteAddress);
    }

}