package br.com.everis.challengeEveris.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "address")
public class AddressEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "street")
	private String street;
	@Column(name = "district")
	private String district;
	@Column(name = "houseNumber")
	private Integer houseNumber;
	@Column(name = "complement")
	private String complement;

	public AddressEntity() {
	}
	
	
	
	/**
	 * @param id
	 * @param street
	 * @param district
	 * @param houseNumber
	 * @param complement
	 */
	public AddressEntity(Long id, String street, String district, Integer houseNumber, String complement) {
		this.id = id;
		this.street = street;
		this.district = district;
		this.houseNumber = houseNumber;
		this.complement = complement;
	}



	

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}



	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}



	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}



	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}



	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}



	/**
	 * @return the houseNumber
	 */
	public Integer getHouseNumber() {
		return houseNumber;
	}



	/**
	 * @param houseNumber the houseNumber to set
	 */
	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}



	/**
	 * @return the complement
	 */
	public String getComplement() {
		return complement;
	}



	/**
	 * @param complement the complement to set
	 */
	public void setComplement(String complement) {
		this.complement = complement;
	}



	@Override
	public String toString() {
		return "Address [street=" + street + ", district=" + district + ", houseNumber=" + houseNumber + ", complement="
				+ complement + "]";
	}
}
