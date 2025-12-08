package quest.monotonicstack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class maxAreaRectangleHistogramTest {
    private maxAreaRectangleHistogram processor;
    @BeforeEach
    void setUp() {
        processor = new maxAreaRectangleHistogram();
    }

    @Test
    void largestRectangleArea() {
        int[] input = new int[] {2,1,5,6,2,3};
        int expected = 10;
        int output = processor.largestRectangleArea(input);
        assertEquals(output, expected);
    }

}