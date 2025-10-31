package ma.project.supplychainx.service.approvisionnement;

import lombok.RequiredArgsConstructor;
import ma.project.supplychainx.dto.approvisionnement.SupplierDTO;
import ma.project.supplychainx.mapper.approvisionnement.SupplierMapper;
import ma.project.supplychainx.model.approvisionnement.Supplier;
import ma.project.supplychainx.repository.approvisionnement.ISupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupplierService {
    private final ISupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    public List<SupplierDTO> getAll() {
        return supplierRepository.findAll()
                .stream()
                .map(supplierMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SupplierDTO create(SupplierDTO dto) {
        Supplier supplier = supplierMapper.toEntity(dto);
        Supplier saved = supplierRepository.save(supplier);
        return supplierMapper.toDTO(saved);
    }

    public boolean delete(Long id){
        if(supplierRepository.existsById(id)){
           supplierRepository.deleteById(id);
           return true;
        }
        return false;
    }
}
