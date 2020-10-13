package cleanfill.PageObjects;

import cleanfill.base.BaseClass;
import cleanfill.base.Generics;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BaseClass {

    WebDriver localDriver;
    Generics generics;

    public LandingPage(WebDriver baseDriver) {
        this.localDriver = baseDriver;
        PageFactory.initElements(baseDriver, this);
        generics = new Generics(baseDriver);
        log4j = Logger.getLogger("LandingPage");
    }

    @FindBy(xpath = "//button[@routerlink='batches']")
    public WebElement btnBatches;

    @FindBy(xpath = "//button[@routerlink='dashboard']")
    public WebElement btnDashboard;

    @FindBy(xpath = "//button[@routerlink='/haulers']")
    public WebElement btnHaulerManagement;

    @FindBy(xpath = "//button[@routerlink='support']")
    public WebElement btnSupport;

    @FindBy(xpath = "//div[@id='spinner']")
    public WebElement spinner;

    public void clickOnBatches() {
        while (generics.isPresent(spinner)) generics.pause(1);
        testStepsLog("Click on Batches from left panel");
        generics.mouseHover(btnBatches);
        generics.clickOn(btnBatches);
        new WebDriverWait(localDriver, Integer.parseInt(WEBDRIVER_WAIT)).
                until(ExpectedConditions.visibilityOfAllElements(btnBatches, btnDashboard,
                        btnHaulerManagement, btnSupport));
    }

}