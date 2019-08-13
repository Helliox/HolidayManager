package pl.intratel.HolidayManager;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Expertise {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id",updatable=false,nullable=false)
    private long id;

    private String expertiseType;

    @ManyToMany(mappedBy = "employee")
    private Set<Employee> employees = new HashSet<>();

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
