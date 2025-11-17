package ma.project.supplychainx.service.approvisionnement.interfaces;

import ma.project.supplychainx.dto.approvisionnement.SupplierDTO;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ISupplierService {
    SupplierDTO create(SupplierDTO dto);
    Page<SupplierDTO> getAll(Pageable pageable);
    boolean delete(Long id);
    SupplierDTO update(Long id, SupplierDTO dto);
    SupplierDTO getById(Long id);
    List<SupplierDTO> searchByName(String name);
}
