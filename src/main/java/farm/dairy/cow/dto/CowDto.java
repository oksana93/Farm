package farm.dairy.cow.dto;

import farm.dairy.cow.model.Cow;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class CowDto {
    @Getter
    @Setter
    protected UUID cowId;
    @Getter
    @Setter
    protected String nickName;
    @Getter
    @Setter
    protected LocalDateTime dateBirth;
    @Getter
    @Setter
    protected LocalDateTime dateDeath;

    public CowDto() {
    }

    public CowDto(String nickName) {
        this.cowId = UUID.randomUUID();
        this.nickName = nickName;
        this.dateBirth = LocalDateTime.now();
    }

    public CowDto(UUID cowId, String nickName) {
        this.cowId = cowId;
        this.nickName = nickName;
        this.dateBirth = LocalDateTime.now();
    }

    public CowDto(Cow cow) {
        this.cowId = cow.getCowId();
        this.nickName = cow.getNickName();
        this.dateBirth = cow.getDateBirth();
        this.dateDeath = cow.getDateDeath();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CowDto cowDto = (CowDto) obj;
        return cowId.equals(cowDto.cowId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cowId);
    }

    @Override
    public String toString() {
        return "CowDto {" +
                "cowId=" + cowId +
                ", nickName='" + nickName + '\'' +
                ", dateBirth=" + dateBirth +
                ", dateDeath=" + dateDeath +
                '}';
    }
}
