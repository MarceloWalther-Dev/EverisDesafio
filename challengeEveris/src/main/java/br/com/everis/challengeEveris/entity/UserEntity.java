package br.com.everis.challengeEveris.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.everis.challengeEveris.enuns.PaymentMethods;

@Entity
@Table(name = "users")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private Integer age;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE }, orphanRemoval = true)
	@JoinColumn(name = "users_id")
	private List<AddressEntity> addressEntity;

	@Column(name = "telephone")
	private String telephone;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "email")
	private String email;

	@Enumerated(EnumType.STRING)
	private PaymentMethods paymentMethods;

	public UserEntity() {
	};

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressEntity == null) ? 0 : addressEntity.hashCode());
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((paymentMethods == null) ? 0 : paymentMethods.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		if (addressEntity == null) {
			if (other.addressEntity != null)
				return false;
		} else if (!addressEntity.equals(other.addressEntity))
			return false;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (paymentMethods != other.paymentMethods)
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
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

	public List<AddressEntity> getAddress() {
		return addressEntity;
	}

	public void setAddress(List<AddressEntity> addressEntity) {
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

	public PaymentMethods getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(PaymentMethods paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Users [name=" + name + ", age=" + age + ", address=" + addressEntity + ", telephone=" + telephone
				+ ", cpf=" + cpf + ", paymentMethods=" + paymentMethods + "]";
	}

}
