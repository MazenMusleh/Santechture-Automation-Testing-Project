package API.pojo_models.AddAttachment;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;

public class AddAttachments_PayloadRoot {
    @JsonProperty("candidateId")
    private int candidateId;
    @JsonProperty("attachment")
    private AddAttachments_Payload_AttachmentData attachment;

    public AddAttachments_PayloadRoot() {
    }

    public AddAttachments_PayloadRoot(int candidateId, AddAttachments_Payload_AttachmentData attachment) {
        this.candidateId = candidateId;
        this.attachment = attachment;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public AddAttachments_Payload_AttachmentData getAttachment() {
        return attachment;
    }

    public void setAttachment(AddAttachments_Payload_AttachmentData attachment) {
        this.attachment = attachment;
    }
}
