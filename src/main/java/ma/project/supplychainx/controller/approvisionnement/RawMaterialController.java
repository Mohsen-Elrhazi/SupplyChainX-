package ma.project.supplychainx.controller.approvisionnement;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import ma.project.supplychainx.dto.ApiResponse;
import ma.project.supplychainx.dto.approvisionnement.RawMaterialDTO;
import ma.project.supplychainx.service.approvisionnement.interfaces.IRawMaterialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name="Raw Material",description="API pour gerer les matières premiers")
@RestController
@RequestMapping("/api/raw-materials")
@RequiredArgsConstructor
public class RawMaterialController {
    private  final IRawMaterialService rawMaterialService;


    @GetMapping
    public ResponseEntity<ApiResponse<List<RawMaterialDTO>>> getAllSuppliers(){
        List<RawMaterialDTO> rawMaterialDTOS= rawMaterialService.getAll();
        if(rawMaterialDTOS.isEmpty()){
            return ResponseEntity.ok(
                    ApiResponse.<List<RawMaterialDTO>>builder()
                            .status("success")
                            .message("Aucun raw material trouvé")
                            .data(null)
                            .build()
            );
        }

        return ResponseEntity.ok(
                ApiResponse.<List<RawMaterialDTO>>builder()
                        .status("success")
                        .message("liste des raw materials")
                        .data(rawMaterialDTOS)
                        .build()
        );
    }


    @PostMapping
    public ResponseEntity<ApiResponse<RawMaterialDTO>> createRawMaterial(@RequestBody RawMaterialDTO dto){
        RawMaterialDTO created= rawMaterialService.create(dto);

        return ResponseEntity.ok(
                ApiResponse.<RawMaterialDTO>builder()
                        .status("success")
                        .message("Raw Material a ete crée")
                        .data(created)
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteRawMaterial(@PathVariable Long id){
        boolean result=  rawMaterialService.delete(id);
        if(result){
            return ResponseEntity.status(HttpStatus.OK).body(
                    ApiResponse.<Void>builder()
                            .status("success")
                            .message("RawMaterial a ete supprimer")
                            .data(null)
                            .build()
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    ApiResponse.<Void>builder()
                            .status("error")
                            .message("RawMaterial introuvable")
                            .data(null)
                            .build()
            );
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<RawMaterialDTO>> updateRawMaterial(@PathVariable Long id, @RequestBody RawMaterialDTO dto){
        Optional<RawMaterialDTO> updatedDTO= rawMaterialService.update(id, dto);

        if(updatedDTO.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<RawMaterialDTO>builder()
                        .status("success")
                        .message("RawMaterial a ete modifie")
                        .data(updatedDTO.get())
                        .build()
            );
        }
        return null;
    }
}
