package nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.controller;

import nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.repository.BookRepository;
import nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.repository.WishlistRepository;
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
    private WishlistRepository wishlistRepository;

    public OverviewController(BookRepository bookRepository, WishlistRepository wishlistRepository) {
        this.bookRepository = bookRepository;
        this.wishlistRepository = wishlistRepository;
    }

    @GetMapping("/overview")
    protected String showAnthologyOverview(Model model) {
        model.addAttribute("allBooks", bookRepository.findAll());
        model.addAttribute("allWishlists", wishlistRepository.findAll());
        return "anthologyOverview";
    }
}