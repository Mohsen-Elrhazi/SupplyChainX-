package ma.project.supplychainx.model.approvisionnement;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.project.supplychainx.enums.SupplyOrderStatus;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplyOrder {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idSupplyOrder;

    private LocalDate orderDate;

    @Enumerated(EnumType.STRING)
    private SupplyOrderStatus status;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToMany
    @JoinTable(
            name = "order_material",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "material_id")
    )
    private List<RawMaterial> materials;
}
