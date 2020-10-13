package cleanfill.PageObjects;

import cleanfill.base.BaseClass;
import cleanfill.base.Generics;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    WebDriver localDriver;
    Generics generics;

    public LoginPage(WebDriver baseDriver) {
        this.localDriver = baseDriver;
        PageFactory.initElements(localDriver, this);
        generics = new Generics(localDriver);
        log4j = Logger.getLogger("LoginPage");
    }

    @FindBy(xpath = "//input[@type='email']")
    public WebElement txtUsername;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement txtPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement btnSubmit;

    public void loginAs(String username, String password) {
        testStepsLog("Login with the " + username + " user email.");
        generics.type(txtUsername, username);
        generics.type(txtPassword, password);
        generics.clickOn(btnSubmit);
    }

}
