package nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.repository;

import nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.model.AnthologyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnthologyUserRepository extends JpaRepository<AnthologyUser, Long> {
    Optional<AnthologyUser> findByUsername(String username);
}
