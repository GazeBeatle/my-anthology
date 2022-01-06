package nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.controller;

import nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.model.Book;
import nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.repository.BookRepository;
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
 * All interactions with books in the anthology.
 */

@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books/new")
    protected String showNewBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "bookNew";
    }

    @PostMapping("/books/new")
    protected String saveBook(@ModelAttribute("book") Book book, BindingResult result) {
        if (!result.hasErrors()) {
            bookRepository.save(book);
        }
        return "redirect:/overview";
    }

    @GetMapping("/books/update/{bookTitle}")
    protected String showUpdateBookForm(@PathVariable("bookTitle") String bookTitle, Model model) {
        Optional<Book> book = bookRepository.findByTitle(bookTitle);
        if (book.isEmpty()) {
            return "redirect:/overview";
        }
        model.addAttribute("book", book.get());
        return "bookUpdate";
    }
}
