package sk.sb.training_assignment.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.sb.training_assignment.entities.Address;
import sk.sb.training_assignment.entities.User;
import sk.sb.training_assignment.repository.AddressRepository;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address findAddressByUserId(@NotNull User user) {
        return this.addressRepository.findAddressOfUser(user.getId());
    }

    public Address updateAddress(Address address) {
        return this.addressRepository.save(address);
    }

    public Address addAddress(Address address) {
        return this.addressRepository.save(address);
    }

    public void deleteAddress(Long addressId) {
        this.addressRepository.deleteById(addressId);
    }
}