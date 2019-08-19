package pl.intratel.HolidayManager;

import javax.persistence.*;
import java.util.Set;

@Entity(name="employee")
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_employee;

    private String name;
    private String surname;
    private String email;
    private short manager_status;

    public Employee(){}


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "employee_expertise",joinColumns = @JoinColumn(name="id_employee"), inverseJoinColumns = @JoinColumn(name = "id_expertise"))
    private Set<Expertise> expertises;

    @OneToMany(mappedBy = "id_employee")
    private Set<Overtime> overtime;

    @OneToMany(mappedBy = "id_employee")
    private Set<UsedOvertime> usedOvertime;

    @OneToMany(mappedBy = "id_employee")
    private Set<Holiday> holiday;

    public long getId_employee() {
        return id_employee;
    }

    public void setId_employee(long id_employee) {
        this.id_employee = id_employee;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public short getManager_status() {
        return manager_status;
    }

    public void setManager_status(short manager_status) {
        this.manager_status = manager_status;
    }
}
