package ladder;

public class Row {

    private int[] persons;

    public Row(final int numberOfPeople) {
        this.persons = new int[numberOfPeople];
    }

    public void draw(final int position) {
        persons[position] = 1;
        persons[position + 1] = 1;
    }

    public int climb(final int numberOfPerson) {
        if (isNoLine(numberOfPerson)) {
            return numberOfPerson;
        }
        if (!isLeftEnd(numberOfPerson) && canMoveLeft(numberOfPerson)) {
            return numberOfPerson - 1;
        }
        return numberOfPerson + 1;
    }

    private static boolean isLeftEnd(final int numberOfPerson) {
        return numberOfPerson - 1 < 0;
    }

    private boolean canMoveLeft(final int numberOfPerson) {
        return persons[numberOfPerson - 1] == 1;
    }

    private boolean isNoLine(final int numberOfPerson) {
        return persons[numberOfPerson] == 0;
    }
}
