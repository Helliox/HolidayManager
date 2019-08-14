package pl.intratel.HolidayManager;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name="expertise")
@Table(name="expertise")
public class Expertise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String expertiseType;

    @ManyToMany(mappedBy = "expertises")
    private Set<Employee> employees = new HashSet<>();

    public Expertise(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExpertiseType() {
        return expertiseType;
    }

    public void setExpertiseType(String expertiseType) {
        this.expertiseType = expertiseType;
    }

}
