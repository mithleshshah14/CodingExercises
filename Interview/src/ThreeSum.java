import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {


        public List<List<Integer>> threeSum(int[] nums) {

            ArrayList<List<Integer>> lists = new ArrayList<>();

            if (nums.length < 3) {
                return lists;
            }

            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {

                if (nums[i] > 0) {
                    break;
                }

                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int left = i + 1, right = nums.length - 1;

                while (left < right) {

                    if(right<nums.length-1 && nums[right] == nums[right+1]) {
                        right--;
                        continue;
                    }

                    if (nums[i] + nums[left] + nums[right] == 0) {

                        lists.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        left++;
                        right--;
                    } else if (nums[i] + nums[left] + nums[right] > 0) {

                        right--;
                    } else {

                        left++;
                    }
                }
            }
            return lists;

        }

}
