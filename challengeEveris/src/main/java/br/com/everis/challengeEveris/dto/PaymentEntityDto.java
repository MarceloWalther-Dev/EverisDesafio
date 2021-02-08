/**
 * 
 */
package br.com.everis.challengeEveris.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.everis.challengeEveris.entity.BagEntity;
import br.com.everis.challengeEveris.entity.PaymentEntity;
import br.com.everis.challengeEveris.enuns.PaymentType;

/**
 * @author mwalther
 *
 */
public class PaymentEntityDto {

	private Long id;
	private LocalDateTime date;
	private PaymentType paymentType;
	private BagEntity bag;
	
	
	public PaymentEntityDto() {}
	
	/**
	 * @param id
	 * @param date
	 * @param paymentType
	 * @param bag
	 */
	public PaymentEntityDto(PaymentEntity paymentEntity) {
		this.id = paymentEntity.getId();
		this.date = paymentEntity.getDate();
		this.paymentType = paymentEntity.getPaymentType();
		this.bag = paymentEntity.getBag();
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
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	/**
	 * @return the paymentType
	 */
	public PaymentType getPaymentType() {
		return paymentType;
	}

	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
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
	
	
	public static List<PaymentEntityDto> convert(List<PaymentEntity> payment) {
		return payment.stream().map(PaymentEntityDto ::new).collect(Collectors.toList());
	}

	public PaymentEntityDto convertToDto(PaymentEntity payment) {
		return new PaymentEntityDto(payment);
	}
	
	
}
