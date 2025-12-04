package quest.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class functionExclusiveTimeTest {
    private functionExclusiveTime processor;

    @BeforeEach
    public void setUp() {
        processor = new functionExclusiveTime();
    }
    @Test
    public void testSequentialLogs() {
        int n = 2; // Number of processes (0 and 1)
        List<String> logs = Arrays.asList(
                "0:start:0",
                "1:start:2",
                "1:end:5", // 3 units
                "0:end:6"  // 1 unit
        );
        int[] expected = {3, 4};
        int[] actual = processor.exclusiveTime(n, logs);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test2() {
        int n = 1; // Number of processes (0 and 1)
        List<String> logs = Arrays.asList(
                "0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"
        );
        int[] expected = {8};
        int[] actual = processor.exclusiveTime(n, logs);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test3() {
        int n = 2; // Number of processes (0 and 1)
        List<String> logs = Arrays.asList(
                "0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"
        );
        int[] expected = {7,1};
        int[] actual = processor.exclusiveTime(n, logs);
        assertArrayEquals(expected, actual);
    }

}