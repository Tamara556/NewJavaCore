package main.ArrayUtil;

public class ArrayUtil {
    public static void main(String[] args) {
        int[] numbers = {1, 6, 3, 9, 15, 52, -3, 5, 8};
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println(numbers[0]);
        System.out.println(numbers[numbers.length - 1]);
        System.out.println(numbers.length);

        int min = numbers[0];
        for (int number : numbers) {
            if (number < min){
                min = number;
            }
        }
        System.out.println(min);
        if (numbers.length <= 2) {
            System.out.println("Can't print middle values.");
        } else {
            if (numbers.length % 2 == 0) {
                System.out.println( numbers[numbers.length / 2 - 1]  + numbers[numbers.length / 2]);
            } else {
                System.out.println("middle number" + numbers[numbers.length / 2]);
            }
        }

        int evenCount = 0;
        int oddCount = 0;
        int sum = 0;

        for (int number : numbers) {
            sum += number;
            if (number % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        System.out.println(evenCount);
        System.out.println("OddCount: " + oddCount);
        System.out.println("sum: " + sum);
        System.out.println((double) sum / numbers.length);

    }
}
