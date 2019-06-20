package farm.dairy.cow.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FarmCows implements Serializable {
    protected List<CowDto> cowList = new ArrayList<>();

    public FarmCows() {
    }

    public FarmCows(List<CowDto> cowList) {
        this.cowList = cowList;
    }

    public List<CowDto> getCowList() {
        return cowList;
    }

    public void setCowList(List<CowDto> cowList) {
        this.cowList = cowList;
    }
}
