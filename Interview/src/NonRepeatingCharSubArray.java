import java.util.ArrayList;
import java.util.List;

public class NonRepeatingCharSubArray {

    public static void main(String[] args) {

        String s = "aab";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        List<Character> charList = new ArrayList<>();
        int count = 0;
        int size=0, max = 0;

        if (s.length() ==1){
            return 1;
        }

        for(int i = 0; i<s.length(); i++){
            if(charList.contains(s.charAt(i))) {
                count++;
                i = count-1;
                size = 0;
                charList = new ArrayList<Character>();

            } else {
                charList.add(s.charAt(i));
                size++;
            }

            if(size>max){
                max = size;
            }
        }
        return max;

    }
}
