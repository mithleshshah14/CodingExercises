import java.util.ArrayList;
import java.util.List;

public class TwoSum {


        public static int[] twoSum(int[] nums, int target) {

            List<Integer> numList = new ArrayList<>();
            int index;
            int[] val = new int[2];

            for(int i = 0; i<nums.length; i++){

                if(numList.contains(nums[i])){
                    index = numList.indexOf(nums[i]);
                    val[0] = index;
                    val[1] = i;
                    break;
                } else {
                    numList.add(target - nums[i]);
                }

            }
            return val;
    }

    public static void main(String[] args) {
        int[] val = {3,2,4};
            int[] val2 = twoSum(val,6);
            for(int i = 0; i<2 ; i++){
                System.out.println(val2[i]);
            }
    }
}
