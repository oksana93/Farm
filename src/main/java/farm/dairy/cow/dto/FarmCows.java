package farm.dairy.cow.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FarmCows implements Serializable {
    protected List<CowWithParentAndCalvesDto> cowList = new ArrayList<>();

    public FarmCows() {
    }

    public FarmCows(List<CowWithParentAndCalvesDto> cowList) {
        this.cowList = cowList;
    }

    public List<CowWithParentAndCalvesDto> getCowList() {
        return cowList;
    }

    public void setCowList(List<CowWithParentAndCalvesDto> cowList) {
        this.cowList = cowList;
    }
}
