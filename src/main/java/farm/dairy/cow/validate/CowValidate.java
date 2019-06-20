package farm.dairy.cow.validate;

import farm.dairy.cow.dto.CowWithParentAndCalvesDto;

public interface CowValidate {
    void validateAddCalfToCow(CowWithParentAndCalvesDto cowWithParentAndCalvesDto) throws Exception;

    void validateSetEndLifeToCowByCow(CowWithParentAndCalvesDto cowWithParentAndCalvesDto) throws Exception;
}
