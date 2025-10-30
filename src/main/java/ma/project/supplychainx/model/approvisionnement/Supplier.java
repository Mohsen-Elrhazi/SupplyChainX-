package ma.project.supplychainx.model.approvisionnement;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Supplier {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idSupplier;

    private String name;

    private String contact;

    private Double rating;

    private int leadTime;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    private List<SupplyOrder> orders;

    @ManyToMany(mappedBy = "suppliers")
    private List<RawMaterial> rawMaterials;
}
