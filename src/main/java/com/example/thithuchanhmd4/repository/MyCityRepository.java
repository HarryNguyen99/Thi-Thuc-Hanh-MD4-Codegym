package com.example.thithuchanhmd4.repository;

import com.example.thithuchanhmd4.model.MyCity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface MyCityRepository extends PagingAndSortingRepository<MyCity, Long> {
    Page<MyCity> findByNameContaining(Pageable pageable, Optional<String> name);

}
