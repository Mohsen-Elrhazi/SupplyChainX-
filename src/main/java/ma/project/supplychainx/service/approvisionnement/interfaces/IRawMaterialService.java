package ma.project.supplychainx.service.approvisionnement.interfaces;

import ma.project.supplychainx.dto.approvisionnement.RawMaterialDTO;
import ma.project.supplychainx.model.approvisionnement.RawMaterial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IRawMaterialService {
    RawMaterialDTO create(RawMaterialDTO dto);
    Page<RawMaterialDTO> getAll(Pageable pageable);
    boolean delete(Long id);
    Optional<RawMaterialDTO> update(Long id, RawMaterialDTO dto);
    List<RawMaterialDTO> getLowStockMaterials();
}
