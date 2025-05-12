package main.MedicalCenter.Storage;

import main.MedicalCenter.Model.Doctor;
import main.MedicalCenter.Model.Pacient;
import main.MedicalCenter.Model.Person;
import main.MedicalCenter.Model.Profession;
import main.MedicalCenter.util.DateUtil;

import java.util.Date;

public class Storage {

    private Person[] storage = new Person[10];
    private int size = 0;

    public int getSize() { return size; }

    public void addPerson(Person person) {
        if (size == storage.length) {
            extend();
        }
        storage[size++] = person;
    }

    public void printDoctors() {
        for (int i = 0; i < size; i++) {
            Person person = storage[i];
            if (person instanceof Doctor) {
                System.out.println(person);
            }
        }
    }

    public Doctor searchDoctorByProfession(Profession profession) {
        for (int i = 0; i < size; i++) {
            Person person = storage[i];
            if (storage[i] instanceof Doctor) {
                Doctor doctor = (Doctor) person;
                if (doctor.getProfession().equals(profession)) {
                    return doctor;
                }
            }
        }
        return null;
    }

    public void deleteDoctorById(String delId) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            Person doctor = storage[i];
            if (doctor.getId().equals(delId) && doctor instanceof Doctor) {
                deleteByIndex(i);
                System.out.println("Doctor deleted!");
                found = true;
            }
        }
        if(!found) {
            System.out.println("Doctor with id " + delId + " not found");
        }
    }

    public boolean idChecker(String changeId) {
        for (int i = 0; i < size; i++) {
            Person doctor = storage[i];
            if (doctor.getId().equals(changeId)) {
                return false;
            }
        }
        return true;
    }

    public Doctor getDoctorById(String id) {
        for (int i = 0; i < size; i++) {
            Person person = storage[i];
            if (person.getId().equals(id) && person instanceof Doctor) {
                return (Doctor) person;
            }
        }
        return null;
    }

    public boolean dateChecker(Date date) {
        for (int i = 0; i < size; i++) {
            Person person = storage[i];
            if (storage[i] instanceof Pacient) {
                Pacient patient = (Pacient) person;
                if (patient.getDateOfReg().equals(date)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printAllPatientsByDoctor(Doctor doctor) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            Person person = storage[i];
            if (person instanceof Pacient) {
                Pacient patient = (Pacient) person;
                if (patient.getDoctor().equals(doctor)) {
                    System.out.println(patient);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("This doctor has no patients");
        }
    }


    public void printTodaysPatients() {
        boolean found = false;
        Date date = new Date();
        for (int i = 0; i < size; i++) {
            Person person = storage[i];
            if (storage[i] instanceof Pacient) {
                Pacient patient = (Pacient) person;
                if (DateUtil.areTheDatesTheSame(date, patient.getDateOfReg())) {
                    System.out.println(patient);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No patients today!");
        }
    }

    private void extend() {
        Person[] newArr = new Person[storage.length + 10];
        System.arraycopy(storage, 0, newArr, 0, storage.length);
        storage = newArr;
    }

    private void deleteByIndex(int i) {
        for (int j = i; j < size; j++) {
            storage[j] = storage[j+1];
        }
        size--;
    }

}