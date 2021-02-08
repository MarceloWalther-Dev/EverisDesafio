/**
 * 
 */
package br.com.everis.challengeEveris.forms;

/**
 * @author mwalther
 *
 */
public class FormItemDto {

	private Long productId;
	private int quantity;

	/**
	 * 
	 */
	public FormItemDto() {
	}

	/**
	 * @param productId
	 * @param quantity
	 */
	public FormItemDto(Long productId, int quantity) {
		this.productId = productId;
		this.quantity = quantity;
	}

	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
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

}
