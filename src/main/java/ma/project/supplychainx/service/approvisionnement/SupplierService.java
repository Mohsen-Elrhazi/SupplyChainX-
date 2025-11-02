package ma.project.supplychainx.service.approvisionnement;

import lombok.RequiredArgsConstructor;
import ma.project.supplychainx.dto.approvisionnement.SupplierDTO;
import ma.project.supplychainx.mapper.approvisionnement.SupplierMapper;
import ma.project.supplychainx.model.approvisionnement.Supplier;
import ma.project.supplychainx.repository.approvisionnement.ISupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
                .toList();
    }

    public SupplierDTO create(SupplierDTO dto) {
        Supplier supplier = supplierMapper.toEntity(dto);
        Supplier saved = supplierRepository.save(supplier);
        return supplierMapper.toDTO(saved);
    }

    public SupplierDTO update(Long id, SupplierDTO dto){
        Optional<Supplier> existingSupplier= supplierRepository.findById(id);

        if(existingSupplier.isPresent()){
            Supplier supplier= existingSupplier.get();
            supplier.setName(dto.getName());
            supplier.setContact(dto.getContact());
            supplier.setRating(dto.getRating());
            supplier.setLeadTime(dto.getLeadTime());

            Supplier updated= supplierRepository.save(supplier);

            return supplierMapper.toDTO(updated);
        }else{
          throw new RuntimeException("supplier non trouve");
        }
    }

    public boolean delete(Long id){
        if(supplierRepository.existsById(id)){
           supplierRepository.deleteById(id);
           return true;
        }else{
            return false;
        }
    }

    public SupplierDTO getById(Long id){
        return supplierRepository.findById(id)
                .map(supplierMapper::toDTO)
                .orElse(null);
    }

    public List<SupplierDTO> searchByName(String name){
        return supplierRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(supplierMapper::toDTO)
                .toList();
    }
}
