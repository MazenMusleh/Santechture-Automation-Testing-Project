package API.pojo_models.AddCandidate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class AddCandidate_ResponceRoot {
    @JsonProperty("data")
    public AddCandidate_ResponceData data;
    @JsonIgnore
    public ArrayList<Object> meta;
    @JsonIgnore
    public ArrayList<Object> rels;

    public AddCandidate_ResponceRoot() {
    }

    public AddCandidate_ResponceRoot(AddCandidate_ResponceData data, ArrayList<Object> meta, ArrayList<Object> rels) {
        this.data = data;
    }

    public AddCandidate_ResponceData getData() {
        return data;
    }

    public void setData(AddCandidate_ResponceData data) {
        this.data = data;
    }
}
