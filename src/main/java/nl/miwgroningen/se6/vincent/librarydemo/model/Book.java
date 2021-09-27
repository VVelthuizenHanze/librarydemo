package nl.miwgroningen.se6.vincent.librarydemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 *
 * Dit zijn boeken waarvan de bibliotheek exemplaren heeft of kan bemachtigen, om vervolgens uit te lenen
 */

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Integer bookId;

    private String title;

    private String author;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
