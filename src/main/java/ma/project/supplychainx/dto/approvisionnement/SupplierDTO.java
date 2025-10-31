package ma.project.supplychainx.dto.approvisionnement;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplierDTO {

//    private Long idSupplier;

    @NotBlank(message = "Le nom est obligatoire")
    private String name;

    @NotBlank(message = "Le contact est obligatoire")
    private String contact;

    @NotNull(message = "rating est obligatoire")
    private Double rating;

    @Min(value = 1, message = "Le délai doit être au moins de 1 jour")
    @Max(value = 60, message = "Le délai ne doit pas dépasser 60 jours")
    private int leadTime;
}
