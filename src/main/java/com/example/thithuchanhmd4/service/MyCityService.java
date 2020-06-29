package com.example.thithuchanhmd4.service;

import com.example.thithuchanhmd4.model.MyCity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface MyCityService {
    Page<MyCity> findAll(Pageable pageable);

    Page<MyCity> findByNameContaining(Pageable pageable, Optional<String> name);

    Optional<MyCity> findById(Long id);

    void save(MyCity myCity);

    void remove(Long id);

}
