package farm.dairy.cow.service;

import farm.dairy.cow.dto.CowWithParentAndCalvesDto;
import farm.dairy.cow.dto.FarmCows;

public interface CowService {
    void addCalfToCow(CowWithParentAndCalvesDto cowDto) throws Exception;

    void setEndLifeToCowByCowId(CowWithParentAndCalvesDto cowDto) throws Exception;

    FarmCows getCowDtoBy();
}
