package farm.dairy.cow.dto;

import farm.dairy.cow.model.Cow;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class CowDto implements Serializable {
    private UUID cowId;
    private String nickName;
    private Cow parentCow;
    private Set<Cow> calvesCow;
    private LocalDateTime dateBirth;
    private LocalDateTime dateDeath;

    public CowDto() {
    }

    public CowDto(Cow cow) {
        this.cowId = cow.getCowId();
        this.nickName = cow.getNickName();
        this.parentCow = cow.getParentCow();
        this.calvesCow = cow.getCalvesCow();
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

    public Cow getParentCow() {
        return parentCow;
    }

    public void setParentCow(Cow parentCow) {
        this.parentCow = parentCow;
    }

    public Set<Cow> getCalvesCow() {
        return calvesCow;
    }

    public void setCalvesCow(Set<Cow> calvesCow) {
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
