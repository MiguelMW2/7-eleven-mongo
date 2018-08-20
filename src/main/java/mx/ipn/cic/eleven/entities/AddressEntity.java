package mx.ipn.cic.eleven.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="address")
public class AddressEntity {

	@Id
	private String id;

	private String street;

	private String district;

	private Integer externalNumber;

	private Integer internalNumber;

	private String state;

	private String zipCode;

	@DBRef
	private UserEntity users;

	public AddressEntity() {
		super();
	}

	public AddressEntity(UserEntity users) {
		super();
		this.users = users;
	}

	public AddressEntity(String id, String street, String district, Integer externalNumber, Integer internalNumber,
			String state, String zipCode, UserEntity user) {
		super();
		this.id = id;
		this.street = street;
		this.district = district;
		this.externalNumber = externalNumber;
		this.internalNumber = internalNumber;
		this.state = state;
		this.zipCode = zipCode;
		this.users = user;
	}

	public AddressEntity(String street, String district, Integer externalNumber, Integer internalNumber, String state,
			String zipCode, UserEntity user) {
		super();
		this.street = street;
		this.district = district;
		this.externalNumber = externalNumber;
		this.internalNumber = internalNumber;
		this.state = state;
		this.zipCode = zipCode;
		this.users = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Integer getExternalNumber() {
		return externalNumber;
	}

	public void setExternalNumber(Integer externalNumber) {
		this.externalNumber = externalNumber;
	}

	public Integer getInternalNumber() {
		return internalNumber;
	}

	public void setInternalNumber(Integer internalNumber) {
		this.internalNumber = internalNumber;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public UserEntity getUser() {
		return users;
	}

	public void setUser(UserEntity user) {
		this.users = user;
	}

	@Override
	public String toString() {
		return "AddressEntity [id=" + id + ", street=" + street + ", district=" + district + ", externalNumber="
				+ externalNumber + ", internalNumber=" + internalNumber + ", state=" + state + ", zipCode=" + zipCode
				+ ", user=" + users + "]";
	}
}
