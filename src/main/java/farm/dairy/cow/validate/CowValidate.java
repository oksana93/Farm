package farm.dairy.cow.validate;

import farm.dairy.cow.dto.CowDto;

public interface CowValidate {
    void validateAddCalfToCow(CowDto cowDto) throws Exception;

    void validateSetEndLifeToCowByCow(CowDto cowDto) throws Exception;
}
