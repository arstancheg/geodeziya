package organizaciitelefony.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import organizaciitelefony.model.Rekvizity;

@Controller
public class Ishdannye {
    @RequestMapping(value = "ishdannye", method = RequestMethod.GET)
    public String ishdannye(Model model) {
        // model.addAttribute("rekvizity", new Rekvizity());
        return "ishdannye";
    }
}
