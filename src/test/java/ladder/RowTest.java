package ladder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RowTest {

    @Test
    @DisplayName("선이 없는 경우 그대로 반환할 수 있다.")
    void testClimbWhenNoLine() {
        Row row = new Row(3);
        assertEquals(0, row.climb(0));
        assertEquals(2, row.climb(2));
    }

    @Test
    @DisplayName("선이 1개가 좌측으로 그어져 있는 경우")
    void testClimbWhenLineLeft() {
        // 0 1 1
        Row row = new Row(3);
        row.draw( 1);
        assertEquals(1, row.climb(2));

        // 1 1 0
        row = new Row( 3);
        row.draw(0);
        assertEquals(0, row.climb(1));
    }

    @Test
    @DisplayName("선이 1개가 우측으로 그어져 있는 경우")
    void testClimbWhenLineRight() {
        // 0 1 1
        Row row = new Row( 3);
        row.draw( 1);
        assertEquals(2, row.climb(1));

        // 1 1 0
        row = new Row( 3);
        row.draw( 0);
        assertEquals(1, row.climb(0));
    }
}