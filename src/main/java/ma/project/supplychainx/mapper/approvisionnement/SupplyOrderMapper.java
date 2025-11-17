package ma.project.supplychainx.mapper.approvisionnement;

import ma.project.supplychainx.dto.approvisionnement.SupplyOrderDTO;
import ma.project.supplychainx.model.approvisionnement.SupplyOrder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplyOrderMapper {
    SupplyOrderDTO toDTO(SupplyOrder supplyOrder);
    SupplyOrder toEntity(SupplyOrderDTO dto);
}