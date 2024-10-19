package entities;
import javax.persistence.*;
import java.util.Date;

@Entity
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "findBetweenDateNative",
                query = "SELECT * FROM machine WHERE dateAchat BETWEEN :d1 AND :d2",
                resultClass = Machine.class
        )
})
@NamedQuery(name="findBetweenDate", query = "from Machine where dateAchat between :d1 and :d2")
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ref;

    @Temporal(TemporalType.DATE)
    private Date dateAchat;

    // Relation avec la classe Salle
    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Machine() {
    }

    public Machine(String ref, Date dateAchat, Salle salle) {
        this.ref = ref;
        this.dateAchat=dateAchat;
        this.salle=salle;
    }
}