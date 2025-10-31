package ma.project.supplychainx.mapper.approvisionnement;

import ma.project.supplychainx.dto.approvisionnement.SupplierDTO;
import ma.project.supplychainx.model.approvisionnement.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
//    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);

//    @Mapping(source="idSupplier", target="idSupplier")
    SupplierDTO toDTO(Supplier supplier);

//    @Mapping(source="idSupplier", target="idSupplier")
    Supplier toEntity(SupplierDTO dto);
}
