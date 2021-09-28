package nl.miwgroningen.se6.vincent.librarydemo.repository;

import nl.miwgroningen.se6.vincent.librarydemo.model.Copy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CopyRepository extends JpaRepository<Copy, Integer> {
}
