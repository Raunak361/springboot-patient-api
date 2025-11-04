package com.raunak.springDataJpa.springData.services;

import com.raunak.springDataJpa.springData.customException.ResourceNotFoundException;
import com.raunak.springDataJpa.springData.dataObject.PatientDto;
import com.raunak.springDataJpa.springData.entity.Patient;
import com.raunak.springDataJpa.springData.repository.PatientRepo;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RestController
@RequiredArgsConstructor

public class ServiceImpl implements UserServices {

    private final PatientRepo patientRepo;
    private final ModelMapper modelMapper;


    @Override
    public List<PatientDto> getAllPatient() {
        List<Patient> patientList = patientRepo.findAll();
        if(patientList.isEmpty()){
            throw new ResourceNotFoundException("No Data exist");
        }
        List<PatientDto> patientDtoList = new ArrayList<>();
        patientList.forEach(patient1 -> patientDtoList.add( modelMapper.map(patient1,PatientDto.class)));
        return patientDtoList;
    }

    @Override
    public PatientDto insertPatient(Patient patient) {
        if(patientRepo.existsByBedNo(patient.getBedNo())){
            throw new ResourceNotFoundException("Bed number "+patient.getBedNo()+" already occupied or not available") ;
        }

        return modelMapper.map(patientRepo.save(patient),PatientDto.class);
    }

    @Override
    public PatientDto modifyPatient(Long id,Map<String, Object> data) {
        Patient patient = patientRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("no data found"));
        data.forEach((field,value) ->{
            switch(field){
                case "name":
                    patient.setName((String) value);
                    break;
                case "email":
                    patient.setEmail((String) value);
                    break;
                case "bedNo":
                    patient.setBedNo((int) value);
                    break;
                default:
                    throw new IllegalArgumentException("Illegal input");

            }
        });

        return modelMapper.map(patientRepo.save(patient),PatientDto.class);
    }

    @Override
    public PatientDto getPatientById(int id) {
        Patient patient = patientRepo.findById((long) id).orElseThrow(()-> new ResourceNotFoundException("Patient does not exist"));
        return modelMapper.map(patient,PatientDto.class);
    }

    @Override
    public void deleteById(int id){
        patientRepo.deleteById((long)id);
    }

}
