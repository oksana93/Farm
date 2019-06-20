package farm.dairy.cow.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table
public class Cow {
    private UUID cowId;
    private String nickName;
    private Cow parentCow;
    private Set<Cow> calvesCow = new HashSet<>();
    private LocalDateTime dateBirth;
    private LocalDateTime dateDeath;

    public Cow() {
    }

    public Cow(String nickName, Cow parentCow) {
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
    public Cow getParentCow() {
        return parentCow;
    }

    public void setParentCow(Cow parentCow) {
        this.parentCow = parentCow;
    }

    @OneToMany(mappedBy = "parentCow")
    public Set<Cow> getCalvesCow() {
        return calvesCow;
    }

    public void setCalvesCow(Set<Cow> calvesCow) {
        this.calvesCow = calvesCow;
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
