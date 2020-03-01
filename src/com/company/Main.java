package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        creatingGameForTwoPlayers();

    }


    public static void creatingGameForTwoPlayers() {
        boolean isGameOn = true;
        int computerNumberOne = creatingARandomNumber();
        int computerNumberTwo = creatingARandomNumber();
        int playerNumberOne = 0;
        int playerNumberTwo = 0;
        while (true) {
            System.out.println("Играч номер едно ти си наред.Моля въведи четирицифреното число и да няма повтарящи се цифри или да е повече от четири цифри:");
            playerNumberOne = gettingThePlayerInput();
            countsTheCows(playerNumberOne, computerNumberOne);
            System.out.println("Има " + countsTheBulls(playerNumberOne, computerNumberOne) + " бика в твоето число");
            if (countsTheBulls(playerNumberOne, computerNumberOne) == 4) {
                break;
            }
            System.out.println("Играч номер две ти си наред.Моля въведи четирицифреното число и да няма повтарящи се цифри или да е повече от четири цифри:");
            playerNumberTwo = gettingThePlayerInput();
            countsTheCows(playerNumberTwo, computerNumberTwo);
            System.out.println("Има " + countsTheBulls(playerNumberTwo, computerNumberTwo) + " бика в твоето число");
            if (countsTheBulls(playerNumberTwo, computerNumberTwo) == 4) {
                break;
            }
        }
        if (playerNumberOne == computerNumberOne) {
            System.out.println("Играч номер едно позна числото");
        } else if (playerNumberTwo == computerNumberTwo) {
            System.out.println("Играя номер две позна числото");
        }
    }

    public static int creatingARandomNumber() {
        Random rand = new Random();
        int digitNumberOne = rand.nextInt(9) + 1;
        int digitNumberTwo = 0;
        int digitNumberThree = 0;
        int digitNumberFour = 0;

        do {
            digitNumberTwo = rand.nextInt(10);
        } while (digitNumberTwo == digitNumberOne);

        do {
            digitNumberThree = rand.nextInt(10);
        } while (digitNumberThree == digitNumberOne || digitNumberThree == digitNumberTwo);

        do {
            digitNumberFour = rand.nextInt(10);
        } while (digitNumberFour == digitNumberOne || digitNumberFour == digitNumberTwo || digitNumberFour == digitNumberThree);

        String digitNumberOneStr = Integer.toString(digitNumberOne);
        String digitNumberTwoStr = Integer.toString(digitNumberTwo);
        String digitNumberThreeStr = Integer.toString(digitNumberThree);
        String digitNumberFourStr = Integer.toString(digitNumberFour);

        String digitConcat = digitNumberOneStr + digitNumberTwoStr + digitNumberThreeStr + digitNumberFourStr;

        int fourDigitNumber = Integer.parseInt(digitConcat);

        return fourDigitNumber;
    }

    public static int takingEachDigit(int number, int digit) {
        int numberToReturn = 0;
        int tempNumber = number;

        int digitOne = tempNumber % 10;
        tempNumber = tempNumber / 10;

        int digitTwo = tempNumber % 10;
        tempNumber = tempNumber / 10;

        int digitThree = tempNumber % 10;
        tempNumber = tempNumber / 10;

        int digitFour = tempNumber % 10;
        tempNumber = tempNumber / 10;

        if (digit == 4) {
            numberToReturn = digitOne;
        } else if (digit == 3) {
            numberToReturn = digitTwo;
        } else if (digit == 2) {
            numberToReturn = digitThree;
        } else if (digit == 1) {
            numberToReturn = digitFour;
        }

        return numberToReturn;
    }

    public static int countsTheBulls(int theFirstNumber, int theSecondNumber) {
        int bulls = 0;
        for (int i = 0; i <= 4; i++) {
            if (takingEachDigit(theFirstNumber, i) == takingEachDigit(theSecondNumber, i)) {
                bulls++;
            }

        }
        return bulls;
    }

    public static int countsTheCows(int theFirstNumber, int theSecondNumber) {
        int cows = 0;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                if (takingEachDigit(theFirstNumber, i) == takingEachDigit(theSecondNumber, j)) {
                    if (takingEachDigit(theFirstNumber, j) != takingEachDigit(theSecondNumber, j)) {
                        cows++;
                    }
                }

            }

        }
        System.out.println("Има" + cows + "крави в твоето число");
        return cows;
    }

    public static int gettingThePlayerInput() {
        Scanner input = new Scanner(System.in);
        int theUserInput = input.nextInt();
        return theUserInput;
    }
}