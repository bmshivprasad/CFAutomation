package cleanfill.PageObjects;
import cleanfill.base.Generics;

import cleanfill.testcases.batchindex;
import cleanfill.testcases.batchrequest;
import cleanfill.utilities.ExcelColumns;
import cleanfill.PageObjects.cleanfillPage;




import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static cleanfill.PageObjects.cleanfillPage.batch;
import static cleanfill.PageObjects.cleanfillPage.searchedbatch;


public class batchindexpage extends batchindex implements ExcelColumns


{

    private WebDriver localDriver;
    private Generics generics;

    public batchindexpage(WebDriver baseDriver) {
        this.localDriver = baseDriver;
        PageFactory.initElements(localDriver, this);
        generics = new Generics(localDriver);
        log4j = Logger.getLogger("Batch Index");
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
        testStepsLog("Click on SignIn button");

    }


    @FindBy(xpath = "//button[@routerlink='batches']//mat-icon")
    WebElement batcheicon;



    //@FindBy(xpath = "//div[@class='top-nav__menu']")
    @FindBy(xpath="//button[@class='mat-focus-indicator mat-menu-trigger portal-btn mat-button mat-button-base']")
    public WebElement drpportal;
    //@FindBy(xpath = "(//h4[contains(text(),'Receiving Site Portal')])[2]")
    @FindBy(xpath ="//h4[contains(text(),'Receiving Site Portal')]")
    public WebElement drprecievingsite;
    @FindBy(xpath = "//ng-select[@attr.data-meta='SearchBatch']//input")
    public WebElement txtsearchbatch;
    @FindBy(xpath = "//tbody[@role='rowgroup']/tr[1]/td[3]")
    public WebElement tblsearchbatch;
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

            System.out.println("Test Passed : New Batch created is searchable in receiving portal for the fill site user ");

        } else {
            System.out.println("Test Failed : New Batch created is not searchable in receiving portal for the fill site user ");

        }}


    @FindBy(xpath = "//span[contains(text(),'Assign a User ')]")
    WebElement drpassignuser;

    @FindBy(xpath = "//input[@placeholder='Search...']")
    WebElement txtassignusersearch;

    @FindBy(xpath = "//user-card[@class='user-card-row ng-star-inserted']//h6[1]")
    WebElement ddfillsiteuser;

    @FindBy(xpath = "//tbody[@role='rowgroup']/tr[1]/td[12]")
    public WebElement tblassignedto;
static String fillsiteuser;
static String searchfillsiteuser;

    public void assignfillsiteuser() {
        generics.moveTo(drpassignuser);
        generics.clickOn(drpassignuser);
        testStepsLog("Assign user clicked ");
        generics.moveTo(txtassignusersearch);
        generics.clickOn(txtassignusersearch);
        //generics.pause(1);
        generics.type(txtassignusersearch, "Fill Site User1");
        generics.pause(3);
        testStepsLog("Fill site user searched ");
       // generics.moveTo(ddfillsiteuser);
        generics.clickOn(ddfillsiteuser);
        testStepsLog("Fill site user selected ");
        fillsiteuser="Fill Site User1";
        searchfillsiteuser=generics.getText(tblassignedto);

        if (searchfillsiteuser.equals(fillsiteuser))
        {
            System.out.println("Test Passed : Fill Site user is assigned successfully ");
            generics.pause(2);
        } else {
            System.out.println("Test Failed : Fill Site user is not assigned ");

        }}

    @FindBy(xpath = "//li[contains(text(),'My Batches')]")
    public WebElement btnmybatches;
    @FindBy(xpath = "//tbody[@role='rowgroup']/tr[1]/td[4]")
    public WebElement tblthirdstatus;
    static String thirdstatus;
    static String thirdstatusexp;
    public void verifymybatches() {
        generics.moveTo(btnmybatches);
        generics.clickOn(btnmybatches);
        testStepsLog("My Batches Clicked");
        generics.type(txtsearchbatch, batch);
        generics.moveTo(tblsearchbatch);
        searchedbatch=generics.getText(tblsearchbatch);
        generics.moveTo(tblassignedto);
        testStepsLog("Verified 'Assigned to' field ");
        searchfillsiteuser=generics.getText(tblassignedto);
        generics.moveTo(tblthirdstatus);
        thirdstatus=generics.getText(tblthirdstatus);
        System.out.println("Current Batch status is "  +thirdstatus);
        thirdstatusexp="In Review: Receiving Site";
        if (searchfillsiteuser.equals(fillsiteuser)&&searchedbatch.equals(batch)&&thirdstatus.equalsIgnoreCase(thirdstatusexp))
        {
            System.out.println("Test Passed : Fill Site user is assigned successfully in my batches section ");
            generics.clickOn(tblsearchbatch);
            testStepsLog("clicked on batch hyperlink ");
        } else {
            System.out.println("Test Failed : Fill Site user is not assigned in my bathces section");

        }}
    @FindBy(xpath = "//span[contains(text(),'Next')]")
    public WebElement btnnextload;
    public void  reviewnextload() {
        generics.clickOn(btnnextload);
        testStepsLog("clicked next on load page ");
        }
    @FindBy(xpath = "//span[contains(text(),'Next')]")
    public WebElement btnnextsoucesite;
    public void  reviewnextsource() {
        generics.clickOn(btnnextsoucesite);
        testStepsLog("clicked next on site source page ");

    }
    @FindBy(xpath = "//span[contains(text(),'Next')]")
    public WebElement btnnextsoil;
    public void  reviewnextsoil() {
        generics.clickOn(btnnextsoil);
        testStepsLog("clicked next on soil description page ");

    }
    @FindBy(xpath = "//span[contains(text(),'Approve: Forward to Qualified Persons ')]")
    public WebElement btnfwdqp;
    public void  approvefillsite() {
        generics.clickOn(btnfwdqp);
        testStepsLog("clicked on Forward to Qualified Persons "); }


    @FindBy(xpath = "//input[@formcontrolname= 'suggestedNumOfLoads']")
    public WebElement txtsuggstload;
    public void  suggestload() {
        generics.clickOn(txtsuggstload);
        generics.type(txtsuggstload,"999999");
        testStepsLog("Entered Suggested load ");

    }
    @FindBy(xpath = "//input[@formcontrolname= 'requestedNumOfLoads']")
    public WebElement txtrequestload;
    static String requestedload;
    public void  requestload() {
        generics.clickOn(txtrequestload);
        requestedload=generics.getText(txtrequestload);
        if(requestedload.equals(999999))
        {
            System.out.println("Test Passed : Estimated load is auto populated as Requested load ");

        } else {
            System.out.println("Test Failed : Estimated load is not auto populated as Requested load");
            generics.type(txtrequestload,"999999");
            testStepsLog("Entered request load ");
        }}

@FindBy(xpath = "//input[@value= 'Prepaid']")
public WebElement radioinvtype;
    public void  invoicetype() {
        generics.moveTo(radioinvtype);
        generics.clickOn(radioinvtype);
        generics.type(txtsuggstload,"999999");
        testStepsLog("Prepaid Invoice Selected ");
    }

    @FindBy(xpath = "//input[@formcontrolname= 'pricePerLoad']")
    public WebElement txtprcperload;
    public void  priceperload() {
        generics.clickOn(txtprcperload);
        generics.type(txtprcperload,"888888");
        testStepsLog("Price per load entered ");

    }
    @FindBy(xpath = "//input[@formcontrolname= 'haulingFeePerLoad']")
    public WebElement txtfeeperload;
    public void  feeperload() {
        generics.clickOn(txtfeeperload);
        generics.type(txtfeeperload,"777777");
        testStepsLog("Hauling fee per load entered ");

    }
@FindBy(xpath = "//ng-select[@formcontrolname= 'qpCompanyIdForQualityAssessment']//input")
public WebElement drpqualifiedprsn;
    @FindBy(xpath = "//div[contains(@role,'option')][1]/span[1]")
    public WebElement qualifiedprsnselect;
    public void  qualifiedperson() {
        generics.clickOn(drpqualifiedprsn);
        generics.pause(1);
        generics.moveTo(qualifiedprsnselect);
        generics.clickOn(qualifiedprsnselect);
        testStepsLog("Qualified Person selected ");
    }
    @FindBy(xpath = "//span[contains(text(),' Submit to Qualified Persons ')]")
    public WebElement btnsumitqp;
    public void  submitqp() {
        generics.clickOn(btnsumitqp);
        testStepsLog("Submit to QP clicked ");

    }
    @FindBy(xpath = "//section[@class='fs-approval']//h4")
    public WebElement popfsgranted;

    @FindBy(xpath = "//section[@class='fs-approval']//p")
    public WebElement popqpfwd;

    @FindBy(xpath = "//*[@id='mat-dialog-1']/fill-site-approval-grant/section/button/span")
    public WebElement btnbacktobatches;

    static String popupfs;
    static String popupqpfwd;
    static String popupfsmsg;
    static String popupqpfwdmsg;
    public void  fsgrantedpopup() {
        generics.clickOn(popfsgranted);
        popupfs=generics.getText(popfsgranted);
        generics.clickOn(popqpfwd);
        popupqpfwd=generics.getText(popqpfwd);
        popupfsmsg ="Receiving Site Approval Granted";
        popupqpfwdmsg="This batch has now been forwarded to the assigned Qualified Persons for quality assessment. The unit price has also been shared with the client.";

        if(popupfs.equalsIgnoreCase(popupfsmsg)&&popupqpfwd.equalsIgnoreCase(popupqpfwdmsg))
        {
            System.out.println("Test Passed : Fill Site Approval confirmation messages as expected ");
            generics.moveTo(btnbacktobatches);
            generics.clickOn( btnbacktobatches);
            testStepsLog("Clicked on back to batches ");
            generics.pause(1);

        } else {
            System.out.println("Test Failed : Fill Site Approval confirmation messages are not as expected ");
            generics.moveTo(btnbacktobatches);
            generics.clickOn(btnbacktobatches);
            testStepsLog("Clicked on back to batches ");
            generics.pause(1);
        }}
    @FindBy(xpath = "//tbody[@role='rowgroup']/tr[1]/td[4]")
    public WebElement tblfourthtatus;
    static String fourthstatus;
    static String fourthstatusexp;
    public void verifyfourthstatus() {
        /*generics.moveTo(drpportal);
        generics.pause(1);
        generics.clickOn(drpportal);
        generics.clickOn(drprecievingsite);
        testStepsLog("Recieving Site Selected");
        generics.pause(1);*/
        generics.moveTo(btnmybatches);
        generics.clickOn(btnmybatches);
        generics.pause(1);
        testStepsLog("My Batches Clicked");
        generics.type(txtsearchbatch, batch);
        generics.pause(1);
        generics.moveTo(tblsearchbatch);
        searchedbatch=generics.getText(tblsearchbatch);
        generics.moveTo(tblfourthtatus);
        fourthstatus=generics.getText(tblfourthtatus);
        testStepsLog("Batch Status is  "+fourthstatus);
        fourthstatusexp="Pending: Qualified Persons";
        if (searchedbatch.equals(batch)&&fourthstatus.equalsIgnoreCase(fourthstatusexp))
        {
            System.out.println("Test Passed : Current Batch status is "  +fourthstatus);
        } else {
            System.out.println("Test Failed : Expected Current Batch status is  "  +fourthstatusexp );

        }}
    }



















