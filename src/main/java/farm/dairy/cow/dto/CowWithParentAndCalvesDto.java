package farm.dairy.cow.dto;

import farm.dairy.cow.model.Cow;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class CowWithParentAndCalvesDto implements Serializable {
    private UUID cowId;
    private String nickName;
    private CowDto parentCow;
    private Set<CowDto> calvesCow;
    private LocalDateTime dateBirth;
    private LocalDateTime dateDeath;

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

    public UUID getCowId() {
        return cowId;
    }

    public void setCowId(UUID cowId) {
        this.cowId = cowId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public CowDto getParentCow() {
        return parentCow;
    }

    public void setParentCow(CowDto parentCow) {
        this.parentCow = parentCow;
    }

    public Set<CowDto> getCalvesCow() {
        return calvesCow;
    }

    public void setCalvesCow(Set<CowDto> calvesCow) {
        this.calvesCow = calvesCow;
    }

    public LocalDateTime getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDateTime dateBirth) {
        this.dateBirth = dateBirth;
    }

    public LocalDateTime getDateDeath() {
        return dateDeath;
    }

    public void setDateDeath(LocalDateTime dateDeath) {
        this.dateDeath = dateDeath;
    }
}
