package ladder;

public class Row {

    public static final int RIGHT = 1;

    private int[] persons;

    public Row(final int numberOfPeople) {
        this.persons = new int[numberOfPeople];
    }

    public void draw(final int position) {
        persons[position] = 1;
        persons[position + 1] = -1;
    }

    public int climb(final int numberOfPerson) {
        if (isNoLine(numberOfPerson)) {
            return numberOfPerson;
        }
        if (isRightDirection(numberOfPerson)) {
            return numberOfPerson + 1;
        }
        return numberOfPerson - 1;
    }

    private boolean isNoLine(final int numberOfPerson) {
        return persons[numberOfPerson] == 0;
    }

    private boolean isRightDirection(final int numberOfPerson) {
        return persons[numberOfPerson] == RIGHT;
    }
}
