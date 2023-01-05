package sg.edu.nus.iss.app.validation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.app.validation.models.Person;

@Controller
@RequestMapping(path = "/register")
public class RegistrationController {

    @GetMapping
    public String getRegForm(Model model) {
        model.addAttribute("person", new Person());
        return "registration";
    }

    @PostMapping
    public String postRegistration(@Valid Person person, BindingResult binding, Model model) {
        if (binding.hasErrors()) {
            model.addAttribute("person", person);
            return "registration";
        }

        return "thankyou";
    }

}
