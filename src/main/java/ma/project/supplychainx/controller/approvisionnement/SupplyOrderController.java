package ma.project.supplychainx.controller.approvisionnement;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import ma.project.supplychainx.dto.ApiResponse;
import ma.project.supplychainx.dto.approvisionnement.RawMaterialDTO;
import ma.project.supplychainx.dto.approvisionnement.SupplyOrderDTO;
import ma.project.supplychainx.service.approvisionnement.impl.SupplyOrderServiceImpl;
import ma.project.supplychainx.service.approvisionnement.interfaces.ISupplyOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="SupplyOrder",description="API pour gerer les supplyOrders")
@RestController
@RequestMapping("/api/Supply-orders")
@RequiredArgsConstructor
public class SupplyOrderController {
    private final ISupplyOrderService supplyOrderService;

    @PostMapping
    public ResponseEntity<ApiResponse<SupplyOrderDTO>> createSupplyOder(@RequestBody SupplyOrderDTO dto){
        SupplyOrderDTO created= supplyOrderService.create(dto);

        return ResponseEntity.ok(
                ApiResponse.<SupplyOrderDTO>builder()
                        .status("success")
                        .message("SupplyOrder  a ete crée")
                        .data(created)
                        .build()
        );
    }


}
