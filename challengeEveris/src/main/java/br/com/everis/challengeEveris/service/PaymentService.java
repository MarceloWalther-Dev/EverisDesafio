/**
 * 
 */
package br.com.everis.challengeEveris.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.everis.challengeEveris.dto.PaymentEntityDto;
import br.com.everis.challengeEveris.entity.BagEntity;
import br.com.everis.challengeEveris.entity.PaymentEntity;
import br.com.everis.challengeEveris.enuns.BagStatus;
import br.com.everis.challengeEveris.exceptions.BagNotFoundException;
import br.com.everis.challengeEveris.exceptions.PaymentNotFoundException;
import br.com.everis.challengeEveris.repository.PaymentRepository;

/**
 * @author mwalther
 *
 */
@Service
public class PaymentService {
	
	private final PaymentRepository paymentRepository;
	private final BagService bagService;
	
	public PaymentService(PaymentRepository paymentRepository,BagService bagService) {
		this.paymentRepository = paymentRepository;
		this.bagService = bagService;
	}
	
	//GetAll
	public List<PaymentEntityDto> list(){
		return PaymentEntityDto.convert(paymentRepository.findAll());
	}
	
	//Post
	public PaymentEntityDto create(PaymentEntity paymentEntity) throws BagNotFoundException {
		BagEntity bag = bagService.findById(paymentEntity.getBag().getId());
		bag.setStatus(BagStatus.COMPLETED);
		bag.setCreatedAt(LocalDateTime.now());
		
		paymentEntity.setBag(bag);
		paymentEntity.setDate(LocalDateTime.now());
		
		paymentRepository.save(paymentEntity);
		return new PaymentEntityDto(paymentEntity);
	}
	
	//Put
	public PaymentEntityDto update(PaymentEntity paymentEntity) throws PaymentNotFoundException, BagNotFoundException  {
		@SuppressWarnings("unused")
		PaymentEntity payEnti = paymentRepository.findById(paymentEntity.getId()).orElseThrow(
				() -> new PaymentNotFoundException("Forma de pagamento não encontrada, por favor verifique o numero do pedido."));
		
			create(paymentEntity);			
			return new PaymentEntityDto(paymentEntity);
	}
	
	
	//delet
	public ResponseEntity<?> delete(Long id) throws PaymentNotFoundException{
	PaymentEntity payEnti = paymentRepository.findById(id).orElseThrow(
			() -> new PaymentNotFoundException("Forma de pagamento não encontrada, por favor verifique o numero do pedido."));
		paymentRepository.deleteById(payEnti.getId());
		return ResponseEntity.ok().build();
	}
	
}
