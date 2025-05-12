package main.MedicalCenter.Storage;

import main.MedicalCenter.Model.Doctor;
import main.MedicalCenter.Model.Patient;
import main.MedicalCenter.Model.Person;
import main.MedicalCenter.Model.Profession;

public class MedicalCenterStorage {

    public Person[] persons = new Person[10];
    int size = 0;

    public int getSize() {
        return size;
    }

    public void extend(){
        Person[] newArr = new Person[persons.length + 10];
        System.arraycopy(persons, 0, newArr, 0, persons.length);
        persons = newArr;
    }

    public void addPerson(Person person){
        if (size == persons.length){
            extend();
        }
        persons[size++] = person;
    }

    public void PrintAllDoctors(){
        for (int i = 0; i < size; i++) {
            Person person = persons[i];
            if (person instanceof Doctor){
                System.out.println(person);
            }
        }
    }

    public void PrintAllPatients(){
        for (int i = 0; i < size; i++) {
            Person person = persons[1];
            if (person instanceof Patient){
                System.out.println(person);
            }
        }
    }

    public Doctor searchDoctorByProfession(Profession profession){
        for (int i = 0; i < size; i++) {
            Person person = persons[i];
            if (persons[i] instanceof Doctor){
                Doctor doctor = new Doctor();
                if (doctor.getProfession().equals(profession)){
                    return doctor;
                }
            }

        }
        return null;
    }

    public void searchDoctorById(String id){
        boolean found = false;
        for (int i = 0; i < size; i++) {
            Person doctor = persons[i];
            if (doctor.getId().equals(id) && doctor instanceof Doctor){
                deleteByIndex(i);
                System.out.println("Doctor has been deleted");
                found = true;
            }
        }

        if (!found){
            System.out.println("Doctor with " + id  + " not found");
        }

    }

    public void getDoctorById(String id){
        for (int i = 0; i < size; i++) {
            Person doctor = persons[i];
            if (doctor.getId().equals(id) && doctor instanceof Doctor){
                System.out.println(doctor);
            } else {
                System.out.println("Doctor with " + id + " not found");
            }
        }
    }

    public void printPatientsByDoctor(Doctor doctor){
        boolean found = false;
        for (int i = 0; i < size; i++) {
            Person person = persons[i];
            if (person instanceof Patient){
                Patient patient = (Patient) person;
                if (patient.getDoctor().equals(doctor)){
                    System.out.println(patient);
                    found = true;
                }
            }
            if (!found){
                System.out.println("This doctor has no patients");
            }
        }
    }

    private void deleteByIndex(int i) {
        for (int j = 0; j < persons.length; j++) {
            persons[j] = persons[j + 1];
        }
        size --;
    }

}
