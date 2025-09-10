package GUI.pages;

import Utilization.AssertionUtils;
import Utilization.WaitUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserManagementPage {

    private WebDriver driver;
    private AssertionUtils assertionUtils;
    private WaitUtils waitUtils;


    // Locators
    private By Admin_MenuTab = By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][contains(.,'Admin')]");
    private By RecordNumber = By.xpath("//span[@class='oxd-text oxd-text--span']");
    private By Expand_Collabse_Button = By.xpath("//button[@class='oxd-icon-button oxd-main-menu-button']");
    private By Username_TextField = By.xpath("//input[@class='oxd-input oxd-input--active']");
    private By Search_Btn = By.xpath("//button[@type='submit'][contains(.,'Search')]");
    private By DeleteAction_Icon = By.xpath("//i[@class='oxd-icon bi-trash']");
    private By PopUpDelete_Btn = By.xpath("//button[@type='button'][contains(.,'Yes, Delete')]");
    private By AddUser_Btn = By.xpath("//button[@type='button'][contains(.,'Add')]");
    private By Reset_Btn = By.xpath("//button[@type='button'][contains(.,'Reset')]");

    // Constructor
    public UserManagementPage(WebDriver driver) {
        this.driver = driver;
        this.assertionUtils = new AssertionUtils();
        this.waitUtils = new WaitUtils(driver);
    }

    // Action Methods
    @Step("Click on 'Admin' menu tab")
    public void clickAdminMenu() {
        driver.findElement(Admin_MenuTab).click();
    }

    @Step("Get number of records displayed")
    public int getRecordNumber() {
        waitUtils.waitForVisibility(RecordNumber,10);
        String text = driver.findElement(RecordNumber).getText();
        return Integer.parseInt(text.replaceAll("[^0-9]", ""));
    }

    @Step("Assert record number is equal to {expected}")
    public void assertRecordNumberEquals(int expected) {
        int actual = getRecordNumber();
        assertionUtils.assertEqualsHard(String.valueOf(actual), String.valueOf(expected), "Record number did not match");
    }

    @Step("Click on 'Expand/Collapse' button")
    public void clickExpandCollapse() {
        driver.findElement(Expand_Collabse_Button).click();
    }

    @Step("Enter username in username field")
    public void enterUsername(String username) {
        driver.findElement(Username_TextField).clear();
        driver.findElement(Username_TextField).sendKeys(username);
    }

    @Step("Click on 'Search' button")
    public void clickSearch() {
        driver.findElement(Search_Btn).click();
    }

    @Step("Click on 'Add User' button")
    public void clickAdd() {
        driver.findElement(AddUser_Btn).click();
    }

    @Step("Click on 'Reset' button")
    public void clickReset() {
        driver.findElement(Reset_Btn).click();
    }

    @Step("Click on 'Delete' action icon")
    public void clickDeleteIcon() {
        waitUtils.waitForVisibility(DeleteAction_Icon,10);
        driver.findElement(DeleteAction_Icon).click();
    }


    @Step("Click on 'Delete' button in popup")
    public void clickPopupDelete() {
        waitUtils.waitForClickable(PopUpDelete_Btn,10);
        driver.findElement(PopUpDelete_Btn).click();
    }

}
