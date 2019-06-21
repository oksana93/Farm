package farm.dairy.cow.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "cow")
public class CowStream {
    private UUID cowId;
    private String nickName;
    private CowStream parentCow;
    private LocalDateTime dateBirth;
    private LocalDateTime dateDeath;

    public CowStream() {
    }

    public CowStream(String nickName, CowStream parentCow) {
        this.nickName = nickName;
        this.parentCow = parentCow;
        this.dateBirth = LocalDateTime.now();
    }

    @Id
    @GeneratedValue
    @Column
    public UUID getCowId() {
        return cowId;
    }

    public void setCowId(UUID cowId) {
        this.cowId = cowId;
    }

    @Column
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @ManyToOne
    @JoinColumn(name = "parent_id")
    public CowStream getParentCow() {
        return parentCow;
    }

    public void setParentCow(CowStream parentCow) {
        this.parentCow = parentCow;
    }

    @Column
    public LocalDateTime getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDateTime dateBirth) {
        this.dateBirth = dateBirth;
    }

    @Column
    public LocalDateTime getDateDeath() {
        return dateDeath;
    }

    public void setDateDeath(LocalDateTime dateDeath) {
        this.dateDeath = dateDeath;
    }
}
