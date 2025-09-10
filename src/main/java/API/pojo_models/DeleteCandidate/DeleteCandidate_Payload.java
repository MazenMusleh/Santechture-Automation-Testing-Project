package API.pojo_models.DeleteCandidate;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class DeleteCandidate_Payload {

    public DeleteCandidate_Payload(ArrayList<Integer> ids) {
        this.ids = ids;
    }

    public DeleteCandidate_Payload() {
    }

    @JsonProperty("ids")
    private ArrayList<Integer> ids;

    public ArrayList<Integer> getIds() {
        return ids;
    }

    public void setIds(ArrayList<Integer> ids) {
        this.ids = ids;
    }
}
