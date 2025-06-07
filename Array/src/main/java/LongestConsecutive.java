import java.util.Arrays;
import java.util.Stack;

/**
 * @author mithl
 * @date 28-05-2025
 * @email mithleshshah84@gmail.com
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        int[] nums =  {0,3,2,5,4,6,1,1};
        System.out.println(longestConsecutive(nums)); // Output: 5
        String s = "No lemon, no melon";
        System.out.println(isPalindrome(s)); // Output: true

        int[] heights = {1,7,2,5,12,3,500,500,7,8,4,7,3,6};
        System.out.println(maxArea(heights)); // Output: 5000
        int[] maxHeights = {1, 5, 4, 5};
        System.out.println(maxProduct(maxHeights)); // Output: 5000

        System.out.println(validString("(*))")); // Output: true

    }


    public static int longestConsecutive(int[] a) {
        Arrays.sort(a);
        int maxCount = 0;
        int currentCount = 1;
        for(int i = 0; i < a.length - 1; i++) {
            if (a[i+1] - a[i] == 1) {
                currentCount++;
            }
            else if(a[i+1] != a[i]) { // Check for duplicates
                if(currentCount > maxCount) {
                    maxCount = currentCount; // +1 to include the current element
                }
                currentCount = 1; // Reset count for the next sequence
            }
        }

        if(currentCount > maxCount) {
            maxCount = currentCount;
        }
        return maxCount;
    }

    public static boolean isPalindrome(String s) {
        int[] arr = {1,2};

        if(s.length() <=1) {
            return true;
        }

        s = s.replaceAll("[^A-Za-z0-9]", "");
        s = s.toLowerCase();
        System.out.print(s);

        int i = 0;
        int j = s.length()-1;

        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;

    }

    public static int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int max = 0;
        while(left <= right) {
            int val = Math.min(heights[left], heights[right]) * (right-left);
            if(max < val){
                max = val;
            }
            if(heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;

    }

    public static int maxProduct(int[] heights) {

        if(heights.length == 0) {
         return 0;
        }

        if (heights.length <=1) {
           return heights[0];
       }

        int i = 0;
        int j = 1;
        int maxProduct = 0;
        while(i < j) {

            if(j == heights.length && i < heights.length - 2){
                i++;
                j = i + 1;
            } else {
                int product = heights[i] * heights[j];
                if(product > maxProduct) {
                    maxProduct = product;
                }
                j++;
            }
        }
        return maxProduct;

    }


    public static boolean validString(String s) {
        if(s == null || s.isEmpty()) {
            return true;
        }

        if(s.length() % 2 == 1) {
            s = s.replaceAll("[^()]", "");
        }

        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()) {
            if(c =='(' || c== '*') {
                stack.push(c);
            } else if(c == ')') {
                if(stack.isEmpty() || (stack.peek() != '(' && stack.peek() != '*')) {
                    return false;
                }
                stack.pop();
            }
        }

        while(!stack.isEmpty()) {
            char top = stack.peek();
            if (top == '*') {
                stack.pop();
            } else {
                return false;
            }
        }

        return true;
    }


}
