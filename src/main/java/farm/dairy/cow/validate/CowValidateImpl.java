package farm.dairy.cow.validate;

import farm.dairy.cow.dto.CowWithStructureStream;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CowValidateImpl implements CowValidate {
    public void validateAddCalfToCow(CowWithStructureStream cowWithStructureStream) throws Exception {
        checkObjectExisting(cowWithStructureStream);
        checkParentCow(cowWithStructureStream);
        checkCowNickName(cowWithStructureStream);
    }

    public void validateSetEndLifeToCowByCow(CowWithStructureStream cowWithStructureStream) throws Exception {
        checkObjectExisting(cowWithStructureStream);
        checkCowId(cowWithStructureStream);
    }

    private void checkParentCow(CowWithStructureStream cowWithStructureStream) throws Exception {
        if (Objects.isNull(cowWithStructureStream.getParentCow()) || Objects.isNull(cowWithStructureStream.getParentCow().getCowId()))
            throw new Exception("Parent not specified");
    }

    private void checkCowNickName(CowWithStructureStream cowWithStructureStream) throws Exception {
        if (StringUtils.isEmpty(cowWithStructureStream.getNickName()))
            throw new Exception("NickName not specified");
    }

    private void checkCowId(CowWithStructureStream cowWithStructureStream) throws Exception {
        checkObjectExisting(cowWithStructureStream.getCowId());
    }

    private void checkObjectExisting(Object object) throws Exception {
        if (Objects.isNull(object))
            throw new Exception("CowWithStructureStream is null");
    }
}
