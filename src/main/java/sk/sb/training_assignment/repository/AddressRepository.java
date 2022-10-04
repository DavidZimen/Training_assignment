package sk.sb.training_assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sk.sb.training_assignment.entities.Address;
import sk.sb.training_assignment.entities.User;

/**
 * Repository for Address ebtity.
 * Using JpaRepository for automatically generated methods.
 */
public interface AddressRepository extends JpaRepository<Address, Long> {

    /**
     * @param userId Unique identifier of the user.
     * @return Address of the user based on his id.
     */
    @Query(
        value = "SELECT * FROM Address WHERE user.id = :userId",
        nativeQuery = true
    )
    Address findAddressOfUser(@Param("userId") Long userId);
}