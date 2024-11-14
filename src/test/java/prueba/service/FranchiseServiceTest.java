package prueba.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import prueba.model.Franchise;
import prueba.repository.FranchiseRepository;
import reactor.core.publisher.Mono;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FranchiseServiceTest {

    @Mock
    private FranchiseRepository franchiseRepository;

    @InjectMocks
    private FranchiseService franchiseService;

    private Franchise franchise;

    @BeforeEach
    void setUp() {
        franchise = new Franchise();
    }

    @Test
    void addFranchiseTest() {
        when(franchiseRepository.save(franchise)).thenReturn(Mono.just(franchise));

        Mono<Franchise> result = franchiseService.addFranchise(franchise);

        assertNotNull(result);
    }

    @Test
    void updateFranchiseNameTest() {
        String newName = "UpdatedFranchise";
        when(franchiseRepository.findById(1L)).thenReturn(Mono.just(franchise));
        when(franchiseRepository.save(franchise)).thenReturn(Mono.just(franchise));

        Mono<Franchise> result = franchiseService.updateFranchiseName(1L, newName);

        assertNotNull(result);
        assertEquals(newName, result.block().getName());
    }
}
