package br.com.everis.challengeEveris.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.everis.challengeEveris.entity.AddressEntity;


public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

}
