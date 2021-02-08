package br.com.everis.challengeEveris.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.everis.challengeEveris.dto.ProductEntityDto;
import br.com.everis.challengeEveris.dto.details.ProductEntityDtoDetail;
import br.com.everis.challengeEveris.entity.ProductEntity;
import br.com.everis.challengeEveris.exceptions.ProductNotFoundException;
import br.com.everis.challengeEveris.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public List<ProductEntityDto> list(){
		return productService.list();
	}
	
	//Busca com menor preco
	@GetMapping("/menor/preco")
	public List<ProductEntityDto> listSmallPrice(){
		return productService.listSmallPrice();
	}
	
	@GetMapping("/admin/{id}")
	public ResponseEntity<ProductEntityDtoDetail> listDetail(@PathVariable Long id) throws ProductNotFoundException{
		ProductEntityDtoDetail prodEntiDtoDetail = productService.productDetail(id);
		return new ResponseEntity<ProductEntityDtoDetail>(prodEntiDtoDetail,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ProductEntityDto> create(@RequestBody ProductEntity prodEntity){
		ProductEntityDto prodEntiDto = productService.save(prodEntity);
		return new ResponseEntity<ProductEntityDto>(prodEntiDto, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<ProductEntityDto> update(@RequestBody ProductEntity prodEntity) throws ProductNotFoundException{
		ProductEntityDto prodEntityDto = productService.update(prodEntity);
		return new ResponseEntity<ProductEntityDto>(prodEntityDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/admin/{id}")
	public List<ProductEntityDto> delete(@PathVariable Long id) throws ProductNotFoundException {
		productService.delete(id);
		return productService.list();
	}
}
