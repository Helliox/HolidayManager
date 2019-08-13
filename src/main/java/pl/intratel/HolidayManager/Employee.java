package pl.intratel.HolidayManager;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",updatable=false,nullable=false)
    private long id;

    private String name;
    private String surname;
    private String email;
    private boolean manager;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_expertise",joinColumns = @JoinColumn(name="employee_id",referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "expertise_id", referencedColumnName = "id"))
    private Set<Expertise> expertises;

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
