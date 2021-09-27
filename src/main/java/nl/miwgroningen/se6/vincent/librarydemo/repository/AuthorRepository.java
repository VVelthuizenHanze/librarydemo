package nl.miwgroningen.se6.vincent.librarydemo.repository;

import nl.miwgroningen.se6.vincent.librarydemo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
