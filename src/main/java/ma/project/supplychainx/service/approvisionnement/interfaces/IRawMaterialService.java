package ma.project.supplychainx.service.approvisionnement.interfaces;

import ma.project.supplychainx.dto.approvisionnement.RawMaterialDTO;

import java.util.List;
import java.util.Optional;

public interface IRawMaterialService {
    RawMaterialDTO create(RawMaterialDTO dto);
    List<RawMaterialDTO> getAll();
    boolean delete(Long id);
    Optional<RawMaterialDTO> update(Long id, RawMaterialDTO dto);
    Optional<RawMaterialDTO> getById(Long id);

}
