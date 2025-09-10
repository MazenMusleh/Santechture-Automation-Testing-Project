package API.pojo_models.AddAttachment;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;

public class AddAttachments_Payload_AttachmentData {
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("size")
    private int size;
    @JsonProperty("base64")
    private String base64;

    public AddAttachments_Payload_AttachmentData() {
    }

    public AddAttachments_Payload_AttachmentData(String name, String type, int size, String base64) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.base64 = base64;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }
}
