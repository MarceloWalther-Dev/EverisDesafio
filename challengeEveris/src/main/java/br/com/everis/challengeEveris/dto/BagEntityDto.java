/**
 * 
 */
package br.com.everis.challengeEveris.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.everis.challengeEveris.entity.BagEntity;
import br.com.everis.challengeEveris.entity.ItemEntity;
import br.com.everis.challengeEveris.entity.UserEntity;
import br.com.everis.challengeEveris.enuns.BagStatus;
import br.com.everis.challengeEveris.forms.FormBagDto;

/**
 * @author mwalther
 *
 */
public class BagEntityDto {

	private double total;
	private List<ItemEntity> items;
	private UserEntity user;
	private BagStatus status;
	private LocalDateTime date;

	/**
	 * 
	 */
	public BagEntityDto() {
	}

	/**
	 * @param total
	 * @param items
	 * @param user
	 * @param status
	 */
	public BagEntityDto(BagEntity entity) {
		this.date = entity.getCreatedAt();
		this.total = entity.getTotal();
		this.items = entity.getItems();
		this.user = entity.getUser();
		this.status = entity.getStatus();
	}

	public BagEntityDto(FormBagDto formBagDto) {
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

	public static List<BagEntityDto> convert(List<BagEntity> bag) {
		return bag.stream().map(BagEntityDto::new).collect(Collectors.toList());
	}

	public static BagEntityDto convertToDto(BagEntity bagEntity) {
		return new BagEntityDto(bagEntity);
	}

}
