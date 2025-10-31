package ma.project.supplychainx.mapper.approvisionnement;

import ma.project.supplychainx.dto.approvisionnement.SupplierDTO;
import ma.project.supplychainx.model.approvisionnement.Supplier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
//    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);

    SupplierDTO toDTO(Supplier supplier);
    Supplier toEntity(SupplierDTO dto);
}
