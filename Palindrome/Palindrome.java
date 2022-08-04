package Palindrome;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String inputString = scanner.nextLine();
        System.out.println(isPalindrome(inputString));
    }

    public static Boolean isPalindrome(String inputString){
        Integer maxIndex = inputString.length() - 1;

        if (inputString.length() % 2 == 0){
            for (int i = 0; i <= (maxIndex - 1) /2 ; i++){
                if (inputString.charAt(i) != inputString.charAt(maxIndex-i)) {
                    return false;
                }

            }
        }

        else {
            for (int i = 0; i <= maxIndex / 2; i++){
                if (inputString.charAt(i) != inputString.charAt(maxIndex-i)) {
                    return false;
                }
        }
    }
        return true;
}
}
