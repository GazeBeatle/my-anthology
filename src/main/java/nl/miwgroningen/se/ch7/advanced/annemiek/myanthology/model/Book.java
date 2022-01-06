package nl.miwgroningen.se.ch7.advanced.annemiek.myanthology.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

    protected boolean isRead = true;

    @ManyToOne
    private Wishlist wishlist;

    public String getDisplayName() {
        return String.format("%s - %s", author, title);
    }
}
