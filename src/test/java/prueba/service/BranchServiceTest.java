package prueba.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import prueba.model.Branch;
import prueba.repository.BranchRepository;
import reactor.core.publisher.Mono;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BranchServiceTest {

    @Mock
    private BranchRepository branchRepository;

    @InjectMocks
    private BranchService branchService;

    private Branch branch;

    @BeforeEach
    void setUp() {
        branch = new Branch();
    }

    @Test
    void addBranchTest() {
        when(branchRepository.save(branch)).thenReturn(Mono.just(branch));

        Mono<Branch> result = branchService.addBranchToFranchise(1L, branch);

        assertNotNull(result);
    }



    @Test
    void updateBranchNameTest() {
        String newName = "UpdatedBranch";
        when(branchRepository.findById(1L)).thenReturn(Mono.just(branch));
        when(branchRepository.save(branch)).thenReturn(Mono.just(branch));

        Mono<Branch> result = branchService.updateBranchName(1L, newName);

        assertNotNull(result);
        assertEquals(newName, result.block().getName());
    }
}
