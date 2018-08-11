package mx.ipn.cic.eleven.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.ipn.cic.eleven.entities.ProductEntity;
import mx.ipn.cic.eleven.repositories.IProductRepository;

@Service
public class ProductService {

	@Autowired
	private IProductRepository productRepository;

	public List<ProductEntity> allProducts() {
		return this.productRepository.findAll();
	}
	
	public ProductEntity register(ProductEntity product) {
		return this.productRepository.save(product);
	}

	public ProductEntity findById(String id) {
		Optional<ProductEntity> found = this.productRepository.findById(id);
		try {
			return found.get();
		} catch (NoSuchElementException e) {
			System.out.println("No se encontró el elemento");
		}
		return null;
	}

	public List<ProductEntity> search(String name, String upc) {
		return this.productRepository.findByNameContainingOrUpcContaining(name, upc);
	}

	public ProductEntity save(ProductEntity product) {
		return this.productRepository.save(product);
	}

	public boolean delete(String id) {
		this.productRepository.deleteById(id);
		return true;
	}
}