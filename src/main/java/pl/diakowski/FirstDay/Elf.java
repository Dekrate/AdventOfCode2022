package pl.diakowski.FirstDay;

import java.util.ArrayList;

public class Elf {
    private ArrayList<Integer> calories = new ArrayList<>();


    public Elf() {
    }

    public ArrayList<Integer> getCalories() {
        return calories;
    }

    public void setCalories(ArrayList<Integer> calories) {
        this.calories = calories;
    }

    public void addToList(int number) {
        calories.add(number);
    }
}
