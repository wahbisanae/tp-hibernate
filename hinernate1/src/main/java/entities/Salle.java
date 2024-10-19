package entities;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="salles")
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String code;

    // Relation avec Machine
    @OneToMany(mappedBy = "salle", fetch=FetchType.EAGER)
    private List<Machine> machines;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    public Salle(String code,List<Machine> machines) {
        this.code = code;
        this.machines=machines;
    }

    public Salle() {
    }
    public Salle(String code) {
        this.code = code;
    }
}