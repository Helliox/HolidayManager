package pl.intratel.HolidayManager;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name="expertise")
@Table(name="expertise")
public class Expertise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_expertise;

    private String expertise_type;

    @ManyToMany(mappedBy = "expertises")
    private Set<Employee> employees = new HashSet<>();

    public Expertise(){}

    public int getId_expertise() {
        return id_expertise;
    }

    public void setId_expertise(int id_expertise) {
        this.id_expertise = id_expertise;
    }

    public String getExpertise_type() {
        return expertise_type;
    }

    public void setExpertise_type(String expertise_type) {
        this.expertise_type = expertise_type;
    }

}
