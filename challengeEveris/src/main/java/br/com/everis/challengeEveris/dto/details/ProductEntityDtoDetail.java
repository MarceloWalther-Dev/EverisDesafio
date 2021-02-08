package br.com.everis.challengeEveris.dto.details;

import java.util.List;
import java.util.stream.Collectors;

import br.com.everis.challengeEveris.entity.ProductEntity;
import br.com.everis.challengeEveris.entity.UserEntity;

public class ProductEntityDtoDetail {

	private Long id;
	private String description;
	private Double price;

	public ProductEntityDtoDetail(ProductEntity prodEntity) {
		this.id = prodEntity.getId();
		this.description = prodEntity.getDescription();
		this.price = prodEntity.getPrice();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public static List<ProductEntityDtoDetail> convert(List<ProductEntity> product) {
		return product.stream().map(ProductEntityDtoDetail ::new).collect(Collectors.toList());
	}
	
	public static ProductEntityDtoDetail convertToDto(ProductEntity product) {
		return new ProductEntityDtoDetail(product);
	}

}
