package prueba.controller;

import prueba.model.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import prueba.service.BranchService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/branches")
public class BranchController {

    @Autowired
    private BranchService branchService;

    // Endpoint reactivo para agregar una sucursal a una franquicia
    @PostMapping("/franchise/{franchiseId}")
    public Mono<Branch> addBranchToFranchise(@PathVariable Long franchiseId, @RequestBody Branch branch) {
        return branchService.addBranchToFranchise(franchiseId, branch);
    }

    // Endpoint reactivo para actualizar el nombre de la sucursal
    @PutMapping("/{branchId}")
    public Mono<Branch> updateBranchName(@PathVariable Long branchId, @RequestParam String newName) {
        return branchService.updateBranchName(branchId, newName);
    }
}
