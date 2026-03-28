package src.model;
import java.util.ArrayList;

import src.exceptions.MaxCapacityException;

public class Hospital {
    public static final int MAX_INSTANCES = 100;

    private String name;
    private ArrayList<Patient> patients;
    private ArrayList<Doctor> doctors;
    private ArrayList<Appointment> appointments;
    private ArrayList<Bill> bills;
    private ArrayList<Room> rooms;

    public Hospital(String name) {
        this.name = name;
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        appointments = new ArrayList<>();
        bills = new ArrayList<>();
        rooms = new ArrayList<>();
    }

    public void addPatient(Patient patient) throws MaxCapacityException {
        if (patients.size() >= MAX_INSTANCES) {
            throw new MaxCapacityException("patient");
        }
        patients.add(patient);
        System.out.println("Patient " + patient.getName() + " added.");
    }

    public void addDoctor(Doctor doctor) throws MaxCapacityException {
        if (doctors.size() >= MAX_INSTANCES) {
            throw new MaxCapacityException("doctor");
        }
        doctors.add(doctor);
        System.out.println("Doctor " + doctor.getName() + " added.");
    }

    public void addAppointment(Appointment appointment) throws MaxCapacityException {
        if (appointments.size() >= MAX_INSTANCES) {
            throw new MaxCapacityException("appointment");
        }
        appointments.add(appointment);
        System.out.println("Appointment added.");
    }

    public void addBill(Bill bill) throws MaxCapacityException {
        if (bills.size() >= MAX_INSTANCES) {
            throw new MaxCapacityException("bill");
        }
        bills.add(bill);
        System.out.println("Bill added.");
    }

    public void addRoom(Room room) throws MaxCapacityException {
        if (rooms.size() >= MAX_INSTANCES) {
            throw new MaxCapacityException("room");
        }
        rooms.add(room);
        System.out.println("Room added.");
    }

    public String getName() {
        return name;
    }

    public void hospitalInfo() {
    System.out.println("Hospital name: " + getName() + 
                        ", Total Patients: " + patients.size() +
                        ", Total Doctors: " + doctors.size() +
                        ", Total Rooms: " + rooms.size() +
                        ", Total Appointments: " + appointments.size());
    }
}
