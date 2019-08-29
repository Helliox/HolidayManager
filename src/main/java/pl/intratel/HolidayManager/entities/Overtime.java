package pl.intratel.HolidayManager.entities;


import javax.persistence.*;
import java.sql.Date;

@Entity(name="overtime")
@Table(name="overtime")
public class Overtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_overtime;

    private String date_day;
    private String date_start;
    private String date_end;

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

    public String getDate_day() {
        return date_day;
    }

    public void setDate_day(String date_day) {
        this.date_day = date_day;
    }

    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }

    public String getDate_end() {
        return date_end;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }
}
