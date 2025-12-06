package quest.monotonicstack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import quest.stack.functionExclusiveTime;

import static org.junit.jupiter.api.Assertions.*;

class finalPriceWithSpecialDiscountTest {

    private finalPriceWithSpecialDiscount processor;
    @BeforeEach
    void setUp() {
        processor = new finalPriceWithSpecialDiscount();
    }

    @Test
    void finalPrices() {
        int[] input = {8,4,6,2,3};
        int[] expected = {4,2,4,2,3};
        int [] actual = processor.finalPrices(input);
        assertArrayEquals(actual, expected);
    }

    @Test
    void test2() {
        int[] input = {1,2,3,4,5};
        int[] expected = {1,2,3,4,5};
        int [] actual = processor.finalPrices(input);
        assertArrayEquals(actual, expected);
    }

    @Test
    void test3() {
        int[] input = {10,1,1,6};
        int[] expected = {9,0,1,6};
        int [] actual = processor.finalPrices(input);
        assertArrayEquals(actual, expected);
    }
}