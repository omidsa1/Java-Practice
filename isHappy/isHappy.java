package Problems;

import java.util.ArrayList;
import java.util.function.Function;

public class isHappy {

    public static void main(String[] args) {
        Boolean finite = printSquareOfEachDigitFromInput(4);
        System.out.println(finite);
    }

    public static boolean printSquareOfEachDigitFromInput(Integer input){
        Integer sum = input;
        ArrayList<Integer> squareSumArrayList = new ArrayList<>();

        while (true){
            sum = sumOfDigitSquare.apply(sum);
            if (squareSumArrayList.contains(sum)) return false;
            else if (sum == 1) return true;
            else squareSumArrayList.add(sum);

        }

    }

     static Function <Integer, Integer> sumOfDigitSquare = x -> {
        Integer sum = 0;
        while(x > 0){
        sum +=  (int) Math.pow(x % 10, 2);
        x = x / 10;
    }
        return sum;
    };
        }