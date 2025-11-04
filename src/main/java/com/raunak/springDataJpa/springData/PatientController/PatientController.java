package com.raunak.springDataJpa.springData.PatientController;

import com.raunak.springDataJpa.springData.dataObject.PatientDto;
import com.raunak.springDataJpa.springData.entity.Patient;
import com.raunak.springDataJpa.springData.services.UserServices;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
public class PatientController {

    private final UserServices userServices;

    @GetMapping("/patient")
    public ResponseEntity<List<PatientDto>> getAllPatient(){
        return ResponseEntity.ok(userServices.getAllPatient());
    }

    @PostMapping("/patient")
    public ResponseEntity<PatientDto> insertPatient(@Valid @RequestBody Patient patient){
        return ResponseEntity.status(HttpStatus.CREATED).body(userServices.insertPatient(patient));
    }

    @PatchMapping("/patient/{id}")
    public ResponseEntity<PatientDto> modifyPatient(@Valid @PathVariable Long id , @RequestBody Map<String,Object> data){
        return ResponseEntity.status(HttpStatus.CREATED).body(userServices.modifyPatient(id,data));
    }

    @DeleteMapping("/patient/{id}")
    public void deleteById(@PathVariable int id){
        userServices.deleteById(id);
    }
    @GetMapping("/patient/{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable int id){
        return ResponseEntity.ok(userServices.getPatientById(id));
    }




}
