package mx.ipn.cic.eleven.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="sale")
public class SaleEntity {

	@Id
	private String id;

	private LocalDateTime date;

	private double total;

	private String payment;

	@DBRef
	private UserEntity users;

	@Transient
	private Collection<DetailSaleEntity> detailSales = new ArrayList<DetailSaleEntity>();

	public SaleEntity() {
		super();
	}

	public SaleEntity(LocalDateTime date) {
		super();
		this.date = date;
	}

	public SaleEntity(String id, LocalDateTime date, double total, String payment, UserEntity users,
			Collection<DetailSaleEntity> detailSales) {
		super();
		this.id = id;
		this.date = date;
		this.total = total;
		this.payment = payment;
		this.users = users;
		this.detailSales = detailSales;
	}

	public SaleEntity(LocalDateTime date, double total, String payment, UserEntity users,
			Collection<DetailSaleEntity> detailSales) {
		super();
		this.date = date;
		this.total = total;
		this.payment = payment;
		this.users = users;
		this.detailSales = detailSales;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public UserEntity getUsers() {
		return users;
	}

	public void setUsers(UserEntity users) {
		this.users = users;
	}

	public Collection<DetailSaleEntity> getDetailSales() {
		return detailSales;
	}

	public void setDetailSales(Collection<DetailSaleEntity> detailSales) {
		this.detailSales = detailSales;
	}

	public String dateFormatted() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		return dtf.format(date);
	}

	@Override
	public String toString() {
		return String.format("SaleEntity [id=%s, date=%s, total=%s, payment=%s, users=%s, detailSales=%s]", id, date,
				total, payment, users, detailSales);
	}
}
