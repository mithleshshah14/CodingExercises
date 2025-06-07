import java.util.HashMap;
import java.util.Map;

/**
 * @author mithl
 * @date 24-08-2024
 * @email mithleshshah84@gmail.com
 */
public class RomanToInteger {

    public static int romanToInt(String s) {
        Map<String, Integer> roman = new HashMap<>();
        roman.put("I",1);
        roman.put("V",5);
        roman.put("X",10);
        roman.put("L",50);
        roman.put("C",100);
        roman.put("D",500);
        roman.put("M",1000);

        int total = 0;
        int k = 0;
        int j = 0;
        while( k <s.length()) {
            int val1 = roman.get(String.valueOf(s.charAt(k)));
            int val2 =  roman.get(String.valueOf(s.charAt(j)));

                if(val1 > val2) {
                    total = total - val2;
                    val1 = val1 - val2;
                } else if(val1 < val2) {
                    j = k;
                }
            total = total + val1;
            k++;
        }

        return total;
    }

    public static void main(String[] args) {
    String val = "III";
        System.out.println(romanToInt(val));
    }
}
