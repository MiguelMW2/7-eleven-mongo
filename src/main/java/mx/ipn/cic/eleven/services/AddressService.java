package mx.ipn.cic.eleven.services;

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
}
