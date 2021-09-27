package nl.miwgroningen.se6.vincent.librarydemo.model;

import javax.persistence.*;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 *
 * Books of which the library can get copies
 */

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Integer bookId;

    @Column(unique = true)
    private String title;

    @ManyToOne
    private Author author;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
