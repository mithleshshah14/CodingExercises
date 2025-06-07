/**
 * @author mithl
 * @date 26-05-2025
 * @email mithleshshah84@gmail.com
 */
public class ArraySumExcludingSelf {

    public int[] arraySumExcludingSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

         output[0] = 0;
         for (int i = 1; i < n; i++) {
             output[i] = output[i - 1] + nums[i - 1]; //1,2,4,8 --> 0,1,3,7
         }

         int suffixSum = 0;
         for (int i = n - 1; i >= 0; i--) {
             output[i] = suffixSum + output[i]; //7, 11,13,14
             suffixSum = suffixSum + nums[i]; //8, 12, 14, 15
         }

        return output; // [14, 13, 11, 7]
    }
}
