package vn.edu.tan.sb_truyendulieutuviewsangcontroller.controllers;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
    @GetMapping("/submit")
    public String handleForm(@RequestParam String name, Model model) {
        System.out.println("Received name: " + name);
        model.addAttribute("name", name);
        return "index";
    }

}
