import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {

    public static void main(String[] args) {
        List<List<Integer>> multiList;
        int[] nums = {1,2,3};

        SubsetSolutionII solution = new SubsetSolutionII();
        multiList = solution.subsetsWithDup(nums);

        for(List<Integer> l : multiList) {
            System.out.println(l);
        }
    }
}


// Similar to subsets 1. Here, we'll just take care of the duplicates.
class SubsetSolutionII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        subSet(nums, 0, ans, list);
        return ans;
    }

    public void subSet(
            int[] nums,
            int idx,
            List<List<Integer>> ans,
            List<Integer> list
    ) {
        ans.add(new ArrayList<>(list));

        for (int i = idx; i < nums.length; i++) {
            //skip the duplicate elements
            if (i > idx && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            subSet(nums, i + 1, ans, list);
            list.remove(list.size() - 1);
        }
    }
}

