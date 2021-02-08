/**
 * 
 */
package br.com.everis.challengeEveris.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.everis.challengeEveris.enuns.PaymentType;

/**
 * @author mwalther
 *
 */
@Entity
@Table(name = "payment")
public class PaymentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "date")
	private LocalDateTime date;

	@Enumerated(EnumType.STRING)
	@Column(name = "paymentType")
	private PaymentType paymentType;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "bag_id")
	private BagEntity bag;

	public PaymentEntity() {
	}

	/**
	 * @param id
	 * @param date
	 * @param paymentType
	 * @param bag
	 */
	public PaymentEntity(Long id, LocalDateTime date, PaymentType paymentType, BagEntity bag) {
		this.id = id;
		this.date = date;
		this.paymentType = paymentType;
		this.bag = bag;
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

}
