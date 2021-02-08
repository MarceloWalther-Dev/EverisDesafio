package br.com.everis.challengeEveris.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.everis.challengeEveris.dto.ProductEntityDto;
import br.com.everis.challengeEveris.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	List<ProductEntityDto> findAllByOrderByPriceAsc();
}
