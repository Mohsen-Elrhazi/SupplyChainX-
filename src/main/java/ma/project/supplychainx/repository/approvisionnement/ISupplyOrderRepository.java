package ma.project.supplychainx.repository.approvisionnement;

import ma.project.supplychainx.model.approvisionnement.SupplyOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISupplyOrderRepository extends JpaRepository<SupplyOrder, Long> {
}
