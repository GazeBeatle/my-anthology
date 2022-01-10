package nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Annemiek Blaauwgeers <a.blaauwgeers@st.hanze.nl>
 * <p>
 * This is a list to which books can be added.
 */

@Entity
@Getter @Setter
public class List {

    @Id
    @GeneratedValue
    private Long listID;

    private String listName;

    @ManyToMany(mappedBy = "lists")
    private Set<Book> listedBooks = new HashSet<>();

    public String getBookDisplayString() {
        StringBuilder bookString = new StringBuilder();

        for (Book book : listedBooks) {
            bookString.append(" ").append(book.getDisplayName());
        }

        return bookString.toString();
    }
}
