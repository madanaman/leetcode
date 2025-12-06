package quest.monotonicstack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class dailyTempraturesTest {
    private dailyTempratures processor;
    @BeforeEach
    void setUp() {
        processor = new dailyTempratures();
    }

    @Test
    void dailyTemperatures() {
        int[] input = new int[]{73,74,75,71,69,72,76,73};
        int[] expected = new int[]{1,1,4,2,1,1,0,0};
        int[] actual = processor.dailyTemperatures(input);
        assertArrayEquals(expected,actual);
    }

    @Test
    void test2() {
        int[] input = new int[]{30,40,50,60};
        int[] expected = new int[]{1,1,1,0};
        int[] actual = processor.dailyTemperatures(input);
        assertArrayEquals(expected,actual);
    }

    @Test
    void test3() {
        int[] input = new int[]{30,60,90};
        int[] expected = new int[]{1,1,0};
        int[] actual = processor.dailyTemperatures(input);
        assertArrayEquals(expected,actual);
    }
}