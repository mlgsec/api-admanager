package com.mlgsec.api_admanager.repositories;

import com.mlgsec.api_admanager.model.Adverts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertsRepository extends JpaRepository<Adverts, Long> {}
