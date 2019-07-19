package com.example.sbttest.services;

import com.example.sbttest.entity.Period;
import com.example.sbttest.repository.PeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeriodService {

    @Autowired
    private PeriodRepository periodRepository;

    public Period getPeriodById(Long id) {
        return periodRepository.getOne(id);
    }
}
