package mx.ipn.cic.eleven.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.ipn.cic.eleven.entities.AddressEntity;
import mx.ipn.cic.eleven.repositories.IAddressRepository;

@Service
public class AddressService {

	@Autowired
	private IAddressRepository addressRepository;

	public AddressEntity register(AddressEntity address) { 
		return this.addressRepository.save(address);
	}

	public AddressEntity findByUser_Id(String id) {
		return this.addressRepository.findByUsers_Id(id);
	}

	public boolean delete(String id) {
		this.addressRepository.deleteById(id);
		return true;
	}

	public List<AddressEntity> allAddress() {
		return this.addressRepository.findAll();
	}

	public AddressEntity findById(String id) {
		Optional<AddressEntity> found = this.addressRepository.findById(id);
		try {
			return found.get();
		} catch (NoSuchElementException e) {
			System.out.println("No se encontró el elemento");
		}
		return null;
	}

	public AddressEntity edit(String id) {
		Optional<AddressEntity> found = this.addressRepository.findById(id);
		try {
			return found.get();
		}
		catch (NoSuchElementException e) {
			System.out.println("Elemento no encontrado");
		}
		return null;
	}
}
