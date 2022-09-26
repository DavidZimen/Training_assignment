package sk.sb.training_assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sk.sb.training_assignment.entities.User;

import java.util.List;

/**
 * Repository for User entity.
 */
public interface UserRepository extends JpaRepository<User, Long> {}