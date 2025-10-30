package ma.project.supplychainx.dto.approvisionnement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplierDTO {

    private Long idSupplier;

    private String name;

    private String contact;

    private Double rating;

    private int leadTime;
}
