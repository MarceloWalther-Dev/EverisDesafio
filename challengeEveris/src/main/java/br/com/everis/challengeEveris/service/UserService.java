package br.com.everis.challengeEveris.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.everis.challengeEveris.dto.UserEntityDto;
import br.com.everis.challengeEveris.dto.details.UserEntityDtoDetail;
import br.com.everis.challengeEveris.entity.UserEntity;
import br.com.everis.challengeEveris.exceptions.ClientNotFoundException;
import br.com.everis.challengeEveris.repository.UserRepository;
@Service
public class UserService {

	@Autowired
	private final UserRepository repository;
	
	
	
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	
	//get
	public List<UserEntityDto> list(){
		return UserEntityDto.convert(repository.findAll());
	}
	
	//getCpf
	public UserEntityDtoDetail findByCpf(String cpf) throws ClientNotFoundException{
		return UserEntityDtoDetail.convertToDto(repository.findByCpf(cpf).orElseThrow(
				() -> new ClientNotFoundException("Cliente não encontrado. Verifique por favor")));
	}
	
	//getAdmin
	public UserEntityDtoDetail userDetail(Long id) throws ClientNotFoundException{
		return UserEntityDtoDetail.convertToDto(repository.findById(id).orElseThrow(
				() -> new ClientNotFoundException("Cliente não encontrado. Verifique por favor")));
	}
	
	//post
	public UserEntityDto save(UserEntity userEntity) {
		repository.save(userEntity);
		return new UserEntityDto(userEntity);
	}
	
	//put
	public UserEntityDto update(UserEntity userEntity) throws ClientNotFoundException {
		UserEntity userBank = repository.findById(userEntity.getId()).orElseThrow(
				() -> new ClientNotFoundException("Cliente não encontrado. Verifique por favor"));
				
		UserEntity userEntiNew = new UserEntity();
		userEntiNew.setId(userBank.getId());
		userEntiNew.setName(userEntity.getName());
		userEntiNew.setAge(userEntity.getAge());
		userEntiNew.setAddress(userEntity.getAddress());
		userEntiNew.setTelephone(userEntity.getTelephone());
		userEntiNew.setEmail(userEntity.getEmail());
		userEntiNew.setCpf(userEntity.getCpf());
		userEntiNew.setPaymentMethods(userEntity.getPaymentMethods());
		
		repository.save(userEntiNew); 
		return new UserEntityDto(userEntiNew);
		}
	
	
	//delete
	public void delete(Long id) throws ClientNotFoundException {
		UserEntity userEn = repository.findById(id).orElseThrow(
				() -> new ClientNotFoundException("Cliente não encontrado. Verifique por favor"));
			repository.deleteById(userEn.getId());
	}

}
