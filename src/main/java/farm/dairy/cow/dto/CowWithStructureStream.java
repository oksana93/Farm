package farm.dairy.cow.dto;

import farm.dairy.cow.model.CowStream;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

public class CowWithStructureStream extends CowDto implements Serializable {
    private CowDto parentCow;
    private Stream<CowDto> calvesCow = Stream.<CowDto>builder().build();

    public CowWithStructureStream() {
    }

    public CowWithStructureStream(CowStream cow) {
        this.cowId = cow.getCowId();
        this.nickName = cow.getNickName();
        if (Objects.nonNull(cow.getParentCow()))
            this.parentCow = new CowDto(cow.getParentCow());
        this.dateBirth = cow.getDateBirth();
        this.dateDeath = cow.getDateDeath();
    }

    public CowDto getParentCow() {
        return parentCow;
    }

    public void setParentCow(CowDto parentCow) {
        this.parentCow = parentCow;
    }

    public Stream<CowDto> getCalvesCow() {
        return calvesCow;
    }

    public void setCalvesCow(Stream<CowDto> calvesCow) {
        this.calvesCow = calvesCow;
    }

    public void addCalvesCow(CowDto calfCow) {
        Stream.concat(
                calvesCow,
                Stream.of(calfCow));
    }

}
