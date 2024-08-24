import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloWorld2 {

    public static void helper(int i, int[] nums, List<Integer> curSet, List<List<Integer>> subsets) {
        if (i >= nums.length) {
            subsets.add(new ArrayList<>(curSet));
            return;
        }
        // decision to include nums[i]
        curSet.add(nums[i]);
        helper(i + 1, nums, curSet, subsets);
        curSet.remove(curSet.size() - 1);
        // decision NOT to include nums[i]
        helper(i + 1, nums, curSet, subsets);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<Integer> currSet = new ArrayList<>();
        List<List<Integer>> subSet = new ArrayList<>();
      //  helper(0,nums,currSet,subSet);


    //    helper2(1,currSet,subSet,5,2);
        int[] arr = {8154,9139,8194,3346,5450,9190,133,8239,4606,8671,8412,6290};
        System.out.println(mostFrequentEven(arr));
    }

    public static void helper2(int i, List<Integer> curComb, List<List<Integer>> combs, int n, int k) {
        if (curComb.size() == k) {
            combs.add(new ArrayList<>(curComb));
            return;
        }
        if (i > n) {
            return;
        }
        for (int j = i; j < n + 1; j++) {
            curComb.add(j);
            helper2(j + 1, curComb, combs, n, k);
            curComb.remove(curComb.size() -1);
        }
    }

    public static int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> val = new HashMap<>();

        for(int i : nums) {
            if(i %2 == 0)
                val.put(i, val.getOrDefault(i, 0) +1);
        }

        int key = Integer.MAX_VALUE;
        int value = -1;
        for(Map.Entry<Integer, Integer> res : val.entrySet()) {
            if(res.getValue() == value) {
                if(key > res.getKey()) {
                    key = res.getKey();
                }
            }
            if(res.getValue() > value) {
                value = res.getValue();
            }
        }

        return key != Integer.MAX_VALUE ? key : -1;

    }
}
