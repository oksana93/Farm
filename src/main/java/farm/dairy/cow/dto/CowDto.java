package farm.dairy.cow.dto;

import farm.dairy.cow.model.Cow;

import java.time.LocalDateTime;
import java.util.UUID;

public class CowDto {
    private UUID cowId;
    private String nickName;
    private LocalDateTime dateBirth;
    private LocalDateTime dateDeath;

    public CowDto() {
    }

    public CowDto(Cow cow) {
        this.cowId = cow.getCowId();
        this.nickName = cow.getNickName();
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
