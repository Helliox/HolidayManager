package pl.intratel.HolidayManager.entities;


import javax.persistence.*;
import java.sql.Date;

@Entity(name="overtime")
@Table(name="overtime")
public class Overtime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_overtime;

    private Date date_start;
    private Date date_end;

    public long getId_employee() {
        return id_employee;
    }

    public void setId_employee(long id_employee) {
        this.id_employee = id_employee;
    }

    private long id_employee;

    public Overtime(){}


    public long getId_overtime() {
        return id_overtime;
    }

    public void setId_overtime(long id_overtime) {
        this.id_overtime = id_overtime;
    }

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }
}
