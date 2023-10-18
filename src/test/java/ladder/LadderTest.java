package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderTest {

    @Test
    @DisplayName("선이 없는 경우 그대로 반환할 수 있다.")
    void testClimbWhenNoLine() {
        Ladder ladder = new Ladder(1, 3);

        assertEquals(0, ladder.climb(0));
        assertEquals(2, ladder.climb(2));
    }

    @Test
    @DisplayName("선이 1개가 좌측으로 그어져 있는 경우")
    void testClimbWhenLineLeft() {
        // 0 1 1
        Ladder ladder = new Ladder(1, 3);
        ladder.drawLine(0, 1);
        assertEquals(1, ladder.climb(2));

        // 1 1 0
        ladder = new Ladder(1, 3);
        ladder.drawLine(0, 0);
        assertEquals(0, ladder.climb(1));
    }

    @Test
    @DisplayName("선이 1개가 우측으로 그어져 있는 경우")
    void testClimbWhenLineRight() {
        // 0 1 1
        Ladder ladder = new Ladder(1, 3);
        ladder.drawLine(0, 1);
        assertEquals(2, ladder.climb(1));

        // 1 1 0
        ladder = new Ladder(1, 3);
        ladder.drawLine(0, 0);
        assertEquals(1, ladder.climb(0));
    }

    @Test
    void testClimbWhenMultiRows() {
        // 1 1 0 0
        // 0 1 1 0
        // 0 0 1 1
        Ladder ladder = new Ladder(3, 4);

        ladder.drawLine(0, 0);
        ladder.drawLine(1, 1);
        ladder.drawLine(2, 2);

        assertEquals(3, ladder.climb(0));
        assertEquals(0, ladder.climb(1));
        assertEquals(1, ladder.climb(2));
        assertEquals(2, ladder.climb(3));
    }
}
