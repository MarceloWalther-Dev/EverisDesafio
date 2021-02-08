package br.com.everis.challengeEveris.dto.details;

import java.util.List;
import java.util.stream.Collectors;

import br.com.everis.challengeEveris.entity.AddressEntity;
import br.com.everis.challengeEveris.entity.UserEntity;
import br.com.everis.challengeEveris.enuns.PaymentMethods;

public class UserEntityDtoDetail {

	private Long id;
	private String name;
	private Integer age;
	private List<AddressEntity> addressEntity;
	private String telephone;
	private String cpf;
	private String email;
	private PaymentMethods paymentMethods;
	
	public UserEntityDtoDetail(UserEntity userEntity) {
		this.id = userEntity.getId();
		this.name = userEntity.getName();
		this.age = userEntity.getAge();
		this.addressEntity = userEntity.getAddress();
		this.telephone = userEntity.getTelephone();
		this.cpf = userEntity.getCpf();
		this.email = userEntity.getEmail();
		this.paymentMethods = userEntity.getPaymentMethods();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	
	public static List<UserEntityDtoDetail> convert(List<UserEntity> users) {
		return users.stream().map(UserEntityDtoDetail ::new).collect(Collectors.toList());
	}
	
	public static UserEntityDtoDetail convertToDto(UserEntity users) {
		return new UserEntityDtoDetail(users);
	}
}
