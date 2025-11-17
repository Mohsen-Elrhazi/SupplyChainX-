package ma.project.supplychainx.dto.approvisionnement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.project.supplychainx.enums.SupplyOrderStatus;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplyOrderDTO {
    private Long idSupplyOrder;

    private LocalDate orderDate;

    private SupplyOrderStatus status;
}
