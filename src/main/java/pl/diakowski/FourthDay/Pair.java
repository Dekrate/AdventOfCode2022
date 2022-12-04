package pl.diakowski.FourthDay;

import java.util.ArrayList;

public class Pair {
    private ArrayList<Elf> elves = new ArrayList<>();


    public Pair(ArrayList<Elf> elves) {
        this.elves = elves;
    }

    public Pair() {
    }

    public void add(Elf elf) {
        elves.add(elf);
    }

    public boolean checkIfOneContainAnother() { // although it's easier to make by negating the fact of not containing each other
        if (elves.get(0).getBegin() < elves.get(1).getBegin() && elves.get(0).getEnd() > elves.get(1).getEnd()) { // 1.1 2.2 2.3 1.4
            return true;
        } else if (elves.get(1).getBegin() < elves.get(0).getBegin() && elves.get(1).getEnd() > elves.get(0).getEnd()) { // 2.1 1.2 1.3 2.4
            return true;
        } else if (elves.get(0).getBegin() <= elves.get(1).getBegin() && elves.get(0).getEnd() >= elves.get(1).getEnd()) {
            return true;
        } else return elves.get(1).getBegin() <= elves.get(0).getBegin() && elves.get(1).getEnd() >= elves.get(0).getEnd();
    }

    public boolean checkComplement() {
        return elves.get(0).getEnd() >= elves.get(1).getBegin() && elves.get(1).getEnd() >= elves.get(0).getBegin();
    }
}
