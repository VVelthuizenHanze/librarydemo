package nl.miwgroningen.se6.vincent.librarydemo.model;

import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 *
 * Writer of books
 */

@Entity
public class Author {

    @Id
    @GeneratedValue
    private Integer authorId;

    @Column(unique = true)
    private String firstName;
    private String infixName;
    @Column(unique = true)
    private String lastName;

    public String getDisplayName() {
        return firstName + " " + (infixName.isBlank() ? "" : infixName + " ") + lastName;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getInfixName() {
        return infixName;
    }

    public void setInfixName(String infixName) {
        this.infixName = infixName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
