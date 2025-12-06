package quest.monotonicstack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class finalPriceWithSpecialDiscount {
    public int[] finalPrices1(int[] prices) {
        int[] result = new int[prices.length];
        for (int i=0;i<prices.length;i++){
            Integer next_min_price = null;
            boolean next_min_found = false;
            for (int j=i+1;j<prices.length;j++){
                if(prices[j]<=prices[i]){
                    next_min_price=prices[j];
                    next_min_found=true;
                    break;
                }
            }
            result[i]=(next_min_found)?(prices[i]-next_min_price):prices[i];
        }
        return result;
    }
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = Arrays.copyOf(prices,n);
        Deque<Integer> stack =  new ArrayDeque<>();

        for (int i=0;i<n;i++){
            while(!stack.isEmpty() && prices[i]<=prices[stack.peek()]){
                int idx = stack.pop();
                result[idx]=prices[idx]-prices[i];
            }
            stack.push(i);
        }
        return result;
    }
}
