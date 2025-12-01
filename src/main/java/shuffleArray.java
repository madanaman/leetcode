import java.util.Arrays;

public class shuffleArray {
    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int grp_idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                result[i] = nums[grp_idx];
            }
            if (i % 2 != 0) {
                result[i] = nums[n + grp_idx];
                grp_idx++;
            }
        }
//        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String args[]) {
        int[] input = new int[]{2, 5, 1, 3, 4, 7};
        shuffle(input, 3);
    }
}
