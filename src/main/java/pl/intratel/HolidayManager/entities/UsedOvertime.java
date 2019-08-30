package pl.intratel.HolidayManager.entities;


import javax.persistence.*;

@Entity(name="used_overtime")
@Table(name="used_overtime")
public class UsedOvertime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_usedovertime;

    private String date_day;
    private String date_start;
    private String date_end;
    private short acceptation;
    private long id_employee;

    public UsedOvertime(){}

    public long getId_usedovertime() {
        return id_usedovertime;
    }

    public void setId_usedovertime(long id_usedovertime) {
        this.id_usedovertime = id_usedovertime;
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
}
