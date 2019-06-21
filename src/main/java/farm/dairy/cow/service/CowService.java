package farm.dairy.cow.service;

import farm.dairy.cow.dto.CowWithStructureStream;
import farm.dairy.cow.dto.FarmCows;
import farm.dairy.cow.dto.FarmCowsStream;

public interface CowService {
    void addCalfToCow(CowWithStructureStream cowDto) throws Exception;

    void setEndLifeToCowByCowId(CowWithStructureStream cowDto) throws Exception;

    FarmCows getCows();

    FarmCowsStream getStreamCows();
}
