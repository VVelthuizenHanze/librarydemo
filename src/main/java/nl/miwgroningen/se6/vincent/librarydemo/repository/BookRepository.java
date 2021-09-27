package nl.miwgroningen.se6.vincent.librarydemo.repository;

import nl.miwgroningen.se6.vincent.librarydemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
