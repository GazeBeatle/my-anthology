package nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.service;

import nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.repository.AnthologyUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Annemiek Blaauwgeers <a.blaauwgeers@st.hanze.nl>
 * <p>
 * Enables the system to find and authenticate users.
 */

@Service
public class AnthologyUserDetailsService implements UserDetailsService {

    private AnthologyUserRepository anthologyUserRepository;

    public AnthologyUserDetailsService(AnthologyUserRepository anthologyUserRepository) {
        this.anthologyUserRepository = anthologyUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return anthologyUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with name" + username + "was not found."));
    }
}
