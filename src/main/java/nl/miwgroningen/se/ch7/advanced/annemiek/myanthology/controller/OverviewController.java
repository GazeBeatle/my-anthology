package nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.controller;

import nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Annemiek Blaauwgeers <a.blaauwgeers@st.hanze.nl>
 * <p>
 * Functionality for showing an overview of the anthology after signing in.
 */

@Controller
public class OverviewController {

    private BookRepository bookRepository;

    public OverviewController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/overview")
    protected String showAnthologyOverview(Model model) {
        model.addAttribute("allReadBooks", bookRepository.findByisRead(true));
        model.addAttribute("allUnreadBooks", bookRepository.findByisRead(false));
        return "anthologyOverview";
    }
}
