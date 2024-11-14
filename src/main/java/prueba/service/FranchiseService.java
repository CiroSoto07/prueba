package prueba.service;

import prueba.model.Franchise;
import prueba.repository.FranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FranchiseService {

    @Autowired
    private FranchiseRepository franchiseRepository;

    // Método reactivo para agregar franquicia
    public Mono<Franchise> addFranchise(Franchise franchise) {
        return franchiseRepository.save(franchise);
    }

    // Método reactivo para actualizar el nombre de la franquicia
    public Mono<Franchise> updateFranchiseName(Long franchiseId, String newName) {
        return franchiseRepository.findById(franchiseId)
                .flatMap(franchise -> {
                    franchise.setName(newName);
                    return franchiseRepository.save(franchise);
                });
    }
}
