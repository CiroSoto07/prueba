package prueba.service;

import prueba.model.Product;
import prueba.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Método reactivo para agregar producto a una sucursal
    public Mono<Product> addProductToBranch(Long branchId, Product product) {
        product.setBranchId(branchId);
        return productRepository.save(product);
    }

    // Método reactivo para eliminar un producto
    public Mono<Void> deleteProduct(Long productId) {
        return productRepository.deleteById(productId);
    }

    // Método reactivo para actualizar el stock de un producto
    public Mono<Product> updateProductStock(Long productId, int stock) {
        return productRepository.findById(productId)
                .flatMap(product -> {
                    product.setStock(stock);
                    return productRepository.save(product);
                });
    }

    // Método reactivo para actualizar el nombre de un producto
    public Mono<Product> updateProductName(Long productId, String newName) {
        return productRepository.findById(productId)
                .flatMap(product -> {
                    product.setName(newName);
                    return productRepository.save(product);
                });
    }

    // Método reactivo para obtener el producto con más stock por sucursal de una franquicia
    public Flux<Product> getProductWithMostStockByFranchise(Long franchiseId) {
        return productRepository.findByBranchId(franchiseId)
                .collectList()
                .flatMapMany(products -> Flux.fromIterable(products.stream()
                        .max((p1, p2) -> Integer.compare(p1.getStock(), p2.getStock()))
                        .stream()
                        .collect(Collectors.toList())));
    }
}
