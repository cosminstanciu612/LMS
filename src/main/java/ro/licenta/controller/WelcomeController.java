package ro.licenta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Cosmin on 25-Mar-17.
 */
@Controller
public class WelcomeController {

    @GetMapping(value = "/welcome")
    public String welcome() {
        return "welcome";
    }

}
