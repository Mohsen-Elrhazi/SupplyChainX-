package ma.project.supplychainx.service.approvisionnement.impl;

import lombok.RequiredArgsConstructor;
import ma.project.supplychainx.dto.approvisionnement.SupplyOrderDTO;
import ma.project.supplychainx.mapper.approvisionnement.SupplyOrderMapper;
import ma.project.supplychainx.model.approvisionnement.SupplyOrder;
import ma.project.supplychainx.repository.approvisionnement.ISupplyOrderRepository;
import ma.project.supplychainx.service.approvisionnement.interfaces.ISupplyOrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplyOrderServiceImpl implements ISupplyOrderService {
    private final ISupplyOrderRepository supplyOrderRepository;
    private final SupplyOrderMapper supplyOrderMapper;
    @Override
    public SupplyOrderDTO create(SupplyOrderDTO dto) {
        SupplyOrder supplyOrder= supplyOrderMapper.toEntity(dto);
        SupplyOrder saved= supplyOrderRepository.save(supplyOrder);
        return supplyOrderMapper.toDTO(saved);
    }

    @Override
    public Page<SupplyOrderDTO> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public SupplyOrderDTO update(Long id, SupplyOrderDTO dto) {
        return null;
    }
}