package farm.dairy.cow.validate;

import farm.dairy.cow.dto.CowWithParentAndCalvesDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CowValidateImpl implements CowValidate {
    public void validateAddCalfToCow(CowWithParentAndCalvesDto cowWithParentAndCalvesDto) throws Exception {
        checkObjectExisting(cowWithParentAndCalvesDto);
        checkParentCow(cowWithParentAndCalvesDto);
        checkCowNickName(cowWithParentAndCalvesDto);
    }

    public void validateSetEndLifeToCowByCow(CowWithParentAndCalvesDto cowWithParentAndCalvesDto) throws Exception {
        checkObjectExisting(cowWithParentAndCalvesDto);
        checkCowId(cowWithParentAndCalvesDto);
    }

    private void checkParentCow(CowWithParentAndCalvesDto cowWithParentAndCalvesDto) throws Exception {
        if (Objects.isNull(cowWithParentAndCalvesDto.getParentCow())
                || Objects.isNull(cowWithParentAndCalvesDto.getParentCow().getCowId()))
            throw new Exception("Parent not specified");
    }

    private void checkCowNickName(CowWithParentAndCalvesDto cowWithParentAndCalvesDto) throws Exception {
        if (StringUtils.isEmpty(cowWithParentAndCalvesDto.getNickName()))
            throw new Exception("NickName not specified");
    }

    private void checkCowId(CowWithParentAndCalvesDto cowWithParentAndCalvesDto) throws Exception {
        checkObjectExisting(cowWithParentAndCalvesDto.getCowId());
    }

    private void checkObjectExisting(Object object) throws Exception {
        if (Objects.isNull(object))
            throw new Exception("CowWithParentAndCalvesDto is null");
    }
}
