package main.MedicalCenter;

import main.MedicalCenter.Commands.ChangeDataCommands;
import main.MedicalCenter.Commands.Commands;
import main.MedicalCenter.Model.Doctor;
import main.MedicalCenter.Model.Profession;
import main.MedicalCenter.Storage.Storage;
import main.MedicalCenter.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import static main.MedicalCenter.Commands.ChangeDataCommands.*;
import static main.MedicalCenter.Commands.Commands.*;

public class MedicalCenterDemo {
    static final private Scanner scanner = new Scanner(System.in);
    static final private Storage storage = new Storage();
    static final private Profession[] values = Profession.values();

    private static boolean isValidEmail(String email) {
        if (email == null) return false;
        return email.toLowerCase().contains("@") && (email.toLowerCase().endsWith(".com") || email.toLowerCase().endsWith(".ru"));
    }

    private static boolean isDataEmpty(String data) {
        return data.equals("");
    }

    public static void main(String[] args) throws ParseException {
        boolean isRun = true;
        while (isRun) {
            Commands.printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    System.out.println("prog end");
                    isRun = false;
                    break;

                case ADD_DOCTOR:
                    addDoctor();
                    break;

                case ADD_PATIENT:
                    addPatient();
                    break;

                case SEARCH_DOCTOR_BY_PROFESSION:
                    if (storage.getSize() == 0) {
                        System.out.println("There is no doctor");
                    } else {
                        searchDoctorByProfession();
                    }
                    break;

                case DELETE_DOCTOR_BY_ID:
                    if (storage.getSize() == 0) {
                        System.out.println("there is no doctor");
                    } else {
                        storage.printDoctors();
                        System.out.println("Choose doctor! input id");
                        String id = scanner.nextLine();
                    }
                    break;

                case CHANGE_DOCTOR_DATA_BY_ID:
                    if (storage.getSize() == 0) {
                        System.out.println("there is no doctor");
                    } else {
                        chanegDoctorDataById();
                    }
                    break;

                case PRINT_ALL_PATIENTS_BY_DOCTOR:
                    if (storage.getSize() == 0) {
                        System.out.println("there is no doctor");
                    } else {
                        printAllPatientsByDoctor();
                    }
                    break;

                case PRINT_TODAYS_PATIENTS:
                    storage.printTodaysPatients();
                    break;

                default:
                    System.out.println("invalid command");
            }
        }

    }

    private static void printAllPatientsByDoctor() {
        storage.printDoctors();
        System.out.println("choose doctor");
        System.out.print("input id");
        String id = scanner.nextLine();

        Doctor doctor = storage.getDoctorById(id);

        if (doctor == null) {
            System.out.println("doctor with " + id + " id does not exist");
        } else {
            storage.printAllPatientsByDoctor(doctor);
        }

    }

    private static void chanegDoctorDataById() {
        storage.printDoctors();
        System.out.println("Choose the id of the doctor whose data you want to change!");
        System.out.print("input id ");
        String changeId = scanner.nextLine();
        Doctor doctorDataChange = storage.getDoctorById(changeId);
        if (doctorDataChange != null) {
            System.out.println("Doctor with " + changeId + " found");
            System.out.println(doctorDataChange);

            boolean isRun = true;
            while (isRun) {
                ChangeDataCommands.printCommands();
                String command = scanner.nextLine();
                switch (command) {
                    case EXIT2:
                        isRun = false;
                        break;
                    case CHANGE_NAME:
                        System.out.println("Change name: ");
                        String newName = scanner.nextLine();
                        while (isDataEmpty(newName)) {
                            System.out.println("Name can't be empty");
                            System.out.print("input name: ");
                            newName = scanner.nextLine();
                        }
                        doctorDataChange.setName(newName);
                        System.out.println("name changed");
                        isRun = false;
                        break;

                    case CHANGE_SURNAME:
                        System.out.println("Change surnameL: ");
                        String newSurname = scanner.nextLine();
                        while (isDataEmpty(newSurname)) {
                            System.out.println("surname can't be empty");
                            System.out.println("input surname: ");
                            newSurname = scanner.nextLine();
                        }
                        doctorDataChange.setSurname(newSurname);
                        System.out.println("surname changed");
                        isRun = false;
                        break;

                    case CHANGE_EMAIL:
                        System.out.println("change email");
                        String newEmail = scanner.nextLine();
                        boolean correctMail = isValidEmail(newEmail);
                        while (!correctMail) {
                            System.out.println("wrong email fromatn / example@gmail.com/example@mail.ru");
                            System.out.println("input email ");
                            newEmail = scanner.nextLine();
                            correctMail = isValidEmail(newEmail);
                        }
                        doctorDataChange.setEmail(newEmail);
                        System.out.println("email changed");
                        isRun = false;
                        break;

                    case CHANGE_PHONE_NUMBER:
                        System.out.println("change phone number");
                        String newPhoneNumber = scanner.nextLine();
                        while (isDataEmpty(newPhoneNumber)) {
                            System.out.println("phone number can't be wrong ");
                            System.out.print("input phone number ");
                            newPhoneNumber = scanner.nextLine();
                        }
                        doctorDataChange.setPhoneNumber(newPhoneNumber);
                        System.out.println("phone number changed! ");
                        isRun = false;
                        break;

                    case CHANGE_PROFESSION:
                        System.out.println("Choose profession!");
                        for (Profession value : values) {
                            System.out.println(value);
                        }

                        System.out.print("profession: ");
                        String newProfession = scanner.nextLine();

                        try {
                            doctorDataChange.setProfession(Profession.valueOf(newProfession));
                            System.out.println("Profession changed!");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Profession " + newProfession + " not found!");
                            return;
                        }
                        isRun = false;
                        break;

                    case CHANGE_ALL:
                        System.out.println("Change Name");
                        String nName = scanner.nextLine();
                        while (isDataEmpty(nName)) {
                            System.out.println("name can't be empty");
                            System.out.println("input name");
                            nName = scanner.nextLine();
                        }

                        System.out.println("change surname ");
                        String nSurname = scanner.nextLine();
                        while (isDataEmpty(nSurname)) {
                            System.out.println("surname can't be empty ");
                            System.out.println("input surname ");
                            nSurname = scanner.nextLine();
                        }

                        System.out.println("change email");
                        String nEmail = scanner.nextLine();
                        boolean correctEmail = isValidEmail(nEmail);
                        while (!correctEmail) {
                            System.out.println("wrong email format / example@gmail.com/example@mail.ru");
                            System.out.println("input email");
                            nEmail = scanner.nextLine();
                            correctEmail = isValidEmail(nEmail);
                        }

                        System.out.println("change phone number");
                        String nPhoneNumber = scanner.nextLine();
                        while (isDataEmpty(nPhoneNumber)) {
                            System.out.println(" phone number can't be empty ");
                            System.out.println("input phone number ");
                            nPhoneNumber = scanner.nextLine();
                        }

                        System.out.println("Choose profession!");
                        for (Profession value : values) {
                            System.out.println(value);
                        }
                        System.out.print("new profession: ");
                        String cProfession = scanner.nextLine();
                        try {
                            doctorDataChange.setProfession(Profession.valueOf(cProfession));
                            System.out.println("Profession changed!");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Profession " + cProfession + " not found!");
                            return;
                        }

                        doctorDataChange.setName(nName);
                        doctorDataChange.setSurname(nSurname);
                        doctorDataChange.setEmail(nEmail);
                        doctorDataChange.setPhoneNumber(nPhoneNumber);

                        System.out.println("Doctor information successfully changed");
                        System.out.println(doctorDataChange);

                        isRun = false;
                        break;
                    default:
                        System.out.println("invalid command");

                }
            }

        } else {
            System.out.println("Doctor with id " + changeId + " not found!");
        }

    }

    private static void searchDoctorByProfession() {
        System.out.println("Choose profession");

        for (Profession value : values) {
            System.out.println(value);
        }
        System.out.print("input profession: ");
        String searchProfession = scanner.nextLine();
        Doctor dc;


        try {
            dc = storage.searchDoctorByProfession(Profession.valueOf(searchProfession));
        } catch (IllegalArgumentException iae) {
            System.out.println("Profession " + searchProfession + " not found!");
            return;
        }

        if (dc != null) {
            System.out.println(dc);
        } else {
            System.out.println("There is no doctor with this profession!");
        }

    }

    private static void addPatient() {
        if (storage.getSize() == 0) {
            System.out.println("there is no doctor");
        } else {
            storage.printDoctors();
            System.out.println("Choose doctor");
            System.out.println("Input id");
            String patientsDoctorId = scanner.nextLine();
            Doctor patientsDoctor = storage.getDoctorById(patientsDoctorId);

            if (patientsDoctor == null) {
                System.out.println("Doctor with " + patientsDoctorId + " does not exist");
            } else {
                System.out.println(" input id ");
                String patientId = scanner.nextLine();

                System.out.println("input name");
                String patientName = scanner.nextLine();
                while (isDataEmpty(patientName)) {
                    System.out.println("name cna't be empty");
                    System.out.print("input name ");
                    patientName = scanner.nextLine();
                }

                System.out.println("input surname ");
                String patientSurname = scanner.nextLine();
                while (isDataEmpty(patientSurname)) {
                    System.out.println("Surname can't be empty");
                    System.out.print("please input surname");
                    patientSurname = scanner.nextLine();
                }

                System.out.println("input email ");
                String patientEmail = scanner.nextLine();
                boolean correctEmail = isValidEmail(patientEmail);
                while (!correctEmail) {
                    System.out.println("wrong email format / example@gmail.com/example@mail.ru");
                    System.out.println("input email");
                    patientEmail = scanner.nextLine();
                    correctEmail = isValidEmail(patientEmail);
                }

                System.out.println("input phone number ");
                String patientPhoneNumber = scanner.nextLine();
                while (isDataEmpty(patientPhoneNumber)) {
                    System.out.println("Phone number chan't be empty");
                    System.out.print("input phone number ");
                    patientPhoneNumber = scanner.nextLine();
                }

                Date date;
                System.out.println("input date (dd/MM/yyyy hh:mm): ");
                String dataStr = scanner.nextLine();

                try {
                    date = DateUtil.dateMinute.parse(dataStr);
                } catch (ParseException e) {
                    System.out.println("Error: wrong date format! example (12/08/2000 12:30");
                    return;
                }

                while (isDataEmpty(patientId) || !storage.idChecker(patientId)) {
                    if (isDataEmpty(patientId)) {
                        System.out.println("Id can't be empty ");
                        System.out.print("Input id ");
                        patientId = scanner.nextLine();
                    }
                    if (!storage.idChecker(patientId)) {
                        System.out.println("This id alerady use by another user, please input another id");
                        patientId = scanner.nextLine();
                    }

                }
            }

        }

    }

    private static void addDoctor() {
        System.out.println("input id ");
        String doctorId = scanner.nextLine();
        while (isDataEmpty(doctorId) || !storage.idChecker(doctorId)) {
            if (isDataEmpty(doctorId)) {
                System.out.println("id can't be empty ");
                System.out.print("please input id ");
                doctorId = scanner.nextLine();
            }

            if (storage.idChecker(doctorId)) {
                System.out.println("doctor with " + doctorId + " alreade exist");
                System.out.print("input other id");
                doctorId = scanner.nextLine();
            }
        }

        System.out.println("input name ");
        String doctorName = scanner.nextLine();
        while (isDataEmpty(doctorName)) {
            System.out.println("name can't be empty ");
            System.out.print("input name:");
            doctorName = scanner.nextLine();
        }

        System.out.println("input surname ");
        String doctorSurname = scanner.nextLine();
        while (isDataEmpty(doctorSurname)) {
            System.out.println("surname can't be empty");
            System.out.println("input surname");
            doctorSurname = scanner.nextLine();
        }

        System.out.println("input email");
        String doctorEmail = scanner.nextLine();
        boolean correctEmail = isValidEmail(doctorEmail);
        while (!correctEmail) {
            System.out.println("wrong email format / example@gmail.com/example@mail.ru");
            System.out.println("input email ");
            doctorEmail = scanner.nextLine();
            correctEmail = isValidEmail(doctorEmail);
        }

        System.out.println("input phone number");
        String doctorPhoneNumber = scanner.nextLine();
        while (isDataEmpty(doctorPhoneNumber)) {
            System.out.println("phone number can't be empty");
            System.out.println("input phone number");
            doctorPhoneNumber = scanner.nextLine();
        }

        System.out.println("Choose profession ");
        for (Profession value : values) {
            System.out.println(value);
        }

        System.out.println("input profession ");
        String doctorProfession = scanner.nextLine();

        Doctor newDoctor;

        try {
            newDoctor = new Doctor(doctorId, doctorName, doctorSurname, doctorEmail,
                    doctorPhoneNumber, Profession.valueOf(doctorProfession));
        } catch (IllegalArgumentException e) {
            System.out.println("No profession named " + doctorProfession + " found");
            return;
        }

        storage.addPerson(newDoctor);
        System.out.println("Doctor successfully added!");

    }

}
