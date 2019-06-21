package farm.dairy.cow.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FarmCows implements Serializable {
    protected List<CowWithStructure> cowList = new ArrayList<>();

    public FarmCows() {
    }

    public FarmCows(List<CowWithStructure> cowList) {
        this.cowList = cowList;
    }

    public List<CowWithStructure> getCowList() {
        return cowList;
    }

    public void setCowList(List<CowWithStructure> cowList) {
        this.cowList = cowList;
    }
}
