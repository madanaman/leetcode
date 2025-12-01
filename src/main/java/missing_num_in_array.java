import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class missing_num_in_array {
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> missing_nums= new ArrayList<>();
        int[] freq = new int[nums.length];
        for(int num:nums){
            freq[num-1]++;
        }
        for(int i=0;i<nums.length;i++){
            if(freq[i]==0){
                missing_nums.add(i+1);
            }
        }
        return missing_nums;
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            int idx = Math.abs(num) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }

        // Positive values indicate missing numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1}));
    }
}
