package quest.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class timeToBuyTicketTest {
    private timeToBuyTicket processor;
    @BeforeEach
    void setUp() {
        processor = new timeToBuyTicket();
    }

    @Test
    void timeRequiredToBuy() {
        int[] tickets = new int[]{2,3,2};
        int k = 2;
        int expected = 6;
        int actual = processor.timeRequiredToBuy(tickets,k);
        assertEquals(expected,actual);
    }

    @Test
    void timeRequiredToBuy1() {
        int[] tickets = new int[]{5,1,1,1};
        int k = 0;
        int expected = 8;
        int actual = processor.timeRequiredToBuy(tickets,k);
        assertEquals(expected,actual);
    }
}