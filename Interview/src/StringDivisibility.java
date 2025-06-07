import java.util.*;

/**
 * @author mithl
 * @date 13-10-2024
 * @email mithleshshah84@gmail.com
 */
public class StringDivisibility {

    public boolean isDevisible(String s, String t) {
        int k = 0;
        for(int i = 0; i<s.length(); i++) {
            if (s.charAt(i) == t.charAt(k) ) {
                k++;
            } else {
                return false;
            }
        }
        Map<Integer, Integer> integerMap = new HashMap<>();

        return true;
    }

    public static void main(String[] args) {
        String s = "4:neet4:code4:love3:you";
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            // Find the delimiter
            int delimiterIndex = s.indexOf(':', i);
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("Invalid encoded string");
            }
            // Extract the length
            int length = Integer.parseInt(s.substring(i, delimiterIndex));
            // Extract the string
            String str = s.substring(delimiterIndex + 1, delimiterIndex + 1 + length);
            result.add(str);
            // Move to the next part
            i = delimiterIndex + 1 + length;
        }
    }
}
