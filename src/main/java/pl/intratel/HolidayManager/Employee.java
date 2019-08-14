package pl.intratel.HolidayManager;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Set;

@Entity(name="employee")
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String surname;
    private String email;
    private short manager_status;

    public Employee(){}


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "employee_expertise",joinColumns = @JoinColumn(name="employee_id",referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "expertise_id", referencedColumnName = "id"))
    private Set<Expertise> expertises;

    @OneToMany(mappedBy = "employee")
    private Set<Overtime> overtime;

    @OneToMany(mappedBy = "employee")
    private Set<UsedOvertime> usedOvertime;

    @OneToMany(mappedBy = "employee")
    private Set<Holiday> holiday;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
