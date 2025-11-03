package ma.project.supplychainx.dto.approvisionnement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RawMaterialDTO {
    private Long idRawMaterial;

    private String name;

    private Integer stock;

    private Integer stockMin;

    private String unit;}
