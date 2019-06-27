package farm.dairy.cow.service;

import farm.dairy.cow.dto.CowDto;

public interface CowEntryService {
    void addCalfToCow(String calfNickName, CowDto parentCow) throws Exception;

    void addCalfToCow(CowDto calf, CowDto parentCow) throws Exception;

    void setEndLifeToCowByCowId(CowDto cowDto) throws Exception;

    void printAllCow();
}
