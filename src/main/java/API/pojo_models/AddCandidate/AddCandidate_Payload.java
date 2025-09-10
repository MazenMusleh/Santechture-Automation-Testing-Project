package API.pojo_models.AddCandidate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddCandidate_Payload {

    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("middleName")
    private String middleName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("contactNumber")
    private String contactNumber;
    @JsonProperty("keywords")
    private String keywords;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("dateOfApplication")
    private String dateOfApplication;
    @JsonProperty("consentToKeepData")
    private boolean consentToKeepData;

    public AddCandidate_Payload() {
    }

    public AddCandidate_Payload(String firstName, String middleName, String lastName, String email, String contactNumber, String keywords, String comment, String dateOfApplication, boolean consentToKeepData) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.contactNumber = contactNumber;
        this.keywords = keywords;
        this.comment = comment;
        this.dateOfApplication = dateOfApplication;
        this.consentToKeepData = consentToKeepData;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDateOfApplication() {
        return dateOfApplication;
    }

    public void setDateOfApplication(String dateOfApplication) {
        this.dateOfApplication = dateOfApplication;
    }

    public boolean isConsentToKeepData() {
        return consentToKeepData;
    }

    public void setConsentToKeepData(boolean consentToKeepData) {
        this.consentToKeepData = consentToKeepData;
    }
}
