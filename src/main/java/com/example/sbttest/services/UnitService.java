package com.example.sbttest.services;

import com.example.sbttest.entity.Unit;
import com.example.sbttest.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitService {

    @Autowired
    private UnitRepository unitRepository;

    public Unit getUnitById(Long id) {
        return unitRepository.getOne(id);
    }
}
