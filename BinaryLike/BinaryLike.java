package com.omid.primecheck;

import java.util.Arrays;
import java.util.Scanner;


public class BinaryLike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        inputStringToBinStyleAnsArray(userInput);
    }

    public static void inputStringToBinStyleAnsArray(String userInput) {

        Integer maxDigit = -1;
        Integer currentIterDigit;

        for (int i = 0; i < userInput.length(); i++) {
            currentIterDigit = Integer.valueOf(String.valueOf(userInput.charAt(i)));
            if ((currentIterDigit > maxDigit))
                maxDigit = currentIterDigit;
        }

        Integer[][] answerArray = new Integer[maxDigit][userInput.length()];

        for (int i = 0; i < maxDigit; i++) {
            for (int j = 0; j < userInput.length(); j++)
                answerArray[i][j] = 0;
        }

        for (int i = 0; i < userInput.length(); i++) {
            currentIterDigit = Integer.valueOf(String.valueOf(userInput.charAt(i)));

            for (int j = 0; j < currentIterDigit; j++) {
                answerArray[j][i] = 1;
            }
        }
        binLikeAnsArrayPrint(answerArray, maxDigit);
    }

    public static void binLikeAnsArrayPrint(Integer[][] ansArray, Integer numOfAnswers) {

        for (int i = 0; i < numOfAnswers; i++) {
            String outputAnswer = Arrays.toString(ansArray[i]);
            outputAnswer = outputAnswer.replace("[", "")
                    .replace("]", "")
                    .replace(", ", "")
                    .replace("null", "");

            outputAnswer = outputAnswer.replaceAll("^0+(?!$)", "");

            System.out.println(outputAnswer);

        }
    }
}