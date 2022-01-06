package nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.controller;

import nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.model.AnthologyUser;
import nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.repository.AnthologyUserRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Annemiek Blaauwgeers <a.blaauwgeers@st.hanze.nl>
 * <p>
 * Registers users.
 */

@Controller
public class AnthologyUserController {

    private AnthologyUserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public AnthologyUserController(AnthologyUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/users/new")
    @Secured("ROLE_ADMIN")
    protected String showUserForm(Model model) {
        model.addAttribute("newUser", new AnthologyUser());
        return "userForm";
    }

    @PostMapping("/users/new")
    @Secured("ROLE_ADMIN")
    protected String saveOrUpdateUser(@ModelAttribute("newUser") AnthologyUser user, BindingResult result) {
        if (result.hasErrors()) {
            return "userForm";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/home";
    }
}
