package mx.ipn.cic.eleven.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.ipn.cic.eleven.entities.DetailSaleEntity;
import mx.ipn.cic.eleven.entities.SaleEntity;
import mx.ipn.cic.eleven.repositories.IDetailSaleRepository;
import mx.ipn.cic.eleven.repositories.ISaleRepository;

@Service
public class SaleService {

	@Autowired
	private ISaleRepository saleRepository;

	@Autowired
	private IDetailSaleRepository detailSaleRepository;

	public List<SaleEntity> allSales() {
		return this.saleRepository.findAll();
	}

	public SaleEntity findById(String id) {
		Optional<SaleEntity> found = this.saleRepository.findById(id);
		try {
			return found.get();
		} catch (NoSuchElementException e) {
			System.out.println("No se encontró el elemento");
		}
		return null;
	}

	public SaleEntity register(SaleEntity sale) {
		return this.saleRepository.save(sale);
	}

	public SaleEntity edit(String id) {
		Optional<SaleEntity> found = this.saleRepository.findById(id);
		try {
			return found.get();
		}
		catch (NoSuchElementException e) {
			System.out.println("Elemento no encontrado");
		}
		return null;
	}

	public boolean delete(String id) {
		this.saleRepository.deleteById(id);
		return true;
	}

	public double calculate(SaleEntity sale) {
		double result = 0;
		for (DetailSaleEntity detailSale : this.detailSaleRepository.findBySale_Id(sale.getId())) {
			result += detailSale.getProduct().getPrice() * detailSale.getQuantity();
		}
		System.out.println(result);
		return result;
	}
}
