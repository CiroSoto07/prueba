package prueba.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.util.List;

@Data
@Table("franchises")
public class Franchise {
    @Id
    private Long id;

    private String name;

    private List<Branch> branches;
}
