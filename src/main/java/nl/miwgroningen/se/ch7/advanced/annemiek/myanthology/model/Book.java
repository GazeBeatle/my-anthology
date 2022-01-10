package nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Annemiek Blaauwgeers <a.blaauwgeers@st.hanze.nl>
 * <p>
 * This is a book that is recorded in an anthology.
 */

@Entity
@Getter @Setter
public class Book {

    @Id
    @GeneratedValue
    protected Long bookID;

    protected String title;

    protected String author;

    protected boolean isRead;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<List> lists = new HashSet<>();

    public String getDisplayName() {
        return String.format("%s - %s", author, title);
    }
}
