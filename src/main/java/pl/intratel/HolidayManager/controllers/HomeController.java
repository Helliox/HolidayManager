package pl.intratel.HolidayManager.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.intratel.HolidayManager.authentication.MyUserPrincipal;

import java.util.Map;

@Controller
public class HomeController {

    @RequestMapping(value={"/home","/"}, method = RequestMethod.GET)
    public String homeView(Model model) {
        Object pr = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long id = ((MyUserPrincipal)pr).getId();
        String str = String.valueOf(id);
        model.addAttribute("msg",str);
        return "home.html";
    }
}
