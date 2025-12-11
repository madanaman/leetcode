package quest.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class unableToEatLunchTest {
    private unableToEatLunch processor;
    @BeforeEach
    void setUp() {
        processor= new unableToEatLunch();
    }

    @Test
    void countStudents() {
        int[] ip_student = new int[]{1,1,0,0};
        int[] ip_sandwich = new int[]{0,1,0,1};
        int expected = 0;
        int actual = processor.countStudents(ip_student, ip_sandwich);
        assertEquals(expected, actual);
    }

    @Test
    void countStudents1() {
        int[] ip_student = new int[]{1,1,1,0,0,1};
        int[] ip_sandwich = new int[]{1,0,0,0,1,1};
        int expected = 3;
        int actual = processor.countStudents(ip_student, ip_sandwich);
        assertEquals(expected, actual);
    }
}