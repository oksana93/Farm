package farm.dairy.cow.service;

import farm.dairy.cow.dto.CowWithParentAndCalvesDto;
import farm.dairy.cow.dto.FarmCows;

public interface CowService {
    void addCalfToCow(CowWithParentAndCalvesDto cowWithParentAndCalvesDto) throws Exception;

    void setEndLifeToCowByCowId(CowWithParentAndCalvesDto cowWithParentAndCalvesDto) throws Exception;

    FarmCows getCowDtoBy();
}
