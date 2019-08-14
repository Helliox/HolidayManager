package pl.intratel.HolidayManager;


import javax.persistence.*;
import java.sql.Date;

@Entity(name="overtime")
@Table(name="overtime")
public class Overtime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date date_start;
    private Date date_end;

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    private long employee_id;

    public Overtime(){}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
