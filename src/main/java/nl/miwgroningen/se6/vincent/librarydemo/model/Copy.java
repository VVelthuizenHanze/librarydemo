package nl.miwgroningen.se6.vincent.librarydemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 *
 * A physical copy of a book that can be loand by a user
 */

@Entity
public class Copy {

    @Id
    @GeneratedValue
    private Integer copyId;

    private Boolean available = true;

    @ManyToOne
    private Book book;

    public Copy(Book book) {
        this.book = book;
    }

    public Copy() {
    }

    public Integer getCopyId() {
        return copyId;
    }

    public void setCopyId(Integer copyId) {
        this.copyId = copyId;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
