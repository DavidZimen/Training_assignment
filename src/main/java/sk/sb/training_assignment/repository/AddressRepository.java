package sk.sb.training_assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sk.sb.training_assignment.entities.Address;
import sk.sb.training_assignment.entities.User;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query(
        value = "SELECT * FROM Address WHERE user.id = :userId",
        nativeQuery = true
    )
    Address findAddressOfUser(@Param("userId") Long userId);


}