package farm.dairy.cow.dto;

import farm.dairy.cow.model.Cow;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class CowWithParentAndCalvesDto extends CowDto implements Serializable {
    @Getter
    @Setter
    private CowDto parentCow;
    @Getter
    @Setter
    private Set<CowDto> calvesCow;

    public CowWithParentAndCalvesDto() {
    }

    public CowWithParentAndCalvesDto(Cow cow) {
        this.cowId = cow.getCowId();
        this.nickName = cow.getNickName();
        if (Objects.nonNull(cow.getParentCow()))
            this.parentCow = new CowDto(cow.getParentCow());
        this.calvesCow = cow.getCalvesCow().stream()
                .map(CowDto::new)
                .collect(Collectors.toSet());
        this.dateBirth = cow.getDateBirth();
        this.dateDeath = cow.getDateDeath();
    }
}
