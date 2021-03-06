package mx.ipn.cic.eleven.rest_controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.ipn.cic.eleven.entities.ProductEntity;
import mx.ipn.cic.eleven.services.ProductService;

@RestController
@RequestMapping(path="/rest/product")
public class ProductRESTController {

	@Autowired
	private ProductService productService;

	@PostMapping(path="/search", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductEntity>> search(@RequestBody ProductEntity product
	) {
		System.out.println(product);
		ResponseEntity<List<ProductEntity>> response;
		try {
			List<ProductEntity> foundProducts = this.productService.findByNameUpc(product.getName(), product.getUpc());
			response = new ResponseEntity<List<ProductEntity>>(foundProducts, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<List<ProductEntity>>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return response;
	}

	@GetMapping(path="/search/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductEntity> search(
			@PathVariable(name="id") String id
			/*RequestBody*/
	) {
		ResponseEntity<ProductEntity> response;
		try {
			ProductEntity foundProduct = this.productService.findById(id);
			response = new ResponseEntity<ProductEntity>(foundProduct, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<ProductEntity>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return response;
	}
}
