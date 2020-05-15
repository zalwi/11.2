package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PositiveNumbers {
    ArrayList<Double> numbers;

    public PositiveNumbers() {
        this.numbers = new ArrayList<>();;
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
                    numbers.add(tmpNumber);
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
        ArrayList tmpArray = numbers;
        System.out.println("Minimum: " + Collections.min(tmpArray));
        System.out.println("Maximum: " + Collections.max(tmpArray));
    }

    private void showReverseNumbers() {
        ArrayList reversedArray = new ArrayList();
        reversedArray.addAll(numbers);
        Collections.reverse(reversedArray);
        System.out.println(reversedArray.toString());
    }

    private String createSumString() {
        String tmpString = "";
        for (int i = 0; i < numbers.size() ; i++) {
            if (i == 0) tmpString += numbers.get(i);
            else tmpString += "+" + numbers.get(i);
        }
        tmpString += "=" + sumOfNumbers();
        return tmpString;
    }

    private double sumOfNumbers() {
        double sum = 0;
        for (double number : numbers) {
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
