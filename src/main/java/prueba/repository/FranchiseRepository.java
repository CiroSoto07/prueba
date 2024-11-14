package prueba.repository;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import prueba.model.Franchise;
import reactor.core.publisher.Mono;

public interface FranchiseRepository extends ReactiveCrudRepository<Franchise, Long> {
    Mono<Franchise> findById(Long id);
}
