package ma.project.supplychainx.service.approvisionnement.interfaces;

import ma.project.supplychainx.dto.approvisionnement.SupplyOrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISupplyOrderService {
    SupplyOrderDTO create(SupplyOrderDTO dto);
    Page<SupplyOrderDTO> getAll(Pageable pageable);
    boolean delete(Long id);
    SupplyOrderDTO update(Long id, SupplyOrderDTO dto);
}
