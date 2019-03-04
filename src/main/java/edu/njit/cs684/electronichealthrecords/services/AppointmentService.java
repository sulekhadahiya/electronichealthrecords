package edu.njit.cs684.electronichealthrecords.services;

import edu.njit.cs684.electronichealthrecords.domain.Appointment;
import edu.njit.cs684.electronichealthrecords.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment bookAppointment(String patientId, String doctorId,
                                       ZonedDateTime appointmentDateTime, String appointmentReason){
        Appointment appointment = new Appointment();
        appointment.setPatientId(patientId);
        appointment.setDoctorId(doctorId);
        appointment.setAppointmentDateTime(appointmentDateTime);
        appointment.setAppointmentReason(appointmentReason);
        Appointment savedAppointment = appointmentRepository.save(appointment);

        return savedAppointment;
    }

    public Appointment viewAppointment(String appointmentId) {

        Appointment appointment;
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(appointmentId);
        appointment = optionalAppointment.orElse(null);
        return appointment;
    }
}
