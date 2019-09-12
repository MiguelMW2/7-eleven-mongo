package mx.ipn.cic.eleven.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import mx.ipn.cic.eleven.entities.ProductEntity;
import java.lang.String;

@Repository
public interface IProductRepository extends MongoRepository<ProductEntity, String>{
	 List<ProductEntity> findByNameContainingOrUpcContaining(String name, String upc);
}
