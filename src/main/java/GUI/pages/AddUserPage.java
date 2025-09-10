package GUI.pages;

import Utilization.AssertionUtils;
import Utilization.JavaScriptUtils;
import Utilization.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddUserPage {

    private WebDriver driver;
    private WaitUtils waitUtils;
    private JavaScriptUtils javaScriptUtils;

    // Locators
    private By EmployeeName_TextField = By.xpath("//input[@placeholder='Type for hints...']");
    private By Employee_Option = By.xpath("//div[@role='listbox']//div[@role='option'][1]");
    private By Username_TextField = By.xpath("//input[@class='oxd-input oxd-input--active']");
    private By Password_TextField = By.xpath("//input[@class='oxd-input oxd-input--active']");
    private By ConfirmPassword_TextField = By.xpath("//input[@class='oxd-input oxd-input--active']");
    private By UserRole_DDL = By.xpath("//div[@class='oxd-select-text oxd-select-text--active'][contains(.,'-- Select --')]");
    private By UserRole_Admin = By.xpath("//span[normalize-space(text())='Admin']");
    private By Status_DDL = By.xpath("//div[@class='oxd-select-text oxd-select-text--active'][contains(.,'-- Select --')]");
    private By Status_Enabled = By.xpath("//span[normalize-space(text())='Enabled']");
    private By Save_Btn = By.xpath("//button[@type='submit'][contains(.,'Save')]");

    // Constructor
    public AddUserPage(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
        javaScriptUtils = new JavaScriptUtils(driver);
    }

    // Action Methods
    @Step("Enter Employee Name: {employeeName}")
    public void enterEmployeeName(String employeeName) {
        //javaScriptUtils.scrollToElement(EmployeeName_TextField);
        driver.findElement(EmployeeName_TextField).click();
        driver.findElement(EmployeeName_TextField).clear();
        driver.findElement(EmployeeName_TextField).sendKeys(employeeName);
    }

    @Step("Select Employee Option")
    public void selectEmployeeOption() {
        waitUtils.waitForPresence(Employee_Option, 10);
        waitUtils.waitForVisibility(Employee_Option, 10);
        driver.findElement(Employee_Option).click();
    }

    @Step("Enter Username: {username}")
    public void enterUsername(String username) {
        javaScriptUtils.scrollToElement(Username_TextField);
        driver.findElement(Username_TextField).clear();
        driver.findElement(Username_TextField).sendKeys(username);
    }

    @Step("Enter Password")
    public void enterPassword(String password) {
        javaScriptUtils.scrollToElement(Password_TextField);
        driver.findElement(Password_TextField).clear();
        driver.findElement(Password_TextField).sendKeys(password);
    }

    @Step("Enter Confirm Password")
    public void enterConfirmPassword(String confirmPassword) {
        javaScriptUtils.scrollToElement(ConfirmPassword_TextField);
        driver.findElement(ConfirmPassword_TextField).clear();
        driver.findElement(ConfirmPassword_TextField).sendKeys(confirmPassword);
    }

    @Step("Select User Role: Admin")
    public void selectUserRoleAdmin() {
        driver.findElement(UserRole_DDL).click();
        waitUtils.waitForVisibility(UserRole_Admin, 10);
        driver.findElement(UserRole_Admin).click();
    }

    @Step("Select Status: Enabled")
    public void selectStatusEnabled() {
        driver.findElement(Status_DDL).click();
        waitUtils.waitForVisibility(Status_Enabled, 10);
        driver.findElement(Status_Enabled).click();
    }

    @Step("Click Save button")
    public void clickSave() {
        javaScriptUtils.scrollToElement(Save_Btn);
        driver.findElement(Save_Btn).click();
    }
}
