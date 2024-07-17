package com.mlgsec.api_admanager.service;

import com.mlgsec.api_admanager.dto.AdvertsRequests;
import com.mlgsec.api_admanager.model.Adverts;
import com.mlgsec.api_admanager.repositories.AdvertsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdvertsServices {

    @Autowired
    AdvertsRepository repository;

    public Adverts save(AdvertsRequests requests) {
        var adverts = Adverts.of(requests);
        return repository.save(adverts);
    }

    public List<Adverts> getAll() {
        return repository.findAll();
    }

    public Adverts findById(Long id) {
        var adverts = repository.findById(id);
        return adverts.orElse(null);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public Adverts updateById(Long id, AdvertsRequests request) {
        Adverts adverts = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Id: " + id + ", Não encontrado"));
        adverts.update(request);
        return adverts;
    }

}
