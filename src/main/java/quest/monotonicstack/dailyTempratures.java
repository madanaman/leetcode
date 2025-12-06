package quest.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

public class dailyTempratures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0;i<n;i++){
            while (!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int prev_idx = stack.pop();
                result[prev_idx]=i-prev_idx;
            }
            stack.push(i);

        }
        return result;
    }
}
