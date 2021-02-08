package br.com.everis.challengeEveris.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.everis.challengeEveris.enuns.BagStatus;

/**
 * @author mwalther
 *
 */

@Entity
@Table(name = "bag")
public class BagEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "total")
	private double total;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@OneToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@Enumerated(EnumType.STRING)
	private BagStatus status;

	@OneToMany(mappedBy = "bag", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
	private List<ItemEntity> items;

	public BagEntity() {
	}

	/**
	 * @param id
	 * @param total
	 * @param createdAt
	 * @param user
	 * @param status
	 * @param items
	 */
	public BagEntity(Long id, double total, LocalDateTime createdAt, UserEntity user, BagStatus status,
			List<ItemEntity> items) {
		this.id = id;
		this.total = total;
		this.createdAt = createdAt;
		this.user = user;
		this.status = status;
		this.items = items;
	}

	/**
	 * @param user
	 * @param status
	 */
	public BagEntity(UserEntity user, BagStatus status) {
		this.user = user;
		this.status = status;
	}

	public BagEntity(Long id) {
		this.id = id;
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
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * @return the user
	 */
	public UserEntity getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserEntity user) {
		this.user = user;
	}

	/**
	 * @return the status
	 */
	public BagStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(BagStatus status) {
		this.status = status;
	}

	/**
	 * @return the items
	 */
	public List<ItemEntity> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<ItemEntity> items) {
		this.items = items;
	}

	/**
	 * @return the createdAt
	 */
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
