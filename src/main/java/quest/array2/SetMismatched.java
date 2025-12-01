package quest.array2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMismatched {
    public static int[] find_mismatch1(int[] nums){
        Arrays.sort(nums);
        HashSet<Integer> existing = new HashSet<>(nums.length);
        int[] result = new int[2];
        int dup = -1;
        int dup_idx=-1;
        int missing_ele = -1;
        for (int i=0;i<nums.length;i++){
            if (existing.contains(nums[i])){
                dup = nums[i];
                dup_idx = i;
                break;
            }
            existing.add(nums[i]);
        }
        result[0]=dup;
        if (dup_idx - 1 ==0 && dup==1){
            missing_ele = dup + 1;
        }
        if (dup_idx - 1 ==0 && dup==2){
            missing_ele = dup - 1;
        }
        if (dup_idx - 2 >=0 && dup-nums[dup_idx-2]==2){
            missing_ele = dup-1;
        }
        if (dup_idx - 2 >=0 && dup-nums[dup_idx-2]==1){
            missing_ele = dup+1;
        }
        result[1]=missing_ele;
        return result;

    }
    public static int[] find_mismatch(int[] nums){
        int[] result = new int[2];
        int dup=-1;
        int missing_ele=-1;
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            if (nums[i]-1 != i){
                dup=nums[i];
                missing_ele=i;
                break;
            }
        }
        result[0]=dup;
        result[1]=missing_ele;

        return result;

    }
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(find_mismatch(new int[]{1,1})));
//        System.out.println(Arrays.toString(find_mismatch(new int[]{2,2})));
//        System.out.println(Arrays.toString(find_mismatch(new int[]{1,2,2,4})));
//        System.out.println(Arrays.toString(find_mismatch(new int[]{1,3,3})));
//        System.out.println(Arrays.toString(find_mismatch(new int[]{3,2,2})));
        System.out.println(Arrays.toString(find_mismatch(new int[]{3,2,3,4,6,5})));

    }
}
