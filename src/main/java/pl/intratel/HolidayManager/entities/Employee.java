package pl.intratel.HolidayManager.entities;


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
    private String password;
    private short active;

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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "employee_role",joinColumns = @JoinColumn(name="id_employee"), inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Set<Role> roles;

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

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Expertise> getExpertises() {
        return expertises;
    }

    public void setExpertises(Set<Expertise> expertises) {
        this.expertises = expertises;
    }

    public Set<Overtime> getOvertime() {
        return overtime;
    }

    public void setOvertime(Set<Overtime> overtime) {
        this.overtime = overtime;
    }

    public Set<UsedOvertime> getUsedOvertime() {
        return usedOvertime;
    }

    public void setUsedOvertime(Set<UsedOvertime> usedOvertime) {
        this.usedOvertime = usedOvertime;
    }

    public Set<Holiday> getHoliday() {
        return holiday;
    }

    public void setHoliday(Set<Holiday> holiday) {
        this.holiday = holiday;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
