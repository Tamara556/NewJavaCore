package main.forlf;

public class ForflExamples {
    public static void main(String[] args) {
         for (int i = 0; i < 11; i++) {
             System.out.print(" " + i);
         }
        System.out.println(" ");
         int sum = 0;
         for (int i = 0; i < 101; i++) {
             sum += i;
         }
         System.out.println(sum);
        System.out.println(" ");
        for (int i = 50; i > 0; i--) {
            System.out.print(" " + i);
        }
        System.out.println(" ");
        for (int i = 1; i < 20; i += 2) {
            System.out.print(" " + i);
        }
        System.out.println(" ");
        for (int i = 2; i < 100; i+=2) {
            System.out.print(" " + i);
        }
    }
}
