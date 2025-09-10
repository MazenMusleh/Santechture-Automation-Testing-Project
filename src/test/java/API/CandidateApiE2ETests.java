package API;

import API.pojo_models.AddAttachment.AddAttachments_Payload_AttachmentData;
import API.pojo_models.AddCandidate.AddCandidate_Payload;
import API.pojo_models.AddCandidate.AddCandidate_ResponceRoot;
import API.pojo_models.AddAttachment.AddAttachments_PayloadRoot;
import API.pojo_models.DeleteCandidate.DeleteCandidate_Payload;
import API.specifications.RequestSpec;
import GUI.Base.DriverManager;
import Utilization.Base64Utils;
import Utilization.ConfigManager;
import Utilization.FakerUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Feature("User Management Tests")
@Story("Verify add and delete candidates through API")
public class CandidateApiE2ETests {

    private WebDriver driver;
    private int candidateId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String contactNumber;
    private String keywords;
    private String comment;
    private String dateOfApplication;
    private boolean consentToKeepData;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
        ConfigManager.init("src/test/resources/configs.properties");
        firstName = FakerUtils.getRandomFirstName();
        middleName = FakerUtils.getRandomMiddleName();
        lastName = FakerUtils.getRandomLastName();
        email = FakerUtils.getRandomEmail();
        contactNumber = FakerUtils.getRandomPhoneNumber();
        keywords = FakerUtils.getRandomSentence();
        comment = FakerUtils.getRandomParagraph();
        dateOfApplication = FakerUtils.getRandomPastDate();
        consentToKeepData = true;
    }


    @Test(priority = 1, description = "Add Candidate through API")
    public void addCandidate() {
        AddCandidate_Payload payload
                = new AddCandidate_Payload(firstName,middleName,lastName,email,contactNumber,
                keywords,comment,dateOfApplication,consentToKeepData);

        Response response = given()
                .spec(RequestSpec.requestSpec)
                .header("Cookie", "orangehrm=" + ConfigManager.getInstance().getProperty("Cookie"))
                .body(payload)
                .when()
                .post(ConfigManager.getInstance().getProperty("Add_Delete_Candidate_Enpoint"))
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();

        AddCandidate_ResponceRoot candidateResponse = response.as(AddCandidate_ResponceRoot.class);
        candidateId = candidateResponse.getData().getId();
    }

    @Test(priority = 2, dependsOnMethods = "addCandidate", description = "Add Attachment for the Added Candidate through API")
    public void addAttachment() throws IOException {
        String Base64String = Base64Utils.fileToBase64("src/test/resources/testData/CommitmentForm.pdf");
        long filesize = Base64Utils.getFileSizeFromBase64(Base64String);

        AddAttachments_Payload_AttachmentData AttachmentData
                = new AddAttachments_Payload_AttachmentData("CommitmentForm.pdf", "application/pdf", (int)filesize, Base64String);

        AddAttachments_PayloadRoot payload = new AddAttachments_PayloadRoot(candidateId,AttachmentData);

        Response response = given()
                .spec(RequestSpec.requestSpec)
                .header("Cookie", "orangehrm=" + ConfigManager.getInstance().getProperty("Cookie"))
                .body(payload)
                .when()
                .post(ConfigManager.getInstance().getProperty("Attachments_Endpoint"))
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();
}

    @Test(priority = 3, dependsOnMethods = "addAttachment", description = "Delete Candidate through API")
    public void deleteCandidate() {
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(candidateId);
        DeleteCandidate_Payload payload = new DeleteCandidate_Payload(ids);

        Response response = given()
                .spec(RequestSpec.requestSpec)
                .header("Cookie", "orangehrm=" + ConfigManager.getInstance().getProperty("Cookie"))
                .body(payload)
                .when()
                .delete(ConfigManager.getInstance().getProperty("Add_Delete_Candidate_Enpoint"))
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
