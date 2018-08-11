package mx.ipn.cic.eleven.entities;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="product")
public class ProductEntity {

	@Id
	private String id;

	private String name;

	private String description;

	private Double price;

	private Integer stock;

	private String upc;

	@Transient
	private Collection<DetailSaleEntity> detailSales = new ArrayList<DetailSaleEntity>();

	public ProductEntity() {
		super();
	}

	public ProductEntity(String id, String name, String description, Double price, Integer stock, String upc,
			Collection<DetailSaleEntity> detailSales) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.upc = upc;
		this.detailSales = detailSales;
	}

	public ProductEntity(String name, String description, Double price, Integer stock, String upc,
			Collection<DetailSaleEntity> detailSales) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.upc = upc;
		this.detailSales = detailSales;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public Collection<DetailSaleEntity> getDetailSales() {
		return detailSales;
	}

	public void setDetailSales(Collection<DetailSaleEntity> detailSales) {
		this.detailSales = detailSales;
	}

	@Override
	public String toString() {
		return String.format(
				"ProductEntity [id=%s, name=%s, description=%s, price=%s, stock=%s, upc=%s, detailSales=%s]", id, name,
				description, price, stock, upc, detailSales);
	}
}
