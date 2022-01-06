package nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Annemiek Blaauwgeers <a.blaauwgeers@st.hanze.nl>
 * <p>
 * This is the controller for the homepage.
 */

@Controller
public class HomepageController {

    @GetMapping({"/", "/home"})
    protected String showHomepage() {
        return "homepage";
    }
}
