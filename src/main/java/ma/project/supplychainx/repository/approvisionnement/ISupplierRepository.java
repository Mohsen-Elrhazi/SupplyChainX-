package ma.project.supplychainx.repository.approvisionnement;

import ma.project.supplychainx.model.approvisionnement.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISupplierRepository extends JpaRepository<Supplier, Long> {
}
