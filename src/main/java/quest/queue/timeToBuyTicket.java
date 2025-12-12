package quest.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class timeToBuyTicket {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Deque<int[]> q = new ArrayDeque<>();

        // store: [remainingTickets, originalIndex]
        for (int i = 0; i < tickets.length; i++) {
            q.add(new int[]{tickets[i], i});
        }

        int time = 0;

        while (!q.isEmpty()) {
            time++;
            int[] person = q.pollFirst();
            person[0]--;  // bought 1 ticket

            // If this person has finished AND is k, return time
            if (person[0] == 0 && person[1] == k) {
                return time;
            }

            // If not done, re-add them
            if (person[0] > 0) {
                q.addLast(person);
            }
        }

        return time;
    }
}
