package nl.miwgroningen.se6.vincent.librarydemo.repository;

import nl.miwgroningen.se6.vincent.librarydemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findByTitle(String title);
}
