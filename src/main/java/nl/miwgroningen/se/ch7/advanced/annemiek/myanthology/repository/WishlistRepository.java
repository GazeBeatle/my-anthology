package nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.repository;

import nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    Optional<Wishlist> findByWishID(Long id);
}
