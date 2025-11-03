package ma.project.supplychainx.repository.approvisionnement;

import ma.project.supplychainx.model.approvisionnement.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRawMaterialRepository extends JpaRepository<RawMaterial, Long> {
}
