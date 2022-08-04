import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Summation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstNumber = scanner.nextLine();
        String secondNumber = scanner.nextLine();
        System.out.println(addList(firstNumber, secondNumber));
    }

    public static List addList(String firstNumber, String secondNumber) {
        LinkedList firstNumberList = stringToLinkedList(firstNumber);
        LinkedList secondNumberList = stringToLinkedList(secondNumber);

        Integer resultListLength = Math.max(firstNumberList.size(), secondNumberList.size()) + 1;
        Integer Carry = 0;
        Integer elementsSum;
        Integer remainder = 0;
        List<Integer> result = Arrays.asList(new Integer[resultListLength]);
        for (int i = 0; i < resultListLength; i++) {

            elementsSum = Integer.parseInt(String.valueOf(getOrDefault(i, '0', firstNumberList))) +
                    Integer.parseInt(String.valueOf(getOrDefault(i, '0', secondNumberList))) +
                    Carry;
            remainder = elementsSum % 10;
            Carry = (elementsSum - remainder) / 10;

            result.set(i, remainder);
        }
        return result;

    }

    public static LinkedList stringToLinkedList(String rawString) {

        Integer maxIndex = rawString.length() - 1;
        LinkedList<Character> chars = new LinkedList<>();

        for (int i = maxIndex; i >= 0; i--) {
            chars.add(rawString.charAt(i));
        }
        return chars;

    }

    public static <E> E getOrDefault(int index, E defaultValue, List<E> list) {
        return index <= list.size() - 1 ? list.get(index) : defaultValue;
    }

}
