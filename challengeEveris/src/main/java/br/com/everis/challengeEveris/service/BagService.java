/**
 * 
 */
package br.com.everis.challengeEveris.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.everis.challengeEveris.dto.BagEntityDto;
import br.com.everis.challengeEveris.entity.BagEntity;
import br.com.everis.challengeEveris.entity.ItemEntity;
import br.com.everis.challengeEveris.entity.ProductEntity;
import br.com.everis.challengeEveris.entity.UserEntity;
import br.com.everis.challengeEveris.enuns.BagStatus;
import br.com.everis.challengeEveris.exceptions.BagNotFoundException;
import br.com.everis.challengeEveris.exceptions.ClientNotFoundException;
import br.com.everis.challengeEveris.forms.FormBagDto;
import br.com.everis.challengeEveris.repository.BagRepository;
import br.com.everis.challengeEveris.repository.ProductRepository;
import br.com.everis.challengeEveris.repository.UserRepository;

/**
 * @author mwalther
 *
 */
@Service
public class BagService {

	@Autowired
	private final BagRepository bagRepository;
	private final UserRepository userRepository;
	private final ProductRepository productRepository;

	public BagService(BagRepository bagRepository, UserRepository userRepository, ProductRepository productRepository) {
		this.bagRepository = bagRepository;
		this.userRepository = userRepository;
		this.productRepository = productRepository;
	}

	// get
	@Transactional(readOnly = true)
	public List<BagEntityDto> list() {
		return BagEntityDto.convert(bagRepository.findAll());
	}

	// Post
	@Transactional
	public BagEntityDto create(FormBagDto formBagDto) throws ClientNotFoundException {
		UserEntity user = userRepository.findById(formBagDto.getUserId()).orElseThrow(() -> new ClientNotFoundException(
				"Cliente não esta cadastrado em nosso sistema, antes de fazer o pedido cadastre-se"));

		BagEntity bagEntity = new BagEntity(user, BagStatus.PENDING);

		List<ItemEntity> items = formBagDto.getProducts().stream().map(i -> {
			try {
				ProductEntity product = productRepository.findById(i.getProductId()).get();
				ItemEntity itemEntity = new ItemEntity();
				itemEntity.setBag(bagEntity);
				itemEntity.setProductDescript(product.getDescription());
				itemEntity.setPriceProd(product.getPrice());
				itemEntity.setQuantity(i.getQuantity());
				return itemEntity;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}).collect(Collectors.toList());
		// TODO: implementar ordem de negocio para verificar a quantidade.
		double total = items.stream().filter(item -> item.getQuantity() > 0)
				.mapToDouble(item -> item.getPriceProd() * item.getQuantity()).sum();
		bagEntity.setTotal(total);
		bagEntity.setItems(items);
		bagEntity.setCreatedAt(LocalDateTime.now());
		

		bagRepository.save(bagEntity);

		return new BagEntityDto(bagEntity);
	}

	// Put
	@Transactional
	public BagEntityDto update(FormBagDto formBagDto) throws BagNotFoundException, ClientNotFoundException {
		
		BagEntity bag = bagRepository.findById(formBagDto.getId()).orElseThrow(
				() -> new BagNotFoundException("Pedido não encontrado. por favor verifique o numero do pedido"));
		
		UserEntity user = userRepository.findById(bag.getUser().getId()).orElseThrow(
				() -> new ClientNotFoundException("Cliente não encontrado."));
		
		 BagEntity bagNew = new BagEntity(bag.getId());
		 
		List<ItemEntity> listProdu = formBagDto.getProducts().stream().map(i -> {
			try {
				ProductEntity product = productRepository.findById(i.getProductId()).get();
				ItemEntity itemEntity = new ItemEntity();
				itemEntity.setId(product.getId());;
				itemEntity.setProductDescript(product.getDescription());
				itemEntity.setPriceProd(product.getPrice());
				itemEntity.setQuantity(i.getQuantity());
				return itemEntity;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}).collect(Collectors.toList());
		
		double total = listProdu.stream().filter(item -> item.getQuantity() > 0)
				.mapToDouble(item -> item.getPriceProd() * item.getQuantity()).sum();
		
		bagNew.setTotal(total);
		bagNew.setItems(listProdu);
		bagNew.setCreatedAt(LocalDateTime.now());
		bagNew.setUser(bag.getUser());
		bagNew.setStatus(bag.getStatus());
		
		
		bagRepository.save(bagNew);
		
		return new BagEntityDto(bagNew);
	}

	//FindById
	public BagEntity findById(Long id) throws BagNotFoundException {
		return bagRepository.findById(id).orElseThrow(
				() -> new BagNotFoundException("Pedido não encontrado. por favor verifique o numero do pedido"));
		
	}
	
	//Delete
	public void delete(Long id) throws BagNotFoundException {
		BagEntity bagEntity = bagRepository.findById(id).orElseThrow(
				() -> new BagNotFoundException("Pedido não encontrado. por favor verifique o numero do pedido"));
		bagRepository.deleteById(bagEntity.getId());
		
		list();
	}


}
