package PrimeCount;

import java.util.Scanner;
import java.lang.Math;

public class PrimeCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer inputNumber = scanner.nextInt();
        Integer primeCount = primeCount(inputNumber);

        System.out.println(primeCount);
    }

public static Boolean primeCheck(Integer integerOfInterest){
        for (int i=2; i <= Math.pow(integerOfInterest, 0.5)+1 ; i++ ){
                if (integerOfInterest % i == 0) return false;
        }

        return true;

}

public static Integer primeCount(Integer inputNumber) {
        Integer Count = 0;
        if (inputNumber == 0) return 0;
        if (inputNumber == 1) return 0;

    for (int i=1; i < inputNumber; i++ ) {
                if (primeCheck(i)){
                    Count++;
                }
        }
    return Count;
}
}
