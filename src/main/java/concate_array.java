import java.util.Arrays;

public class concate_array {
        public static int[] getConcatenation(int[] nums) {
            int l = nums.length * 2;
            int original_array_len = nums.length;
            int[] result_array = new int[l];
            for (int i=0; i<nums.length;i++){
                result_array[i]=nums[i];
                result_array[original_array_len+i]=nums[i];
            }
//            System.out.println(Arrays.toString(result_array));
            return result_array;
        }
        public static void main(String args[]){
            getConcatenation(new int[]{1,2,3});
        }
    }
