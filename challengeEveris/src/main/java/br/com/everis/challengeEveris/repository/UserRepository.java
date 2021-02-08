package br.com.everis.challengeEveris.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.everis.challengeEveris.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	Optional<UserEntity> findByCpf(String cpf);
}
