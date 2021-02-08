/**
 * 
 */
package br.com.everis.challengeEveris.forms;

import java.util.List;

/**
 * @author mwalther
 *
 */
public class FormBagDto {

	private Long id;
	private Long userId;
	private List<FormItemDto> products;

	/**
	 * 
	 */
	public FormBagDto() {
	}

	/**
	 * @param id
	 * @param userId
	 * @param products
	 */
	public FormBagDto(Long id, Long userId, List<FormItemDto> products) {
		this.id = id;
		this.userId = userId;
		this.products = products;
	}

	/**
	 * @param userId
	 * @param products
	 */
	public FormBagDto(Long userId, List<FormItemDto> products) {
		this.userId = userId;
		this.products = products;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the products
	 */
	public List<FormItemDto> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<FormItemDto> products) {
		this.products = products;
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

}
