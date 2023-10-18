package ladder;

import java.util.Arrays;

public class Ladder {

    private final int[] rows;

    public Ladder(int height, int numberOfPeople) {
        this.rows = new int[numberOfPeople];
    }

    public void drawLine(int numberOfPeople) {
        rows[numberOfPeople] = 1;
        rows[numberOfPeople + 1] = 1;
    }

    public int climb(int numberOfPeople) {

        if (numberOfPeople + 1 <= rows.length && rows[numberOfPeople + 1] == 1) {
            return numberOfPeople + 1;
        }
        return 2;
    }
}
