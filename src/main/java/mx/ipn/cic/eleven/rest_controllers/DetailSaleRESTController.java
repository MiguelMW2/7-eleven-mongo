package mx.ipn.cic.eleven.rest_controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.ipn.cic.eleven.entities.DetailSaleEntity;
import mx.ipn.cic.eleven.entities.SaleEntity;
import mx.ipn.cic.eleven.services.DetailSaleService;
import mx.ipn.cic.eleven.services.SaleService;

@RestController
@RequestMapping(path="/rest/detailSale")
public class DetailSaleRESTController {

	@Autowired
	private DetailSaleService detailSaleService;

	@Autowired
	private SaleService saleService;

	@PostMapping(path="/save", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> register(@RequestBody List<DetailSaleEntity> detailSale) {
		ResponseEntity<String> response;
		SaleEntity sale = new SaleEntity(LocalDateTime.now());
		this.saleService.register(sale);
		this.detailSaleService.saveAll(detailSale, sale);
		try {
			response = new ResponseEntity<String>(sale.getId(), HttpStatus.CREATED);
		} catch (Exception e) {
			response = new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
		}
		return response;
	}
}
