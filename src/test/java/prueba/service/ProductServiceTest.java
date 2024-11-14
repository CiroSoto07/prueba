package prueba.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import prueba.model.Product;
import prueba.repository.ProductRepository;
import reactor.core.publisher.Mono;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
    }

    @Test
    void addProductToBranchTest() {
        when(productRepository.save(product)).thenReturn(Mono.just(product));

        Mono<Product> result = productService.addProductToBranch(1L, product);

        assertNotNull(result);
    }

    @Test
    void deleteProductTest() {
        when(productRepository.deleteById(1L)).thenReturn(Mono.empty());

        Mono<Void> result = productService.deleteProduct(1L);

        assertNotNull(result);
        assertEquals(Mono.empty(), result);
    }

    @Test
    void updateProductStockTest() {
        int newStock = 20;
        when(productRepository.findById(1L)).thenReturn(Mono.just(product));
        when(productRepository.save(product)).thenReturn(Mono.just(product));

        Mono<Product> result = productService.updateProductStock(1L, newStock);

        assertNotNull(result);
        assertEquals(newStock, result.block().getStock());
    }

    @Test
    void updateProductNameTest() {
        String newName = "UpdatedProduct";
        when(productRepository.findById(1L)).thenReturn(Mono.just(product));
        when(productRepository.save(product)).thenReturn(Mono.just(product));

        Mono<Product> result = productService.updateProductName(1L, newName);

        assertNotNull(result);
        assertEquals(newName, result.block().getName());
    }
}
