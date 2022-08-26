package sk.sb.training_assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.sb.training_assignment.entities.User;

/**
 * Repository for User entity.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}