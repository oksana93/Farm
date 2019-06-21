package farm.dairy.cow.dto;

import java.io.Serializable;
import java.util.stream.Stream;

public class FarmCowsStream implements Serializable {
    protected Stream<CowWithStructureStream> cowList;

    public FarmCowsStream() {
    }

    public FarmCowsStream(Stream<CowWithStructureStream> cowList) {
        this.cowList = cowList;
    }

    public Stream<CowWithStructureStream> getCowList() {
        return cowList;
    }

    public void setCowList(Stream<CowWithStructureStream> cowList) {
        this.cowList = cowList;
    }
}
