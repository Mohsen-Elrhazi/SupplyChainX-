package ma.project.supplychainx.mapper.approvisionnement;


import ma.project.supplychainx.dto.approvisionnement.RawMaterialDTO;
import ma.project.supplychainx.model.approvisionnement.RawMaterial;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RawMaterialMapper {
    RawMaterialDTO toDTO(RawMaterial rawMaterial);

    RawMaterial toEntity(RawMaterialDTO dto);
}
