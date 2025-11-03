package ma.project.supplychainx.service.approvisionnement.interfaces;

import ma.project.supplychainx.dto.approvisionnement.SupplierDTO;

import java.util.List;

public interface ISupplierService {
    SupplierDTO create(SupplierDTO dto);
    List<SupplierDTO> getAll();
    boolean delete(Long id);
    SupplierDTO update(Long id, SupplierDTO dto);
    SupplierDTO getById(Long id);
    List<SupplierDTO> searchByName(String name);
}
