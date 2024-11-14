package prueba.controller;

import prueba.model.Product;
import prueba.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Endpoint reactivo para agregar un producto a una sucursal
    @PostMapping("/branch/{branchId}")
    public Mono<Product> addProductToBranch(@PathVariable Long branchId, @RequestBody Product product) {
        return productService.addProductToBranch(branchId, product);
    }

    // Endpoint reactivo para eliminar un producto
    @DeleteMapping("/{productId}")
    public Mono<Void> deleteProduct(@PathVariable Long productId) {
        return productService.deleteProduct(productId);
    }

    // Endpoint reactivo para actualizar el stock de un producto
    @PutMapping("/{productId}")
    public Mono<Product> updateProductStock(@PathVariable Long productId, @RequestParam int stock) {
        return productService.updateProductStock(productId, stock);
    }

    // Endpoint reactivo para actualizar el nombre del producto
    @PutMapping("/{productId}/name")
    public Mono<Product> updateProductName(@PathVariable Long productId, @RequestParam String newName) {
        return productService.updateProductName(productId, newName);
    }

    // Endpoint reactivo para obtener el producto con más stock por sucursal
    @GetMapping("/franchise/{franchiseId}/most-stock")
    public Flux<Product> getProductWithMostStockByFranchise(@PathVariable Long franchiseId) {
        return productService.getProductWithMostStockByFranchise(franchiseId);
    }
}
