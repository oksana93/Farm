package farm.dairy.cow.validate;

import farm.dairy.cow.dto.CowWithStructureStream;

public interface CowValidate {
    void validateAddCalfToCow(CowWithStructureStream cowWithStructureStream) throws Exception;

    void validateSetEndLifeToCowByCow(CowWithStructureStream cowWithStructureStream) throws Exception;
}
