/**
 * 
 */
package br.com.everis.challengeEveris.controller;

import java.util.List;

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

import br.com.everis.challengeEveris.dto.PaymentEntityDto;
import br.com.everis.challengeEveris.entity.PaymentEntity;
import br.com.everis.challengeEveris.exceptions.BagNotFoundException;
import br.com.everis.challengeEveris.exceptions.PaymentNotFoundException;
import br.com.everis.challengeEveris.service.PaymentService;

/**
 * @author mwalther
 *
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

	private final PaymentService paymentService;
	
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	
	@GetMapping
	public List<PaymentEntityDto> list(){
		return paymentService.list();
	}
	
	@PostMapping
	public ResponseEntity<PaymentEntityDto> create(@RequestBody PaymentEntity paymentEntity) throws BagNotFoundException{
		PaymentEntityDto payEntiDto = paymentService.create(paymentEntity);
		return new ResponseEntity<PaymentEntityDto>(payEntiDto, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<PaymentEntityDto> update(@RequestBody PaymentEntity paymentEntity) throws PaymentNotFoundException, BagNotFoundException{
		PaymentEntityDto payEntiDto = paymentService.update(paymentEntity);
		return new ResponseEntity<PaymentEntityDto>(payEntiDto,HttpStatus.OK);
	}
	
	@DeleteMapping("/admin/{id}")
	public void delete(@PathVariable Long id) throws PaymentNotFoundException {
		paymentService.delete(id);
	}
}
