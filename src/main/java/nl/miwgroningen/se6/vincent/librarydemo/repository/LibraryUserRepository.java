package nl.miwgroningen.se6.vincent.librarydemo.repository;

import nl.miwgroningen.se6.vincent.librarydemo.model.LibraryUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibraryUserRepository extends JpaRepository<LibraryUser, Integer> {
    Optional<LibraryUser> findByUsername(String username);
}
