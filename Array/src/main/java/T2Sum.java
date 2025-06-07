import java.util.*;

/**
 * @author mithl
 * @date 20-01-2025
 * @email mithleshshah84@gmail.com
 */
public class T2Sum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> has = new HashMap<>();
        int[] val = new int[2];
        has.put(target-nums[0],0);
        for(int i = 1; i<nums.length; i++){
            if(has.containsKey(nums[i])) {
                val[0] = has.get(nums[i]);
                val[i] = i;
                return val;
            } else {
                has.put(target-nums[i], i);
            }
        }
        return val;

    }

    public static void main(String[] args) {
       int[] nums = new int[]{4,5,6};
       int target = 10;
       //Arrays.stream(twoSum(nums, target)).forEach(System.out::println);

        Map<Integer, Integer> nMap = new HashMap<>();

        Set<Integer> integers = nMap.keySet();
       // Collections.sort(integers, Comparator.reverseOrder());


        char[] c = {'a','b','c','d'};
       String val = new String(c);
        System.out.println(val);
    }
}
