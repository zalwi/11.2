package data;

import java.util.ArrayList;

public class NumbersContainer{
    private ArrayList<Double> numbers;

    public NumbersContainer() {
        this.numbers = new ArrayList<>();
    }

    public void addNewNumber(double number) {
        numbers.add(number);
    }

    public ArrayList<Double> getNumbers() {
        return numbers;
    }
}
