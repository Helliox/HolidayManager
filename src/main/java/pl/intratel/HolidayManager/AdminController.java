package pl.intratel.HolidayManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/adminView")
    public String adminView(){
        return "administration";
    }

    @GetMapping("/adminView/expertise")
    public String adminViewExpertise() { return "administrationExpertise";}

}
