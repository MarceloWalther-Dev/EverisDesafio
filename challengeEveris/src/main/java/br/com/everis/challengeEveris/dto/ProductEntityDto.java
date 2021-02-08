package br.com.everis.challengeEveris.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.everis.challengeEveris.entity.ProductEntity;

public class ProductEntityDto {

	private String description;
	private Double price;

	public ProductEntityDto() {
	}

	public ProductEntityDto(ProductEntity prodEnti) {
		this.description = prodEnti.getDescription();
		this.price = prodEnti.getPrice();
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
	
	public static List<ProductEntityDto> convert(List<ProductEntity> produEntity) {
		return produEntity.stream().map(ProductEntityDto ::new).collect(Collectors.toList());
	}

	public ProductEntityDto convertToDto(ProductEntity prodEntity) {
		return new ProductEntityDto(prodEntity);
	}
	
}
