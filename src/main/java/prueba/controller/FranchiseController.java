package prueba.controller;

import prueba.model.Franchise;
import prueba.service.FranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/franchises")
public class FranchiseController {

    @Autowired
    private FranchiseService franchiseService;

    // Endpoint reactivo para agregar una nueva franquicia
    @PostMapping
    public Mono<Franchise> addFranchise(@RequestBody Franchise franchise) {
        return franchiseService.addFranchise(franchise);
    }

    // Endpoint reactivo para actualizar el nombre de la franquicia
    @PutMapping("/{franchiseId}")
    public Mono<Franchise> updateFranchiseName(@PathVariable Long franchiseId, @RequestParam String newName) {
        return franchiseService.updateFranchiseName(franchiseId, newName);
    }
}
