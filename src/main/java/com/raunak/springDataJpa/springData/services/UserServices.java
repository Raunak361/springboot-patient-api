package com.raunak.springDataJpa.springData.services;

import com.raunak.springDataJpa.springData.dataObject.PatientDto;
import com.raunak.springDataJpa.springData.entity.Patient;

import java.util.List;

import java.util.Map;

public interface UserServices {

    public List<PatientDto> getAllPatient();

    public PatientDto insertPatient(Patient patient);

    public PatientDto modifyPatient(Long id,Map<String,Object> data);

    public void deleteById(int id);

    public PatientDto getPatientById(int id);
}
