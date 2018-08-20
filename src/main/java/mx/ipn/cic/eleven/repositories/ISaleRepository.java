package mx.ipn.cic.eleven.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import mx.ipn.cic.eleven.entities.SaleEntity;

@Repository
public interface ISaleRepository extends MongoRepository<SaleEntity, String>{
	
}
