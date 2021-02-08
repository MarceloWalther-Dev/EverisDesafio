
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

import br.com.everis.challengeEveris.dto.UserEntityDto;
import br.com.everis.challengeEveris.dto.details.UserEntityDtoDetail;
import br.com.everis.challengeEveris.entity.UserEntity;
import br.com.everis.challengeEveris.exceptions.ClientNotFoundException;
import br.com.everis.challengeEveris.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@GetMapping
	public ResponseEntity<List<UserEntityDto>> list(){
		List<UserEntityDto> userEntiDto = userService.list();
		return ResponseEntity.ok().body(userEntiDto);
	}
	
	@GetMapping("/{cpf}")
	public ResponseEntity<UserEntityDtoDetail> findByCpf(@PathVariable String cpf) throws ClientNotFoundException{
		UserEntityDtoDetail userEnti = userService.findByCpf(cpf);
		return ResponseEntity.ok().body(userEnti);
	}
	
	@GetMapping("/admin/{id}")
	public ResponseEntity<UserEntityDtoDetail> listDetail(@PathVariable Long id) throws ClientNotFoundException{		
		UserEntityDtoDetail userEnti = userService.userDetail(id);
		return ResponseEntity.ok().body(userEnti);
	}
	
	@PostMapping
	public ResponseEntity<UserEntityDto> create(@RequestBody UserEntity userEntity){
		UserEntityDto userEnti = userService.save(userEntity);
		return new ResponseEntity<UserEntityDto>(userEnti, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<UserEntityDto> update(@RequestBody UserEntity userEntity) throws ClientNotFoundException{
		UserEntityDto userEnti = userService.update(userEntity);
		return new ResponseEntity<UserEntityDto>(userEnti, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/admin/{id}")
	public List<UserEntityDto> delete(@PathVariable Long id) throws ClientNotFoundException{
		userService.delete(id);
		return userService.list();
	}
	
	
}
