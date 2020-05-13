package logic;

import data.NumbersContainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NumbersContainerOperator {
    private NumbersContainer numbersContainer;

    public NumbersContainerOperator() {
        this.numbersContainer = new NumbersContainer();
    }

    public void runNumberReader() {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        do {
            System.out.println("Podaj liczbę dodatnią:");
            String numberString = scanner.nextLine();
            if (checkIfInputIsNumber(numberString)) {
                double tmpNumber = Double.parseDouble(numberString);
                if (checkIfIsPositiveNumber(tmpNumber)) {
                    numbersContainer.addNewNumber(tmpNumber);
                } else {
                    loop = false;
                }
            }
        } while (loop);
        createSummary();
    }

    private void createSummary() {
        System.out.println("--- Podsumowanie ---");
        System.out.println("Odwrócona lista:");
        showReverseNumbers();
        System.out.println("Suma wszystkich wartości:\n" + createSumString());
        showMinMaxOfList();
        System.out.println("--------------------");
    }

    private void showMinMaxOfList(){
        ArrayList tmpArray = numbersContainer.getNumbers();
        System.out.println("Minimum: " + Collections.min(tmpArray));
        System.out.println("Maximum: " + Collections.max(tmpArray));
    }

    private void showReverseNumbers() {
        ArrayList reversedArray = new ArrayList();
        reversedArray.addAll(numbersContainer.getNumbers());
        Collections.reverse(reversedArray);
        System.out.println(reversedArray.toString());
    }

    private String createSumString() {
        String tmpString = "";
        for (int i = 0; i < numbersContainer.getNumbers().size() ; i++) {
            if (i == 0) tmpString += numbersContainer.getNumbers().get(i);
            else tmpString += "+" + numbersContainer.getNumbers().get(i);
        }
        tmpString += "=" + sumOfNumbers();
        return tmpString;
    }

    private double sumOfNumbers() {
        double sum = 0;
        for (double number : numbersContainer.getNumbers()) {
            sum += number;
        }
        return sum;
    }

    private boolean checkIfIsPositiveNumber(Double number) {
        if (number < 0) {
            System.out.println("Podana liczba jest ujemna, koniec uzupełniania");
            return false;
        }
        return true;
    }

    private boolean checkIfInputIsNumber(String usersInput) {
        try {
            Double.parseDouble(usersInput);
        } catch (NumberFormatException e) {
            System.out.println("Podany ciąg znaków nie jest liczbą | " + e.getMessage());
            return false;
        }
        return true;
    }
}
