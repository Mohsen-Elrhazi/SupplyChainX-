package ma.project.supplychainx.repository.approvisionnement;

import ma.project.supplychainx.dto.approvisionnement.RawMaterialDTO;
import ma.project.supplychainx.model.approvisionnement.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRawMaterialRepository extends JpaRepository<RawMaterial, Long> {
    @Query("SELECT r FROM RawMaterial r WHERE r.stock < r.stockMin")
    List<RawMaterial> findByStockLessThanStockMin();

}
