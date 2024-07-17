package com.mlgsec.api_admanager.controller;

import com.mlgsec.api_admanager.dto.AdvertsRequests;
import com.mlgsec.api_admanager.model.Adverts;
import com.mlgsec.api_admanager.service.AdvertsServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/adverts")
@RequiredArgsConstructor
public class AdvertsController {

    @Autowired
    AdvertsServices services;

    @GetMapping
    public List<Adverts> findAll() {
        return services.getAll();
    }

    @GetMapping("/{id}")
    public Adverts findById(@PathVariable Long id) {
        return services.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        services.deleteById(id);
    }

    @PutMapping("/{id}")
    public Adverts updateById(@PathVariable Long id, @RequestBody AdvertsRequests request) {
        return services.updateById(id, request);
    }

    @PostMapping
    public Adverts save(@RequestBody @Valid AdvertsRequests requests) {
        return services.save(requests);
    }

}
