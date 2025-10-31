package ma.project.supplychainx.controller.approvisionnement;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.project.supplychainx.dto.ApiResponse;
import ma.project.supplychainx.dto.approvisionnement.SupplierDTO;
import ma.project.supplychainx.model.approvisionnement.Supplier;
import ma.project.supplychainx.service.approvisionnement.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

//    @GetMapping
//    public ResponseEntity<ApiResponse<List<SupplierDTO>>> getAllSuppliers() {
//        try {
//            List<SupplierDTO> suppliers = supplierService.getAll();
//            ApiResponse<List<SupplierDTO>> response = ApiResponse.<List<SupplierDTO>>builder()
//                    .status("success")
//                    .message("Liste des fournisseurs récupérée avec succès")
//                    .data(suppliers)
//                    .build();
//            return ResponseEntity.ok(response);
//        } catch (Exception e) {
//            ApiResponse<List<SupplierDTO>> response = ApiResponse.<List<SupplierDTO>>builder()
//                    .status("error")
//                    .message("Impossible de récupérer la liste : " + e.getMessage())
//                    .data(null)
//                    .build();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
//        }
//    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<SupplierDTO>>> getAllSuppliers(){
//        return supplierService.getAll();
                List<SupplierDTO> suppliersDTO= supplierService.getAll();
                if(suppliersDTO.isEmpty()){
                    return ResponseEntity.ok(
                            ApiResponse.<List<SupplierDTO>>builder()
                                    .status("success")
                                    .message("Aucun suppliers trouvé")
                                    .data(null)
                                    .build()
                    );
                }

                return ResponseEntity.ok(
                        ApiResponse.<List<SupplierDTO>>builder()
                                .status("success")
                                .message("liste des suppliers")
                                .data(suppliersDTO)
                                .build()
                );
    }

    @PostMapping
    public SupplierDTO createSupplier(@Valid @RequestBody SupplierDTO supplierDTO) {
        return supplierService.create(supplierDTO);
    }

    @PutMapping("/{id}")
    public SupplierDTO updateSupplier(@PathVariable long id,@Valid @RequestBody SupplierDTO supplierDTO){
        return supplierService.update(id,supplierDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteSupplier(@PathVariable Long id){
       boolean result=  supplierService.delete(id);
       if(result){
        return "supplier deleted succefly";
       }else{
           return "supplier n'existe pas";
       }
    }
}
