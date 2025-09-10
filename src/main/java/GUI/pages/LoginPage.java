package GUI.pages;

import Utilization.JavaScriptUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private JavaScriptUtils javaScriptUtils;

    // Locators
    private By Username_TextField = By.xpath("//input[@name='username']");
    private By Password_TextField = By.xpath("//input[@name='password']");
    private By Login_Btn = By.xpath("//button[@type='submit']");


    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        javaScriptUtils = new JavaScriptUtils(driver);
    }

    // Action Methods
    @Step("Enter username: {email}")
    public void enterUsername(String email) {
        javaScriptUtils.scrollToElement(Username_TextField);
        driver.findElement(Username_TextField).clear();
        driver.findElement(Username_TextField).sendKeys(email);
    }

    @Step("Enter password: {password}")
    public void enterPassword(String password) {
        javaScriptUtils.scrollToElement(Password_TextField);
        driver.findElement(Password_TextField).clear();
        driver.findElement(Password_TextField).sendKeys(password);
    }

    @Step("Click 'Login' button")
    public void clickLogin() {
        javaScriptUtils.scrollToElement(Login_Btn);
        driver.findElement(Login_Btn).click();
    }

    @Step("Login with email: {email} and password: {password}")
    public void login(String email, String password) {
        enterUsername(email);
        enterPassword(password);
        clickLogin();
    }

}
