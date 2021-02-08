/**
 * 
 */
package br.com.everis.challengeEveris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.everis.challengeEveris.entity.ItemEntity;

/**
 * @author mwalther
 *
 */
@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

}
