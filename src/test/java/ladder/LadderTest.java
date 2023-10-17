package ladder;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderTest {

    @Test
    @DisplayName("선이 그어져 있지 않으면 그대로 반환한다.")
    void testClimbWhenNoLine() {
        Ladder ladder = new Ladder(2);
        assertEquals(1, ladder.climb(1));
        assertEquals(2, ladder.climb(2));
    }

    @Test
    @DisplayName("높이가 1, 참여자가 2명일 때 선이 그어져 있는 경우")
    void testClimbWhenTwoByOne_Line() {
        Ladder ladder = new Ladder(2);
        ladder.drawLine(0);
        assertEquals(2, ladder.climb(1));
        assertEquals(1, ladder.climb(2));
    }

    @ParameterizedTest
    @MethodSource("generatePositions")
    @DisplayName("높이가 1, 참여자가 3명일 때 선이 그어져 있는 경우")
    void testClimbWhenThreeByOne_Line(
        final int startPosition,
        final List<Integer> positions
    ) {
        Ladder ladder = new Ladder(3);
        ladder.drawLine(startPosition);

        for (int i = 0; i < positions.size(); i++) {
            assertEquals(positions.get(i), ladder.climb(i + 1));
        }
    }

    public static Stream<Arguments> generatePositions() {
        return Stream.of(
            Arguments.of(0, List.of(2, 1, 3)),
            Arguments.of(1, List.of(1, 3, 2))
        );
    }
}
