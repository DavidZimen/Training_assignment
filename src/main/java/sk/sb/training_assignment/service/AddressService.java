package sk.sb.training_assignment.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.sb.training_assignment.entities.Address;
import sk.sb.training_assignment.entities.User;
import sk.sb.training_assignment.repository.AddressRepository;

/**
 * Service to handle transactions on Address entity.
 * @author <a href="https://github.com/DavidZimen">Dávic Zimen</a>
 */
@Service
public class AddressService {

    /**
     * Repository for Address entity.
     */
    private final AddressRepository addressRepository;

    /**
     * Constructor which is automatically wired to given addressRepository instance
     * @param addressRepository Instance of AddressRepository.
     */
    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    /**
     * Finds the address for the given user.
     * @param user User to search by.
     * @return Address of the user.
     */
    public Address findAddressByUserId(@NotNull User user) {
        return this.addressRepository.findAddressOfUser(user.getId());
    }

    /**
     * Updates the given address.
     * @param address Address to be updated.
     * @return Address that was updated.
     */
    public Address updateAddress(Address address) {
        return this.addressRepository.save(address);
    }

    /**
     * Adding address to the database.
     * @param address Address to be added.
     * @return Address that was added.
     */
    public Address addAddress(Address address) {
        return this.addressRepository.save(address);
    }

    /**
     * Delete address from the database.
     * @param addressId
     */
    public void deleteAddress(Long addressId) {
        this.addressRepository.deleteById(addressId);
    }
}