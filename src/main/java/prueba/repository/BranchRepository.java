package prueba.repository;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import prueba.model.Branch;
import reactor.core.publisher.Flux;

public interface BranchRepository extends ReactiveCrudRepository<Branch, Long> {
    Flux<Branch> findByFranchiseId(Long franchiseId);
}
