package nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Annemiek Blaauwgeers <a.blaauwgeers@st.hanze.nl>
 * <p>
 * This is a wishlist with books that are yet to be bought.
 */

@Entity
@Getter @Setter
public class Wishlist {

    @Id
    @GeneratedValue
    private Long wishID;

    @ManyToMany(mappedBy = "wishlists")
    private Set<Book> wantedBooks = new HashSet<>();

    public String getBookDisplayString() {
        StringBuilder bookString = new StringBuilder();

        for (Book book : wantedBooks) {
            bookString.append(" ").append(book.getDisplayName());
        }

        return bookString.toString();
    }
}
