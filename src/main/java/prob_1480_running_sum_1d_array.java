import java.util.Arrays;

public class prob_1480_running_sum_1d_array {
    public static int[] solve(int[] nums){
        int[] results = new int[nums.length];
        int curr_sum= 0;
        for (int i=0;i< nums.length;i++){
            curr_sum+=nums[i];
            results[i]=curr_sum;
//            System.out.println(curr_sum);
        }
//        System.out.println(Arrays.toString(results));
        return results;
    }
    public static void main(String args[]){
        int[] sample = {3,1,2,10};
        solve(sample);
    }
}
