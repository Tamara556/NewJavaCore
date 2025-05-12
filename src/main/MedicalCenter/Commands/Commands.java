package main.MedicalCenter.Commands;

public interface PrintCommands {
    String EXIST = "0";
    String ADD_DOCTOR = "1";
    String ADD_PATIENT = "2";
    String SEARCH_DOCTOR_BY_ID = "3";
    String SEARCH_DOCTOR_BY_PROFFESION = "4";
    String SEARCH_PACIENT_BY_DOCTOR = "5";

    static void printCommands (){
        System.out.println("input " + EXIST + " for exist");
        System.out.println("input " + ADD_DOCTOR + " for add doctor");
        System.out.println("input " + ADD_PATIENT + " for add patient");
        System.out.println("input " + SEARCH_DOCTOR_BY_ID + " for search doctor by id");
        System.out.println("input " + SEARCH_DOCTOR_BY_PROFFESION + " for search doctor by id");
        System.out.println("input " + SEARCH_PACIENT_BY_DOCTOR + " for search pacient by doctor");
    }

}
