package sk.sb.training_assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sk.sb.training_assignment.entities.User;

import java.util.List;

/**
 * Repository for User entity.
 * Using JpaRepository.
 * @author <a href="https://github.com/DavidZimen">Dávic Zimen</a>
 */
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u " +
            "WHERE UPPER(u.name) LIKE UPPER(CONCAT(CONCAT('%', ?1), '%'))" +
            "OR UPPER(u.surname) LIKE UPPER(CONCAT(CONCAT('%', ?1), '%'))")
    List<User> searchUsers(String query);
}