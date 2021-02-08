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

import br.com.everis.challengeEveris.dto.BagEntityDto;
import br.com.everis.challengeEveris.exceptions.BagNotFoundException;
import br.com.everis.challengeEveris.exceptions.ClientNotFoundException;
import br.com.everis.challengeEveris.forms.FormBagDto;
import br.com.everis.challengeEveris.service.BagService;

/**
 * @author mwalther
 *
 */
@RestController
@RequestMapping("/bag")
public class BagController {

	private final BagService bagService;
	
	public BagController(BagService bagService) {
		this.bagService = bagService;
	}
	
	@GetMapping
	public ResponseEntity<List<BagEntityDto>> list(){
		List<BagEntityDto> bagEntityDto = bagService.list();
		return ResponseEntity.ok().body(bagEntityDto);
	}
	
	@PostMapping
	public ResponseEntity<BagEntityDto> create(@RequestBody FormBagDto formBagDto) throws ClientNotFoundException{
		BagEntityDto bagEntiDto = bagService.create(formBagDto);
		return new ResponseEntity<BagEntityDto>(bagEntiDto, HttpStatus.CREATED);
	}
	
	
	@PutMapping
	public ResponseEntity<BagEntityDto> update(@RequestBody FormBagDto formBagDto) throws BagNotFoundException, ClientNotFoundException{
		BagEntityDto bagEntiDto = bagService.update(formBagDto);
		return new ResponseEntity<BagEntityDto>(bagEntiDto, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/admin/{id}")
	public List<BagEntityDto> delete(@PathVariable Long id) throws BagNotFoundException{
		bagService.delete(id);
		return bagService.list();
	}
}
