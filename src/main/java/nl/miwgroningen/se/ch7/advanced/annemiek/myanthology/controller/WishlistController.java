package nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.controller;

import nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.repository.BookRepository;
import nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.repository.WishlistRepository;
import org.springframework.stereotype.Controller;

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


}
