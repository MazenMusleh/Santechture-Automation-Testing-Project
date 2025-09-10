package GUI;

import GUI.Base.DriverManager;
import GUI.pages.AddUserPage;
import GUI.pages.LoginPage;
import GUI.pages.UserManagementPage;
import Utilization.ConfigManager;
import Utilization.CookiesUtils;
import Utilization.FakerUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.Duration;

@Feature("User Management Tests")
public class UserManagementTest {

    private WebDriver driver;
    private UserManagementPage userManagementPage;
    private AddUserPage addUserPage;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
        userManagementPage = new UserManagementPage(driver);
        addUserPage = new AddUserPage(driver);
        ConfigManager.init("src/test/resources/configs.properties");
    }

    @Test(description = "Add and Delete a User")
    @Story("Verify add and delete user functionality in Admin panel")
    @Description("1. Login → 2. Navigate to Admin tab → 3. Add user → 4. Verify records increased → 5. Delete user → 6. Verify records decreased")
    public void testAddAndDeleteUser() throws InterruptedException {

        loginPage.login("Admin", "admin123");
        String SessionCookie = CookiesUtils.getSessionCookie("orangehrm");
        ConfigManager.getInstance().setProperty("Cookie", SessionCookie);

        userManagementPage.clickAdminMenu();
        userManagementPage.clickExpandCollapse();
        int beforeCount = userManagementPage.getRecordNumber();
        userManagementPage.clickAdd();

        userManagementPage.clickExpandCollapse();

        addUserPage.selectUserRoleAdmin();
        addUserPage.enterEmployeeName("a");
        Thread.sleep(Duration.ofSeconds(3));
        addUserPage.selectEmployeeOption();
        String username = FakerUtils.getRandomUsername();
        addUserPage.enterUsername(username);
        addUserPage.selectStatusEnabled();
        String password = FakerUtils.getRandomPassword();
        addUserPage.enterPassword(password);
        addUserPage.enterConfirmPassword(password);
        addUserPage.clickSave();

        userManagementPage.assertRecordNumberEquals(beforeCount+1);

        userManagementPage.clickExpandCollapse();

        userManagementPage.enterUsername(username);
        userManagementPage.clickSearch();
        userManagementPage.clickDeleteIcon();
        userManagementPage.clickPopupDelete();
        userManagementPage.clickReset();


        userManagementPage.assertRecordNumberEquals(beforeCount);
    }

}
