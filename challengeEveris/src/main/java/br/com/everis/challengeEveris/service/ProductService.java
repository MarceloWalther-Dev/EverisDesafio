package br.com.everis.challengeEveris.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.everis.challengeEveris.dto.ProductEntityDto;
import br.com.everis.challengeEveris.dto.details.ProductEntityDtoDetail;
import br.com.everis.challengeEveris.entity.ProductEntity;
import br.com.everis.challengeEveris.exceptions.ProductNotFoundException;
import br.com.everis.challengeEveris.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired 
	private final ProductRepository repository;
	
	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}
	
	//get
	@Transactional(readOnly = true)
	public List<ProductEntityDto> list(){
		return ProductEntityDto.convert(repository.findAll());
	}
	
	@Transactional(readOnly = true)
	public List<ProductEntityDto> listSmallPrice(){
		List<ProductEntityDto> list = new ArrayList<ProductEntityDto>(repository.findAllByOrderByPriceAsc());
		return list;
	}
	
	//getAdmin
	@Transactional(readOnly = true)
	public ProductEntityDtoDetail productDetail(Long id) throws ProductNotFoundException {
		return ProductEntityDtoDetail.convertToDto(repository.findById(id).orElseThrow(
				() -> new ProductNotFoundException("Produto solicitado não consta em nosso sistema")));
	}
	
	//post
	public ProductEntityDto save(ProductEntity prodEntity) {
		repository.save(prodEntity);
		return new ProductEntityDto(prodEntity);
	}
	
	//put
	public ProductEntityDto update(ProductEntity prodEntity) throws ProductNotFoundException {
		@SuppressWarnings("unused")
		ProductEntity prodBank = repository.findById(prodEntity.getId()).orElseThrow(
				() -> new ProductNotFoundException("Produto solicitado para alteração não encontrado, por favor verificar"));
		
		ProductEntity prodtEntityNew = new ProductEntity();
		
		prodtEntityNew.setId(prodEntity.getId());
		prodtEntityNew.setDescription(prodEntity.getDescription());
		prodtEntityNew.setPrice(prodEntity.getPrice());
		
		repository.save(prodtEntityNew);
		return new ProductEntityDto(prodtEntityNew);
		
	}
	
	//Delete
	public void delete(Long id) throws ProductNotFoundException{
		 ProductEntity produEnti = repository.findById(id).orElseThrow(
				 () -> new ProductNotFoundException("Produto solicitado para alteração não encontrado, por favor verificar"));
		 repository.deleteById(produEnti.getId());
	}
}
