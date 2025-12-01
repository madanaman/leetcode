package quest.array1;

public class max_consecutive_ones {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max_counter = 0;
        int curr_counter = 0;
        boolean prev_one = false;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==1){
                curr_counter++;
                if(curr_counter>max_counter){
                    max_counter=curr_counter;
                }
            } else {
                curr_counter=0;
            }

        }
//        System.out.println(max_counter);
        return max_counter;
    }

    public static void main(String args[]){
        findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1});
    }
}
