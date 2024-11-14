package prueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.model.Branch;
import prueba.repository.BranchRepository;
import reactor.core.publisher.Mono;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    // Método reactivo para agregar sucursal a una franquicia
    public Mono<Branch> addBranchToFranchise(Long franchiseId, Branch branch) {
        branch.setFranchiseId(franchiseId);
        return branchRepository.save(branch);
    }

    // Método reactivo para actualizar el nombre de la sucursal
    public Mono<Branch> updateBranchName(Long branchId, String newName) {
        return branchRepository.findById(branchId)
                .flatMap(branch -> {
                    branch.setName(newName);
                    return branchRepository.save(branch);
                });
    }
}
