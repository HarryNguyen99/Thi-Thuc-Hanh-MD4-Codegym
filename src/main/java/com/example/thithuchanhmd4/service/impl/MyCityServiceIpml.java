package com.example.thithuchanhmd4.service.impl;

import com.example.thithuchanhmd4.model.MyCity;
import com.example.thithuchanhmd4.repository.MyCityRepository;
import com.example.thithuchanhmd4.service.MyCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MyCityServiceIpml implements MyCityService {

    @Autowired
    private MyCityRepository myCityRepository;

    @Override
    public Page<MyCity> findAll(Pageable pageable) {
        return myCityRepository.findAll(pageable);
    }

    @Override
    public Page<MyCity> findByNameContaining(Pageable pageable, Optional<String> name) {
        return myCityRepository.findByNameContaining(pageable, name);
    }

    @Override
    public Optional<MyCity> findById(Long id) {
        return myCityRepository.findById(id);
    }

    @Override
    public void save(MyCity myCity) {
        myCityRepository.save(myCity);
    }

    @Override
    public void remove(Long id) {
        myCityRepository.deleteById(id);
    }
}
