package nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.repository;

import nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.model.List;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ListRepository extends JpaRepository<List, Long> {
    Optional<List> findByListName(String name);
}
