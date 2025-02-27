package com.Cabrera.facturacion.almacen.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Cabrera.facturacion.almacen.entity.Rol;
import com.Cabrera.facturacion.almacen.service.RolService;

import java.util.List;

@RestController
@RequestMapping("/v1/roles")
public class RolController {
    @Autowired
    private RolService service;

    @GetMapping
    public ResponseEntity<List<Rol>> findAll(
            @RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize
    ) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        List<Rol> roles = service.findAll(page);
        return ResponseEntity.ok(roles);
    }

    @PostMapping
    public ResponseEntity<Rol> create (@RequestBody Rol rol) {
        Rol registro = service.save(rol);
        return ResponseEntity.ok(registro);
    }
}
