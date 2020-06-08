package cleanfill.PageObjects;

import cleanfill.base.Generics;
import cleanfill.testcases.batchindex;
import cleanfill.testcases.batchrequest;
import cleanfill.utilities.ExcelColumns;
import cleanfill.utilities.ExcelUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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


    @FindBy(xpath = "//ng-select[@attr.data-meta='SearchBatch']")
    public WebElement txtsearchbatch;
    public void batchsearch() {
        generics.pause(5);
        generics.clickOn(txtsearchbatch);
       // generics.type(txtsearchbatch, batch);
        testStepsLog("Batch Name entered on search");
        generics.pause(2);
    }}




