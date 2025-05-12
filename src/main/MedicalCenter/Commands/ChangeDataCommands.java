package main.MedicalCenter.Commands;

public interface ChangeDataCommands {
    String EXIT2 = "1";
    String CHANGE_NAME = "2";
    String CHANGE_SURNAME = "3";
    String CHANGE_EMAIL = "4";
    String CHANGE_PHONE_NUMBER = "5";
    String CHANGE_PROFESSION = "6";
    String CHANGE_ALL = "7";

    static void printCommands(){
        System.out.println("input " + EXIT2 + " for exsit");
        System.out.println("input " + CHANGE_NAME + " for change name");
        System.out.println("input " + CHANGE_SURNAME + " for change surname");
        System.out.println("input " + CHANGE_EMAIL + " for change email");
        System.out.println("input " + CHANGE_PHONE_NUMBER + " for change phone number");
        System.out.println("input " + CHANGE_PROFESSION + " for chnage profession");
        System.out.println("input " + CHANGE_ALL + " for chnage all");
    }
}
