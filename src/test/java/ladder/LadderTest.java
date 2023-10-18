package ladder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    @DisplayName("사다리의 우측으로 이동할 수 있다.")
    void testClimbWhenMoveLeft() {
        // 1 1
        Ladder ladder = new Ladder(1, 2);
        ladder.drawLine(0);
        assertEquals(1, ladder.climb(0));

        // 0 1 1
        ladder = new Ladder(1, 3);
        ladder.drawLine(1);
        assertEquals(2, ladder.climb(1));

        // 0 1 1 1 1
        ladder = new Ladder(1, 5);
        ladder.drawLine(1);
        ladder.drawLine(3);
        assertEquals(2, ladder.climb(1));
        assertEquals(4, ladder.climb(3));
    }
}
