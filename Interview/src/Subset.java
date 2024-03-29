import java.util.ArrayList;
import java.util.List;

public class Subset {

    public static void main(String[] args) {
        List<List<Integer>> multiList;
        int[] nums = {1,2,3};

        SubsetSolution solution = new SubsetSolution();
        multiList = solution.subsets(nums);

        for(List<Integer> l : multiList) {
            System.out.println(l);
        }
    }
}


// The idea is to have two conditions:
// One in which we will take the element into consideration,
// Second in which we won't take the element into consideration.
class SubsetSolution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(ans, 0, nums, list);
        return ans;
    }

    public void helper(
            List<List<Integer>> ans,
            int start,
            int[] nums,
            List<Integer> list
    ) {
        if (start >= nums.length) {
            ans.add(new ArrayList<>(list));
        } else {
            // add the element and start the  recursive call
            list.add(nums[start]);
            helper(ans, start + 1, nums, list);
            // remove the element and do the backtracking call.
            list.remove(list.size() - 1);
            helper(ans, start + 1, nums, list);
        }
    }
}

