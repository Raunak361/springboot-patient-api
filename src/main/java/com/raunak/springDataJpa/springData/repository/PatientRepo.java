package com.raunak.springDataJpa.springData.repository;

import com.raunak.springDataJpa.springData.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {

    public boolean existsByBedNo(int bedNo);

    }
