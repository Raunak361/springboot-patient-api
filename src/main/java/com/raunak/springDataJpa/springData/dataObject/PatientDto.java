package com.raunak.springDataJpa.springData.dataObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor

public class PatientDto {
    int id;
    int bedNo;
    String name;
    String email;
}
