package farm.dairy.cow.service;

import farm.dairy.cow.dto.CowDto;
import farm.dairy.cow.dto.FarmCows;

public interface CowService {
    void addCalfToCow(CowDto cowDto) throws Exception;

    void setEndLifeToCowByCowId(CowDto cowDto) throws Exception;

    FarmCows getCowDtoBy();
}
