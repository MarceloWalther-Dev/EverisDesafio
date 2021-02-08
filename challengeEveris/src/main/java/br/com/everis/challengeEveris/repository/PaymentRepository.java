/**
 * 
 */
package br.com.everis.challengeEveris.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.everis.challengeEveris.entity.PaymentEntity;

/**
 * @author mwalther
 *
 */
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

}
