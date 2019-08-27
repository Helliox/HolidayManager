package pl.intratel.HolidayManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import pl.intratel.HolidayManager.entities.Employee;

import javax.validation.Valid;

@Controller
public class AdminController {


    @RequestMapping(value={"/adminView"}, method = RequestMethod.GET)
    public String adminView()
    {
        return "administration";
    }


    @GetMapping("/adminView/expertise")
    public String adminViewExpertise() { return "administrationExpertise";}


}
