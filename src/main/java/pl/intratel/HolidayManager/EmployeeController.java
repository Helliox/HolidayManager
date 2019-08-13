package pl.intratel.HolidayManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @GetMapping("/employeesView")
    public String employeesView(){
        return "employees";
    }

}
