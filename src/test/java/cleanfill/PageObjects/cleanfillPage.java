package cleanfill.PageObjects;

import cleanfill.base.Generics;
import cleanfill.testcases.batchrequest;
import cleanfill.utilities.ExcelColumns;


import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;
import org.junit.runner.Result;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import static java.lang.Double.parseDouble;


public class cleanfillPage < result > extends batchrequest implements ExcelColumns {


    private WebDriver localDriver;
    private Generics generics;
    private SoftAssert Soft_Assert;
    //public static int trucks;

    public cleanfillPage(WebDriver baseDriver) {
        this.localDriver = baseDriver;
        PageFactory.initElements(localDriver, this);
        generics = new Generics(localDriver);
        log4j = Logger.getLogger("Create Batch Request");
    }


    @FindBy(xpath = "//button[@routerlink='batches']//mat-icon")
    WebElement batcheicon;

    @FindBy(xpath = "//span[text()='Batches']")
    WebElement lnkbatches;

    public void clickonbatche() {
        generics.pause(1);
        generics.moveTo(batcheicon);
        generics.pause(1);
        generics.clickOn(lnkbatches);
        testStepsLog("Batches opend");
    }

    @FindBy(xpath = "//input[@type='email']")
    WebElement txtUsername;

    @FindBy(xpath = "//input[@type='password']")
    WebElement txtPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnSubmit;

    public void loginAs(String username, String password) {
        generics.pause(2);
        generics.type(txtUsername, username);
        testStepsLog("Enter Username : " + username);
        generics.pause(1);
        generics.clickOn(btnSubmit);
        generics.pause(1);
        testStepsLog("Click on SignIn button");
        generics.type(txtPassword, password);
        testStepsLog("Enter Password");
        generics.clickOn(btnSubmit);
        testStepsLog("Click on SignIn button"); //generics.clickOn(btnSubmit);

    }

    @FindBy(xpath = "//span[contains(text(),'New Batch Request ')]")
    //@FindBy(xpath = "/html/body/app-root/side-nav/mat-drawer-container/mat-drawer-content/section/batches/div[1]/button")
    WebElement btncreatebatch;

    public void clickonbatchcreate() {

        generics.moveTo(batcheicon);
        generics.pause(2);
        generics.clickOn(btncreatebatch);
        testStepsLog("New Batch request clicked ");
        generics.pause(3);
    }

    @FindBy(xpath = "//input[@formcontrolname='estimatedStartDate']")
    public WebElement batchdate;

    public void enterbatchdate() {
        generics.waitForElementVisible(batchdate);
        generics.moveTo(batchdate);
        generics.clickOn(batchdate);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate localDate = LocalDate.now();
        batchdate.sendKeys(dtf.format(localDate));
    }

    //private boolean isEnabled(WebElement btnpastdate) {
       // return false;
    //}
    //@FindBy(xpath = "//mat-datepicker-toggle[@class='mat-datepicker-toggle ng-tns-c111-137']")
    //@FindBy(xpath ="//button[@aria-label='Open calendar']//span")

    @FindBy(xpath = "//button[@aria-label='Open calendar']")
    public WebElement btneststartDate;
    // @FindBy(xpath = "//td[@aria-selected='false' and contains(@tabindex,'0')]")
    @FindBy(xpath = "//div[contains(@class,'today')]")
    public WebElement btncurrentdate;
    @FindBy(xpath = "//td[contains(@class,'body-disabled')]")
    public WebElement btnpastdate;

    public void selecteststartDate() {
        generics.clickOn(btneststartDate);
        testStepsLog("Date icon clicked ");
        generics.pause(1);
       // boolean pastdate = isEnabled(btnpastdate);
        //if (pastdate == true)
        if (generics.isPresent(btnpastdate))
        {

            System.out.println(" Test Passed :Past date are ready only ");
        } else {

            System.out.println(" Test Failed:Past date is clickable");
        }
        generics.clickOn(btncurrentdate);
        testStepsLog("Today's Date selected ");

    }

    @FindBy(xpath = "//input[@formcontrolname='batchName']")
    public WebElement txtbatchname;
    // @FindBy(xpath = "//div[@style='opacity: 1; transform: translateY(0%);']")
    // public WebElement txtsevebcharacters;
    @FindBy(xpath = "//mat-error[@role='alert']")
    public WebElement txtsevebcharacterse;
    @FindBy(xpath = "//input[@formcontrolname='batchId']")
    public WebElement txtbatchid;
    static String batch;

    public void enterbatchname() {

        generics.type(txtbatchname, "abcdefhh");
        testStepsLog("Batch Name Entered");
        generics.clickOn(txtbatchid);
        //testStepsLog("Clicked out ");
        //generics.clickOn(txtsevebcharacterse);
        String valseven = txtsevebcharacterse.getText();
        System.out.println("Error message is :" + valseven);
        boolean error = generics.isPresent(txtsevebcharacterse);

        if (error == true) {

            System.out.println("Test Passed : Error message displayed");
        } else {

            System.out.println("Test Failed: Error message not displayed");
        }

        batch = generics.getRandomCharacters(7);
        generics.type(txtbatchname, batch);
        testStepsLog("batch name inserted : " + batch);
    }

    @FindBy(xpath = "//div[contains(text(),'Track by Load')]")

    public WebElement radiotrcbyload;

    public void trackbyload() {
        radiotrcbyload.isDisplayed();
        testStepsLog("Track by Load displayed ");
        generics.clickOn(radiotrcbyload);
        testStepsLog("Track by Load clicked ");
    }

    @FindBy(xpath = "//div[contains(text(),'Track by Weight')]")

    public WebElement radiotrcbyWeight;

    public void trackbyweight() {
        radiotrcbyWeight.isDisplayed();
        testStepsLog("Track by Weight displayed");
        generics.clickOn(radiotrcbyWeight);
        testStepsLog("Track by Weight clicked");
    }

    @FindBy(xpath = "//input[@formcontrolname='estimatedLoads']")

    public WebElement intesitimatedloads;

    public void estimatedloads() {
        intesitimatedloads.click();
        intesitimatedloads.sendKeys("999999");
        testStepsLog("Entered Estimated Loads");
    }

    @FindBy(xpath = "//input[@formcontrolname='numberOfTrucks']")

    public WebElement intnumberOfTrucks;

    public void numberOfTrucks() {
        intnumberOfTrucks.sendKeys("999999");
        testStepsLog("Entered Number of Trucks");
  /* Date d1= new Date();
   SimpleDateFormat not =new SimpleDateFormat("yyyyMM");
   intnumberOfTrucks. sendKeys("not"); */
        //generics.getRandomBetween(111111,999999)

  /*SecureRandom random = new SecureRandom();
  int num = random.nextInt(100000);
  String formatted = String.format("%05d", num);
  intnumberOfTrucks. sendKeys("formatted");*/
    }

    @FindBy(xpath = "//input[@formcontrolname='estimatedWeight']")

    public WebElement intestimatedweights;

    public void estimatedweight() {
        intestimatedweights.sendKeys("999999.99");
        testStepsLog("Entered Estimated Loads");
    }

    @FindBy(xpath = "//input[@formcontrolname='estimatedVolume']")
    public WebElement intestimatedvolume;

    public void txtestimatedvol() {
        SoftAssert softAssert = new SoftAssert();
        String result = (intestimatedvolume.getAttribute("value"));
        double d = parseDouble(result);
        softAssert.assertEquals(result, "414937.75");
        testStepsLog("Estimated Volume verified");
        Double evolume = Double.valueOf("414937.75");
        System.out.println("Actual value is " + result);
        System.out.println("Expected value is " + evolume);
        if (d == evolume) {
            System.out.println("pass");
        } else {

            System.out.println("Test failed:Estimated Volume calculation is not as expected ");

        }
        intestimatedvolume.click();
        intestimatedvolume.sendKeys(Keys.CONTROL, Keys.chord("a"));
        testStepsLog("CONTROL A DONE ");
        intestimatedvolume.sendKeys(Keys.BACK_SPACE);
        testStepsLog("DELETED TEXT");
        generics.pause(2);
        intestimatedvolume.sendKeys("111111");
        testStepsLog("Entered Estimated Loads");

    }

    @FindBy(xpath = "//span[contains(text(),'Next')]")
    public WebElement btnbatchnext;

    public void batchnext() {
        generics.clickOn(btnbatchnext);
        testStepsLog("Next button clicked");
    }

    @FindBy(xpath = "//ng-select[@formcontrolname='sourceSite']")

    public WebElement drpdwnsorcesiteopen;

    public void sourcesiteopen() {
        //drpdwnsorcesiteopen.click();
        generics.clickOn(drpdwnsorcesiteopen);
        testStepsLog("Source Site Dropdown value opened");
    }

    @FindBy(xpath = "//ng-dropdown-panel//div[contains(@role,'option')][1]/span")
    public WebElement drpdwnsorcesite;

    public void sourcesite() {
        //drpdwnsorcesite.click();
        generics.clickOn(drpdwnsorcesite);
        testStepsLog("Source Site Dropdown value selected");
    }

    //@FindBy(xpath ="//mat-option[contains(@role,'option')][1]/span")
    // @FindBy(xpath ="(//span[text()='Choose an option'])[1]")
    @FindBy(xpath = "//ng-select[@attr.data-meta='SourceTypeDD']")
    public WebElement drpdwnsorcetypeopen;

    public void sourcesitetypeopen() {
        //drpdwnsorcetypeopen.click();
        generics.clickOn(drpdwnsorcetypeopen);
        testStepsLog("Source Site Dropdown type value opened");
    }

    // @FindBy(xpath ="//mat-option[contains(@role,'option')][2]/span"
    @FindBy(xpath = "//div[contains(@role,'option')][1]/span")
    //mat-option[contains(@role,'option')][3]/span
    //mat-option[contains(@role,'option')][4]/span
    public WebElement drpdwnsorcesiteoption;

    public void sourcetypeoption() {
        //Select selec = new Select(drpdwnsorcesiteoption);
        //selec.selectByValue("Treatment Facility");
        //drpdwnsorcesiteoption.click();
        generics.clickOn(drpdwnsorcesiteoption);
        testStepsLog("Source Site Type value selected");
    }

    //@FindBy(xpath ="(//span[text()='Choose an option'])[2]")
    // @FindBy(xpath ="//*[@id='mat-select-8']")
    //@FindBy(xpath ="(//span[text()='Choose an option'])[1]")
    @FindBy(xpath = "//ng-select[@attr.data-meta='SourceSiteHistoryDD']")
    public WebElement drpdwnsorcesitehistory;

    public void sourcesitehstry() {
        drpdwnsorcesitehistory.click();
        testStepsLog("Source Site history opened");
        generics.pause(2);
    }

    // @FindBy(xpath ="//mat-option[contains(@role,'option')][2]/span")
    @FindBy(xpath = "//div[contains(@role,'option')][2]/span")
    public WebElement drpdwnsorcesitehistoryoption;

    public void sourcesitehstryselect() { //input[@formcontrolname='primaryContact']
        //drpdwnsorcesitehistoryoption.click();
        generics.clickOn(drpdwnsorcesitehistoryoption);
        testStepsLog("Source Site history selected");
    }

    //input[@formcontrolname='presentUse']
    @FindBy(xpath = "//input[@formcontrolname='presentUse']")
    public WebElement txtpresentuse;

    public void presentuse() {
        txtpresentuse.sendKeys("AutomationPresentSite");
        testStepsLog("Present Use Entered");
    }

    @FindBy(xpath = "//textarea[@formcontrolname='analyticalReference']")
    public WebElement txtaddrefnotes;

    public void addrefnotes() {
        txtaddrefnotes.sendKeys("AutomationAdditionalRefNotes");
        testStepsLog("Additionnal Ref Notes Entered");
    }

    @FindBy(xpath = "//ng-select[@formcontrolname='primaryContact']")
    public WebElement drpprmrycontact;

    public void primarycontact() {
        //txtprmrycontact.sendKeys("AutomationPrimaryconatctname");
        generics.clickOn(drpprmrycontact);
        testStepsLog("Primary Contact menu opened");
        generics.pause(2);
    }

    //@FindBy(xpath = "//span[text()='Site User']"
    @FindBy(xpath = "//div[contains(@role,'option')][1]/span[1]")
    public WebElement drprmrycontactoption;

    public void primarycontactoptions() {
        //txtprmrycontact.sendKeys("AutomationPrimaryconatctname");
        generics.clickOn(drprmrycontactoption);
        testStepsLog("Primary Contact menu selected");
    }

    @FindBy(xpath = "//ng-select[@formcontrolname='assignedQp']")
    public WebElement drpqualifiedprsn;

    public void qualifiedperson() {
        generics.clickOn(drpqualifiedprsn);
        testStepsLog("Qualified person menu opened");
        generics.pause(2);

        //h2[contains(text(),'Select a Source Type ')] */
    }

    @FindBy(xpath = "//div[contains(@role,'option')][1]/span[1]")
    public WebElement drpqualifiedprsnoption;

    public void qualifiedpersonoptn() {
        generics.clickOn(drpqualifiedprsnoption);
        testStepsLog("Qualified person menu selected");

        //h2[contains(text(),'Select a Source Type ')] */
    }

    @FindBy(xpath = "//span[contains(text(),'Next')]")
    //@FindBy(xpath = "/html/body/app-root/side-nav/mat-drawer-container/mat-drawer-content/section/editable-batch/form/panels/div[2]/div[1]/button[2]")
    public WebElement btnnextssinfo;

    public void nextssinfo() {
        //btnnextssinfo.click();
        generics.clickOn(btnnextssinfo);
        testStepsLog("Next button clicked in source site page");
        //h2[contains(text(),'Select a Source Type ')] */
    }

    @FindBy(xpath = "//ng-select[@formcontrolname='soilDescription']")
    public WebElement drpsoildesc;

    public void soildescription() {
        generics.clickOn(drpsoildesc);
        testStepsLog("Soil Description drop down opened");
    }

    @FindBy(xpath = "//div[contains(@role,'option')][2]/span")
    public WebElement drpsoildescoption;

    public void soildescriptionoptn() {
        generics.clickOn(drpsoildescoption);
        testStepsLog("Soil Description drop down option selected");
    }

    @FindBy(xpath = "//ng-select[@formcontrolname='soilQuality']")
    public WebElement drpsoilquantity;

    public void soilquantity() {
        generics.clickOn(drpsoilquantity);
        testStepsLog("Soil quantity drop down opened");
    }

    @FindBy(xpath = "//div[contains(@role,'option')][2]/span[1]")
    //*[@id="mat-option-25"]/span
    public WebElement drpsoilqtyoption;

    public void soilqtyriptionoptn() {
        generics.clickOn(drpsoilqtyoption);
        testStepsLog("Soil quantity drop down option selected");
    }

    //@FindBy(xpath ="//label[@for='mat-radio-5-input']")
    @FindBy(xpath = "//mat-radio-group[@formcontrolname='needPlacedBelowGrade']//div[contains(text(),'Yes')]")
    public WebElement radiomtrlyes;

    public void materialyes() {
        generics.clickOn(radiomtrlyes);
        testStepsLog("Clicked Radio button MaDoes this material need to be placed 1.5m below grade? = yes");
    }

    @FindBy(xpath = "//mat-radio-group[@formcontrolname='needPlacedBelowGrade']//div[contains(text(),'No')]")
    public WebElement radiomtrlno;

    public void materialno() {
        generics.clickOn(radiomtrlno);
        testStepsLog("Clicked Radio button Does this material need to be placed 1.5m below grade?  = No");
    }

    @FindBy(xpath = "//mat-radio-group[@formcontrolname='screenedToRemoveDebris']//div[contains(text(),'Yes')]")
    public WebElement radiodebrisyes;

    public void debrisyes() {
        generics.clickOn(radiodebrisyes);
        testStepsLog("Clicked Radio button Has the soil been screened to remove debris? = yes");
    }

    @FindBy(xpath = "//mat-radio-group[@formcontrolname='screenedToRemoveDebris']//div[contains(text(),'No')]")
    public WebElement radiodebrisno;

    public void debrisno() {
        generics.clickOn(radiodebrisno);
        testStepsLog("Clicked Radio button Has the soil been screened to remove debris?= No");
    }

    @FindBy(xpath = "//input[@formcontrolname='placedBelowGradeReason']")
    public WebElement txtgradereason;

    public void entergradereason() {
        generics.clickOn(txtgradereason);
        generics.type(txtgradereason, "Automated Test Grade Reason");
        testStepsLog("Soil Placed Below Grade Reason Text Entered ");
    }

    @FindBy(xpath = "//input[@formcontrolname='soilNotScreenedReason']")
    public WebElement txtdebrisreason;

    public void enterdebrisreason() {
        generics.clickOn(txtdebrisreason);
        generics.type(txtdebrisreason, "Automated Test Debris Reason");
        testStepsLog("Soil Placed Below Grade Reason Text Entered ");
    }

    @FindBy(xpath = "//mat-basic-chip[contains(text(),'F1F4')]")
    public WebElement btnanalysis;

    public void analysisone() {
        generics.clickOn(btnanalysis);
        testStepsLog("Clicked button FIF4");
    }

    @FindBy(xpath = "//mat-basic-chip[contains(text(),'Inorg')]")
    public WebElement btnanalysisinorg;

    public void analysisinorg() {
        generics.clickOn(btnanalysisinorg);
        testStepsLog("Clicked button Inorg");
    }

    @FindBy(xpath = "//mat-basic-chip[contains(text(),'Metals')]")
    public WebElement btnanalysismetals;

    public void analysismetals() {
        generics.clickOn(btnanalysismetals);
        testStepsLog("Clicked button metals");
    }

    @FindBy(xpath = "//mat-basic-chip[contains(text(),'PCB')]")
    public WebElement btnanalysispcb;

    public void analysispcb() {
        generics.clickOn(btnanalysispcb);
        testStepsLog("Clicked button pcb");
    }

    @FindBy(xpath = "//mat-basic-chip[contains(text(),'Pest')]")
    public WebElement btnanalysispest;

    public void analysispest() {
        generics.clickOn(btnanalysispest);
        testStepsLog("Clicked button pest");
    }

    @FindBy(xpath = "//mat-basic-chip[contains(text(),'SVOC')][1]")
    public WebElement btnanalysissvoc;

    public void analysissvoc() {
        generics.clickOn(btnanalysissvoc);
        testStepsLog("Clicked button svoc");
    }

    @FindBy(xpath = "//mat-basic-chip[contains(text(),'Other')]")
    public WebElement btnanalysisother;

    public void analysisother() {
        generics.clickOn(btnanalysisother);
        testStepsLog("Clicked button other");
    }

    @FindBy(xpath = " //input[@formcontrolname='otherAnalysisParamNum']")

    public WebElement txtother;
    public void othertextbox() {
        generics.clickOn(txtother);
        String other = generics.getRandomCharacters(7);
        generics.type(txtother, other);
        testStepsLog("Other Description inserted : " + other);

    }

    @FindBy(xpath = "//mat-basic-chip[contains(text(),'VOC')][2]")
    public WebElement btnanalysisvoc;

    public void analysisvoc() {
        generics.clickOn(btnanalysisvoc);
        testStepsLog("Clicked button voc");
    }

    @FindBy(xpath = "//div[@class='cmn-selectbox']")
    public WebElement recvngsite;

    public void drprecvngsite() {
        generics.clickOn(recvngsite);
        testStepsLog("Receiving Site Option list opened");
    }

    @FindBy(xpath = "//div[contains(@role,'option')][1]/span")
    public WebElement recvngsitedrpdwn;

    public void drpdwnrecvngsite() {
        generics.clickOn(recvngsitedrpdwn);
        testStepsLog("Receiving Site Option list selected ");
    }

    @FindBy(xpath = "//span[contains(text(),'Next')]")
    //@FindBy(xpath = "/html/body/app-root/side-nav/mat-drawer-container/mat-drawer-content/section/editable-batch/form/panels/div[2]/div[1]/button[2]")
    public WebElement btnnextsoildesc;

    public void nextsoildesc() {
        btnnextssinfo.click();
        testStepsLog("Next buttom clicked in soil description page");
    }

    @FindBy(xpath = "//span[contains(text(),' + Choose File ')]")
    public WebElement btnFileUpload;

    public void UploadFile() {
        try {
            generics.pause(5);
            Actions action = new Actions(localDriver);
            action.moveToElement(btnFileUpload, 20, 0).click().build().perform();
            Robot robot = new Robot();
            generics.pause(5);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection stringSelection = new StringSelection(TEST_DATA_LOCATION + File.separator + "WO.PNG");
            clipboard.setContents(stringSelection, null);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            testStepsLog("Clicked on File Upload 1");
            //generics.pause(5);


        } catch (Exception e) {
            testStepsLog("File Not uploaded");
        }
       try {
            generics.pause(5);
            Actions action = new Actions(localDriver);
            action.moveToElement(btnFileUpload, 20, 0).click().build().perform();
            Robot robot = new Robot();
            generics.pause(5);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection stringSelection = new StringSelection(TEST_DATA_LOCATION + File.separator + "Signature.PNG");
            clipboard.setContents(stringSelection, null);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            testStepsLog("Clicked on File Upload 2");
            //generics.pause(5);


        } catch (Exception e) {
            testStepsLog("File Not uploaded");
        }
        try {
            generics.pause(5);
            Actions action = new Actions(localDriver);
            action.moveToElement(btnFileUpload, 20, 0).click().build().perform();
            Robot robot = new Robot();
            generics.pause(5);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection stringSelection = new StringSelection(TEST_DATA_LOCATION + File.separator + "Batches.PNG");
            clipboard.setContents(stringSelection, null);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            testStepsLog("Clicked on File Upload 3");
            //generics.pause(5);
        } catch (Exception e) {
            testStepsLog("File Not uploaded");
        }
    }

    @FindBy(xpath = "//span[contains(text(),'+ Add Link')]")
    //@FindBy(xpath = "/html/body/app-root/side-nav/mat-drawer-container/mat-drawer-content/section/editable-batch/form/panels/div[2]/div[1]/button[2]")
    public WebElement btnaddlink;

    public void addlink() {
        generics.pause(2);
        generics.clickOn(btnaddlink);
        testStepsLog("Add link clicked");

    }
    //@FindBy(xpath ="//mat-label[contains(text(),'Paste your link here')]")
    @FindBy(xpath = "//mat-label[contains(text(),'Paste your link here')]/ancestor::span/parent::div/input")
    //@FindBy(xpath = "/html/body/app-root/side-nav/mat-drawer-container/mat-drawer-content/section/editable-batch/form/panels/div[2]/div[1]/button[2]")
    public WebElement txtpastelink;

    public void pastlink() {
        //txtpastelink.click();
        generics.pause(3);
        txtpastelink.sendKeys("https://cleanfill-qa.azurewebsites.net/batches/create");
        txtpastelink.sendKeys(Keys.ENTER);
        testStepsLog(" link pasted");
    }
    @FindBy(xpath = "//textarea[@formcontrolname='comments']")
    public WebElement txtcomment;

    public void comments() {
        txtcomment.sendKeys("Automation Comments");
        testStepsLog(" Comments Entered");
    }

    @FindBy(xpath = "//span[contains(text(), 'Submit Batch Request ')]//parent:: button [@disabled='true']")
    public WebElement btnsubmitbr;
    @FindBy(xpath = "//span[contains(text(), 'Submit Batch Request ')]")
    public WebElement btnsubmitbrtrue;
    public void submitbatchrequest() {
        //driver = new ChromeDriver();
        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("arguments[0].scrollIntoView();", btnsubmitbr);
        generics.pause(4);
        if (generics.isPresent(btnsubmitbr)) {

            System.out.println("Test Failed: Submit Batch button is disabled");

        } else {
            System.out.println("Test Passed : Submit Batch button is enabled");
            generics.moveTo(btnsubmitbrtrue);
            generics.clickOn(btnsubmitbrtrue);
        }
        //String batch = generics.getRandomCharacters(7);
        //generics.type(txtbatchname, batch);
        //testStepsLog("batch name inserted : " + batch);
    }
    @FindBy(xpath = "//span[contains(text(),' Stay on this page ')]")
    public WebElement popsave;
    public void stayonpage() {
        popsave.click();
        testStepsLog(" stay on page pop up closed ");
        generics.pause(1);
    }
    @FindBy(xpath = "//span[text()=' Back to Batches ']")
    public WebElement popbatch;
    public void backtobatches() {

        generics.clickOn(popbatch);
        testStepsLog(" Back to batches pop up closed ");
        generics.pause(5);
        System.out.println("Batch Name is "  +batch);
    }

    @FindBy(xpath = "//ng-select[@attr.data-meta='SearchBatch']//input")
    public WebElement txtsearchbatch;
    @FindBy(xpath = "//tbody[@role='rowgroup']/tr[1]/td[3]")
    public WebElement tblsearchbatch;
    public static String searchedbatch;
    public void batchsearch() {
        generics.pause(5);
        generics.clickOn(txtsearchbatch);
        generics.type(txtsearchbatch, batch);
        generics.pause(5);
        testStepsLog("Batch Name entered on search");
        generics.moveTo(tblsearchbatch);
        searchedbatch=generics.getText(tblsearchbatch);
        System.out.println(searchedbatch);

        if ( searchedbatch.equals(batch)) {

            System.out.println("Test Passed : New Batch created and is searchable under source site portal ");

        } else {
            System.out.println("Test Failed : New Batch created and is not searchable");

        }
}

    //@FindBy(xpath = "//div[@class='top-nav__menu']")
    @FindBy(xpath="//button[@class='mat-focus-indicator mat-menu-trigger portal-btn mat-button mat-button-base']")
    public WebElement drpportal;
    //@FindBy(xpath = "(//h4[contains(text(),'Receiving Site Portal')])[2]")
    @FindBy(xpath ="//h4[contains(text(),'Receiving Site Portal')]")
    public WebElement drprecievingsite;
    public void recvngsiteportal() {
        generics.moveTo(drpportal);
        generics.clickOn(drpportal);
        testStepsLog("Clicked on Portal Navigation");
        //generics.moveTo(drprecievingsite);
        generics.clickOn(drprecievingsite);
        testStepsLog("Selected Recieving Site Portal");
        generics.type(txtsearchbatch, batch);
        generics.pause(5);
        testStepsLog("Batch Name entered on search");
        generics.moveTo(tblsearchbatch);
        searchedbatch=generics.getText(tblsearchbatch);
        System.out.println(searchedbatch);

        if ( searchedbatch.equals(batch)) {

            System.out.println("Test Passed : New Batch created and is searchable in receiving portal ");

        } else {
            System.out.println("Test Failed : New Batch created and is not searchable in receiving portal");

        }

    }



}