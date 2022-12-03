package pl.diakowski.ThirdDay;

public class Char {
    private char character;

    public Char() {
    }

    public Char(char character) {
        this.character = character;
    }

    public int calculateWage() {
        if (Character.isLowerCase(character)) {
            return 96 - (int) character;
        } else {
            return 38 - (int) character;
        }
    }
}
