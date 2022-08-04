package GoodString;

import java.util.HashMap;

public class GoodString {
    public static void main(String[] args) {
        String inputString;
        inputString = "aacabbfbb";
        stringChecker(inputString);
    }

    public static void stringChecker(String inputString) {
        HashMap<Character, Integer> countCharacterMap = new HashMap<>();

        for (int i = 0; i < inputString.length(); i++) {
            if (!countCharacterMap.containsKey(inputString.charAt(i))) {
                countCharacterMap.put(inputString.charAt(i), 1);
            } else {
                countCharacterMap.put(inputString.charAt(i), countCharacterMap.get(inputString.charAt(i)) + 1);
            }
        }

        System.out.println(countCharacterMap);
    }
}