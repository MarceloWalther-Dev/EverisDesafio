package br.com.everis.challengeEveris.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author mwalther
 *
 */

@Entity
@Table(name = "item")
public class ItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "prod_Description")
	private String productDescript;

	@Column(name = "price_product")
	private Double priceProd;

	@Column(name = "quantity")
	private int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bag_id")
	@JsonIgnore
	private BagEntity bag;
	
	/**
	 * 
	 */
	public ItemEntity() {
	}

	/**
	 * @param id
	 * @param productDescript
	 * @param priceProd
	 * @param quantity
	 * @param bag
	 */
	public ItemEntity(Long id, String productDescript, double priceProd, int quantity, BagEntity bag) {
		this.id = id;
		this.productDescript = productDescript;
		this.priceProd = priceProd;
		this.quantity = quantity;
		this.bag = bag;
	}
	

	public ItemEntity(BagEntity bagEntity, String description, Double price) {
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
	 * @return the productDescript
	 */
	public String getProductDescript() {
		return productDescript;
	}

	/**
	 * @param productDescript the productDescript to set
	 */
	public void setProductDescript(String productDescript) {
		this.productDescript = productDescript;
	}

	/**
	 * @return the priceProd
	 */
	public double getPriceProd() {
		return priceProd;
	}

	/**
	 * @param priceProd the priceProd to set
	 */
	public void setPriceProd(double priceProd) {
		this.priceProd = priceProd;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the bag
	 */
	public BagEntity getBag() {
		return bag;
	}

	/**
	 * @param bag the bag to set
	 */
	public void setBag(BagEntity bag) {
		this.bag = bag;
	}
	
	
}
