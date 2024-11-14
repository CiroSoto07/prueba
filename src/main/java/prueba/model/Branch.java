package prueba.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.util.List;

@Data
@Table("branches")
public class Branch {
    @Id
    private Long id;

    private String name;

    private Long franchiseId;

    private List<Product> products;
}
