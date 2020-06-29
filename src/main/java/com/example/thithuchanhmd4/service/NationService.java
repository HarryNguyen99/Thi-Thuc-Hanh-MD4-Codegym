package com.example.thithuchanhmd4.service;

import com.example.thithuchanhmd4.model.Nation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface NationService {
    Page<Nation> findAll(Pageable pageable);


    Optional<Nation> findById(Long id);

    void save(Nation nation);

    void remove(Long id);

}
