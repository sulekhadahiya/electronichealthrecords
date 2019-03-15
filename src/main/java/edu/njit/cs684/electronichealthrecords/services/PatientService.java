package edu.njit.cs684.electronichealthrecords.services;

import edu.njit.cs684.electronichealthrecords.domain.Patient;
import edu.njit.cs684.electronichealthrecords.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public List<Patient> getPatientInfo(){
        List<Patient> returnedPatient = this.patientRepository.findAll();

        return returnedPatient;
    }

    public Patient createPatient(Patient patient){
        Patient savedPatient = this.patientRepository.insert(patient);

        return savedPatient;
    }


}
