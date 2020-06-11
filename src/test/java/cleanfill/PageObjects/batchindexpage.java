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
        generics.pause(1);
        generics.type(txtassignusersearch, "Fill Site User1");
        testStepsLog("Fill site user searched ");
       // generics.moveTo(ddfillsiteuser);
        generics.clickOn(ddfillsiteuser);
        testStepsLog("Fill site user selected ");
        fillsiteuser="Fill Site User1";
        searchfillsiteuser=generics.getText(tblassignedto);

        if (searchfillsiteuser.equals(fillsiteuser))
        {
            System.out.println("Test Passed : Fill Site user is assigned successfully ");

        } else {
            System.out.println("Test Failed : Fill Site user is not assigned ");

        }}

    @FindBy(xpath = "//li[contains(text(),'My Batches')]")
    public WebElement btnmybatches;

    public void verifymybatches() {
        generics.moveTo(btnmybatches);
        generics.clickOn(btnmybatches);
        generics.moveTo(tblsearchbatch);
        searchedbatch=generics.getText(tblsearchbatch);
        generics.moveTo(tblassignedto);
        searchfillsiteuser=generics.getText(tblassignedto);
        if (searchfillsiteuser.equals(fillsiteuser)&&searchedbatch.equals(batch))
        {
            System.out.println("Test Passed : Fill Site user is assigned successfully in my batches section ");

        } else {
            System.out.println("Test Failed : Fill Site user is not assigned in my bathces section");

        }}}















