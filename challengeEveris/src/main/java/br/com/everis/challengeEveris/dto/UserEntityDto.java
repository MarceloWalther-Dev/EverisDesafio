package br.com.everis.challengeEveris.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;

import br.com.everis.challengeEveris.entity.AddressEntity;
import br.com.everis.challengeEveris.entity.UserEntity;
import br.com.everis.challengeEveris.enuns.PaymentMethods;

public class UserEntityDto {

	private String name;
	private Integer age;
	private List<AddressEntity> addressEntity;
	private String telephone;
	private String email;
	private PaymentMethods paymentMethods;

	public UserEntityDto() {
	}

	public UserEntityDto(UserEntity userEntity) {
		this.name = userEntity.getName();
		this.age = userEntity.getAge();
		this.addressEntity = userEntity.getAddress();
		this.telephone = userEntity.getTelephone();
		this.email = userEntity.getEmail();
		this.paymentMethods = userEntity.getPaymentMethods();
	}

	public UserEntityDto(UserEntityDto create) {
	}

	public UserEntityDto(UserEntity save, HttpStatus created) {
	}

	public UserEntityDto(List<UserEntity> findAll) {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<AddressEntity> getAddressEntity() {
		return addressEntity;
	}

	public void setAddressEntity(List<AddressEntity> addressEntity) {
		this.addressEntity = addressEntity;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PaymentMethods getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(PaymentMethods paymentMethods) {
		this.paymentMethods = paymentMethods;
	}
	
	public static List<UserEntityDto> convert(List<UserEntity> users) {
		return users.stream().map(UserEntityDto ::new).collect(Collectors.toList());
	}

	public UserEntityDto convertToDto(UserEntity users) {
		return new UserEntityDto(users);
	}
}
