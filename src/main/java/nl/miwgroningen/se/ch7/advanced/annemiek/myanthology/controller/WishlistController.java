package nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.controller;

import nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.model.Wishlist;
import nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.repository.BookRepository;
import nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.repository.WishlistRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

/**
 * @author Annemiek Blaauwgeers <a.blaauwgeers@st.hanze.nl>
 * <p>
 * All interactions with a wishlist.
 */

@Controller
public class WishlistController {

    private BookRepository bookRepository;
    private WishlistRepository wishlistRepository;

    public WishlistController(BookRepository bookRepository, WishlistRepository wishlistRepository) {
        this.bookRepository = bookRepository;
        this.wishlistRepository = wishlistRepository;
    }

    @GetMapping("/wishlist")
    protected String showWishlistOverview(Model model) {
        model.addAttribute("allWishlists", wishlistRepository.findAll());
        return "wishlistOverview";
    }

    @GetMapping("/wishlist/new")
    protected String showNewWishlistForm(Model model) {
        model.addAttribute("wishlist", new Wishlist());
        model.addAttribute("allUnreadBooks", bookRepository.findByisRead(false));
        return "wishlistNew";
    }

    @PostMapping("/wishlist/new")
    protected String saveWishlist(@ModelAttribute("wishlist") Wishlist wishlist, BindingResult result) {
        if (!result.hasErrors()) {
            wishlistRepository.save(wishlist);
        }
        return "redirect:/wishlist";
    }

    @GetMapping("/wishlist/update/{wishlistNumber}")
    protected String showUpdateWishlistForm(@PathVariable("wishlistNumber") Long wishlistNumber, Model model) {
        Optional<Wishlist> wishlist = wishlistRepository.findByWishID(wishlistNumber);
        if (wishlist.isEmpty()) {
            return "redirect:/wishlist";
        }
        model.addAttribute("wishlist", wishlist.get());
        model.addAttribute("allBooks", bookRepository.findByisRead(false));
        return "wishlistUpdate";
    }
}
