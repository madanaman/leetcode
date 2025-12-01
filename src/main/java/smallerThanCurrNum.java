import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class smallerThanCurrNum {
    public static int[] smallerNumbersThanCurrent1(int[] nums) {
        HashMap<Integer, Integer> count_keeper= new HashMap<>();
        int[] result = new int[nums.length];
        for (int i=0;i<nums.length;i++){
            int element = nums[i];
            int less_counter = 0;
            for (int j=0;j<nums.length;j++){
                if (j==i){
                    continue;
                }
                if (nums[j]<element){
                    less_counter++;
                }
            }
            result[i]=less_counter;
        }
        return result;
    }
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] freq = new int[101];
        for(int num:nums){
            freq[num]++;
        }
        for (int i=1;i<101;i++){
            freq[i]=freq[i]+freq[i-1];
        }
        int[] result= new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            if (num==0){
                result[i]=0;
            } else{
                result[i]=freq[num-1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{7,7,7,7})));
    }
}
