package mx.ipn.cic.eleven.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Document(collection="detail_sale")
public class DetailSaleEntity {

	@Id
	private String id;

	private Integer quantityProduct;

	@DBRef
	@JsonBackReference
	private SaleEntity sales;

	@DBRef
	private ProductEntity products;

	/*@DBRef
	 * @JsonIgnore
	 * @JsonBackReference
	 * private SellEntity sell
	
	 * private List<SellDetailEntity> detail
	*/

	public DetailSaleEntity() {
		super();
	}

	public DetailSaleEntity(String id, Integer quantityProduct, SaleEntity sales, ProductEntity products) {
		super();
		this.id = id;
		this.quantityProduct = quantityProduct;
		this.sales = sales;
		this.products = products;
	}

	public DetailSaleEntity(Integer quantityProduct, SaleEntity sales, ProductEntity products) {
		super();
		this.quantityProduct = quantityProduct;
		this.sales = sales;
		this.products = products;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getQuantityProduct() {
		return quantityProduct;
	}

	public void setQuantityProduct(Integer quantityProduct) {
		this.quantityProduct = quantityProduct;
	}

	public SaleEntity getSales() {
		return sales;
	}

	public void setSales(SaleEntity sales) {
		this.sales = sales;
	}

	public ProductEntity getProducts() {
		return products;
	}

	public void setProducts(ProductEntity products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return String.format("DetailSaleEntity [id=%s, quantityProduct=%s, sales=%s, products=%s]", id, quantityProduct,
				sales, products);
	}
}
