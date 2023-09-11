package fr.jbogart.fizzbuzz.generic;

import fr.jbogart.fizzbuzz.domain.FizzbuzzEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FizzbuzzRepository extends JpaRepository<FizzbuzzEntity, Long> {

    Optional<FizzbuzzEntity> findByRequest(String request);

    Optional<FizzbuzzEntity> findFirstByOrderByCounterDesc();

}
