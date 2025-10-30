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
public class RawMaterial {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idRawMaterial;

    private String name;

    private int stock;

    private int stockMin;

    private String unit;

    @ManyToMany
    @JoinTable(
            name = "material_supplier",
            joinColumns = @JoinColumn(name = "material_id"),
            inverseJoinColumns = @JoinColumn(name = "supplier_id")
    )
    private List<Supplier> suppliers;

    @ManyToMany(mappedBy = "materials")
    private List<SupplyOrder> supplyOrders;
}
