package mx.ipn.cic.eleven.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.ipn.cic.eleven.entities.DetailSaleEntity;
import mx.ipn.cic.eleven.entities.SaleEntity;
import mx.ipn.cic.eleven.repositories.IDetailSaleRepository;

@Service
public class DetailSaleService {

	@Autowired
	private IDetailSaleRepository detailSaleRepository;

	public List<DetailSaleEntity> saveAll(List<DetailSaleEntity> detailSaleList, SaleEntity sale) {
		for(DetailSaleEntity detailSale: detailSaleList) {
			detailSale.setSale(sale);
		}
		return this.detailSaleRepository.saveAll(detailSaleList);
	}
}
