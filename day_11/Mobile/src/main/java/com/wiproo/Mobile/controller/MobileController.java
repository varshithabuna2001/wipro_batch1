package com.wiproo.Mobile.controller;

import com.wiproo.Mobile.dto.*;
import com.wiproo.Mobile.service.MobileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mobile")
public class MobileController {

    private final MobileService service;

    public MobileController(MobileService service) {
        this.service = service;
    }

    
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Mobile dto) {
        if (dto == null || dto.getModelNumber() == null || dto.getModelNumber().isBlank()) {
            return ResponseEntity.badRequest().body("modelNumber is required");
        }
      
        Mobile created = service.create(dto);
        System.out.println("Created: " + created);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    
    @GetMapping
    public ResponseEntity<?> get(@RequestParam(name = "id", required = false) Integer id) {
        if (id == null) {
            List<Mobile> all = service.findAll();
            return ResponseEntity.ok(all);
        } else {
            return service.findById(id)
                    .<ResponseEntity<?>>map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body("Mobile with id '" + id + "' not found"));
        }
    }

    // Update
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Mobile dto) {
        if (dto == null || dto.getId() == null) {
            return ResponseEntity.badRequest().body("id is required for update");
        }
        return service.update(dto)
                .<ResponseEntity<?>>map(updated -> {
                    System.out.println("Updated: " + updated);
                    return ResponseEntity.ok(updated);
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Mobile with id '" + dto.getId() + "' not found"));
    }

    // Delete
    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam(name = "id") Integer id) {
        if (id == null) {
            return ResponseEntity.badRequest().body("id query parameter is required");
        }
        return service.delete(id)
                .<ResponseEntity<?>>map(deleted -> {
                    System.out.println("Deleted: " + deleted);
                    return ResponseEntity.ok("Deleted: " + deleted);
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Mobile with id '" + id + "' not found"));
    }
}
