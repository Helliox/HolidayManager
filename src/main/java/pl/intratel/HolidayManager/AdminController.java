package pl.intratel.HolidayManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @GetMapping("/adminView")
    public String adminView(){
        return "administration";
    }

}
