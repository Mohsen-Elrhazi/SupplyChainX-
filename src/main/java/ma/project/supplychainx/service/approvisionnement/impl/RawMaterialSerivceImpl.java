package ma.project.supplychainx.service.approvisionnement.impl;

import lombok.RequiredArgsConstructor;
import ma.project.supplychainx.dto.approvisionnement.RawMaterialDTO;
import ma.project.supplychainx.mapper.approvisionnement.RawMaterialMapper;
import ma.project.supplychainx.model.approvisionnement.RawMaterial;
import ma.project.supplychainx.repository.approvisionnement.IRawMaterialRepository;
import ma.project.supplychainx.service.approvisionnement.interfaces.IRawMaterialService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class RawMaterialSerivceImpl implements IRawMaterialService {
    private final IRawMaterialRepository rawMaterialRepository;
    private final RawMaterialMapper rawMaterialMapper;

    @Override
    public RawMaterialDTO create(RawMaterialDTO dto) {
        RawMaterial rawMaterial= rawMaterialMapper.toEntity(dto);
        RawMaterial saved= rawMaterialRepository.save(rawMaterial);
        return rawMaterialMapper.toDTO(saved);    }

    @Override
    public Page<RawMaterialDTO> getAll(Pageable pageable) {
        return rawMaterialRepository.findAll(pageable)
                .map(rawMaterialMapper::toDTO);
    }

    @Override
    public boolean delete(Long id) {
        if(rawMaterialRepository.existsById(id)){
            rawMaterialRepository.deleteById(id);
            return true;
        }else{
            return false;
        }    }

    @Override
    public Optional<RawMaterialDTO>  update(Long id, RawMaterialDTO dto) {
        Optional<RawMaterial> existingRawMaterial= rawMaterialRepository.findById(id);

        if(existingRawMaterial.isPresent()){
            RawMaterial rawMaterial= existingRawMaterial.get();
            rawMaterial.setName(dto.getName());
            rawMaterial.setStock(dto.getStock());
            rawMaterial.setStockMin(dto.getStockMin());
            rawMaterial.setUnit(dto.getUnit());

            RawMaterial updated= rawMaterialRepository.save(rawMaterial);

            return Optional.of(rawMaterialMapper.toDTO(updated));
        }else{
            return Optional.empty();
        }
    }

    @Override
    public List<RawMaterialDTO> getLowStockMaterials() {
        return rawMaterialRepository.findByStockLessThanStockMin()
                .stream()
                .map(rawMaterialMapper::toDTO)
                .toList();
    }

}
