package pl.intratel.HolidayManager.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name="role")
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_role;

    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<Employee> employees = new HashSet<>();

    public Role(){}

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
