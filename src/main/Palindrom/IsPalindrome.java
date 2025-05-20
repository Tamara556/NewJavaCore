package main.Palindrom;

public class IsPalindrome {

    public static boolean isPalindrome(String str) {
        if (str == null) return false;

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] testWords = {"level", "madam", "radar", "hello", "world", "noon"};

        for (String word : testWords) {
            System.out.println(word + " is palindrome? " + isPalindrome(word));
        }
    }
}

