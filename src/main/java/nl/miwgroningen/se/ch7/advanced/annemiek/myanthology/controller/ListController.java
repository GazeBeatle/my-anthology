package nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.controller;

import nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.model.List;
import nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.repository.BookRepository;
import nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.repository.ListRepository;
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
 * All interactions with a list.
 */

@Controller
public class ListController {

    private BookRepository bookRepository;
    private ListRepository listRepository;

    public ListController(BookRepository bookRepository, ListRepository listRepository) {
        this.bookRepository = bookRepository;
        this.listRepository = listRepository;
    }

    @GetMapping("/lists")
    protected String showListOverview(Model model) {
        model.addAttribute("allLists", listRepository.findAll());
        return "listOverview";
    }

    @GetMapping("/lists/new")
    protected String showNewWishlistForm(Model model) {
        model.addAttribute("list", new List());
        model.addAttribute("allUnreadBooks", bookRepository.findByisRead(false));
        return "listNew";
    }

    @PostMapping("/lists/new")
    protected String saveWishlist(@ModelAttribute("list") List list, BindingResult result) {
        if (!result.hasErrors()) {
            listRepository.save(list);
        }
        return "redirect:/lists";
    }

    @GetMapping("/lists/update/{listName}")
    protected String showUpdateWishlistForm(@PathVariable("listName") String listName, Model model) {
        Optional<List> list = listRepository.findByListName(listName);
        if (list.isEmpty()) {
            return "redirect:/lists";
        }
        model.addAttribute("list", list.get());
        model.addAttribute("allBooks", bookRepository.findByisRead(false));
        return "listUpdate";
    }
}
