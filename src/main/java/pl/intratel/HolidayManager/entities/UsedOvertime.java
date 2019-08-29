package pl.intratel.HolidayManager.entities;


import javax.persistence.*;
import java.sql.Date;

@Entity(name="used_overtime")
@Table(name="used_overtime")
public class UsedOvertime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date date_start;
    private Date date_end;
    private short acceptation;

    public short getAcceptation() {
        return acceptation;
    }

    public void setAcceptation(short acceptation) {
        this.acceptation = acceptation;
    }

    public long getId_employee() {
        return id_employee;
    }

    public void setId_employee(long id_employee) {
        this.id_employee = id_employee;
    }

    private long id_employee;

    public UsedOvertime(){}


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
