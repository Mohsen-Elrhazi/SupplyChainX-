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

    private Integer stock;

    private Integer stockMin;

    private String unit;


    @ManyToMany(mappedBy = "rawMaterials")
    private List<Supplier> suppliers;

    @ManyToMany(mappedBy = "orderedRawMaterials")
    private List<SupplyOrder> supplyOrders;


}
