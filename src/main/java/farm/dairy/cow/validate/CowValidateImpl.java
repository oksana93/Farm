package farm.dairy.cow.validate;

import farm.dairy.cow.dto.CowDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CowValidateImpl implements CowValidate {
    public void validateAddCalfToCow(CowDto cowDto) throws Exception {
        checkObjectExisting(cowDto);
        checkParentCow(cowDto);
        checkCowNickName(cowDto);
    }

    public void validateSetEndLifeToCowByCow(CowDto cowDto) throws Exception {
        checkObjectExisting(cowDto);
        checkCowId(cowDto);
    }

    private void checkParentCow(CowDto cowDto) throws Exception {
        if (Objects.isNull(cowDto.getParentCow())
                || Objects.isNull(cowDto.getParentCow().getCowId()))
            throw new Exception("Parent not specified");
    }

    private void checkCowNickName(CowDto cowDto) throws Exception {
        if (StringUtils.isEmpty(cowDto.getNickName()))
            throw new Exception("NickName not specified");
    }

    private void checkCowId(CowDto cowDto) throws Exception {
        checkObjectExisting(cowDto.getCowId());
    }

    private void checkObjectExisting(Object object) throws Exception {
        if (Objects.isNull(object))
            throw new Exception("CowDto is null");
    }
}
