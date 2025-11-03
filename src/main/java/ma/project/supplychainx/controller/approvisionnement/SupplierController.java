package ma.project.supplychainx.controller.approvisionnement;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.project.supplychainx.dto.ApiResponse;
import ma.project.supplychainx.dto.approvisionnement.SupplierDTO;
import ma.project.supplychainx.service.approvisionnement.impl.SupplierServiceImpl;
import ma.project.supplychainx.service.approvisionnement.interfaces.ISupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Suppliers",description="API pour gerer les fournisseurs")
@RestController
@RequestMapping("/api/suppliers")
@RequiredArgsConstructor
public class SupplierController {
    private final ISupplierService supplierService;


    @GetMapping
    public ResponseEntity<ApiResponse<List<SupplierDTO>>> getAllSuppliers(){
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
    public ResponseEntity<ApiResponse<SupplierDTO>> createSupplier(@Valid @RequestBody SupplierDTO supplierDTO) {
          SupplierDTO createdDTO= supplierService.create(supplierDTO);

          return ResponseEntity.status(HttpStatus.CREATED).body(
                  ApiResponse.<SupplierDTO>builder()
                          .status("success")
                          .message("Supplier a ete crée")
                          .data(createdDTO)
                          .build()
          );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SupplierDTO>> updateSupplier(@PathVariable long id,@Valid @RequestBody SupplierDTO supplierDTO){
         SupplierDTO updatedDTO= supplierService.update(id,supplierDTO);

         return ResponseEntity.status(HttpStatus.OK).body(
                 ApiResponse.<SupplierDTO>builder()
                         .status("success")
                         .message("supplier a ete modifier ")
                         .data(updatedDTO)
                         .build()
         );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSupplier(@PathVariable Long id){
       boolean result=  supplierService.delete(id);
       if(result){
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<Void>builder()
                        .status("success")
                        .message("supplier a ete supprimer")
                        .data(null)
                        .build()
        );
       }else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                   ApiResponse.<Void>builder()
                           .status("error")
                           .message("supplier introuvable")
                           .data(null)
                           .build()
           );
       }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SupplierDTO>> getSupplierById(@PathVariable Long id){
        SupplierDTO supplierDTO= supplierService.getById(id);
        if(supplierDTO==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    ApiResponse.<SupplierDTO>builder()
                    .status("error")
                    .message("supplier introuvable")
                    .data(null)
                    .build()
            );
        }else{
            return ResponseEntity.ok(
                    ApiResponse.<SupplierDTO>builder()
                            .status("success")
                            .message("supplier trouve avec success")
                            .data(supplierDTO)
                            .build()
            );
        }

    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<SupplierDTO>>> searchSupplierByName(@RequestParam String name){
        List<SupplierDTO> suppliersDTO= supplierService.searchByName(name);
        if(suppliersDTO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ApiResponse.<List<SupplierDTO>>builder()
                        .status("success")
                        .message("aucun supplier trouve par ce nom")
                        .data(null)
                .build()
            );
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(
                    ApiResponse.<List<SupplierDTO>>builder()
                            .status("success")
                            .message("liste des suppliers ")
                            .data(suppliersDTO)
                            .build()
            );
        }

    }
}
