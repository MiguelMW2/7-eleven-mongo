package mx.ipn.cic.eleven.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Document(collection="detail_sale")
public class DetailSaleEntity {

	@Id
	private String id;

	private double quantity;

	@DBRef
	@JsonBackReference
	private SaleEntity sale;

	@DBRef
	private ProductEntity product;

	public DetailSaleEntity() {
		super();
	}

	public DetailSaleEntity(String id, double quantity, SaleEntity sale, ProductEntity product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.sale = sale;
		this.product = product;
	}

	public DetailSaleEntity(double quantity, SaleEntity sale, ProductEntity product) {
		super();
		this.quantity = quantity;
		this.sale = sale;
		this.product = product;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public SaleEntity getSale() {
		return sale;
	}

	public void setSale(SaleEntity sale) {
		this.sale = sale;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return String.format("DetailSaleEntity [id=%s, quantity=%s, sale=%s, product=%s]", id, quantity, sale, product);
	}
}
