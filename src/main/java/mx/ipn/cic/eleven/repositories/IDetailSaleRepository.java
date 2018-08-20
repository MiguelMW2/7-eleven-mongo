package mx.ipn.cic.eleven.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import mx.ipn.cic.eleven.entities.DetailSaleEntity;

@Repository
public interface IDetailSaleRepository extends MongoRepository<DetailSaleEntity, String>{
	DetailSaleEntity findBySale_IdAndProduct_Id(String idSale, String idProduct);

	List<DetailSaleEntity> findBySale_Id(String id);
}
