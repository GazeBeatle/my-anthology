package nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.repository;

import nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String title);

    List<Book> findByisRead(boolean isRead);
}
