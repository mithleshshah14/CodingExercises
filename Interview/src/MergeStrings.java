/**
 * @author mithl
 * @date 24-08-2024
 * @email mithleshshah84@gmail.com
 */
public class MergeStrings {

    public static String mergeAlternately(String word1, String word2) {
        int i = 0;
        int len = Math.min(word1.length(), word2.length());
        StringBuilder s = new StringBuilder();

        while(i < len) {
            s.append(word1.charAt(i));
            s.append(word2.charAt(i));
            i++;
        }

        s.append(word1.substring(i));
        s.append(word2.substring(i));

        return s.toString();
    }

    public static void main(String[] args) {
       String word1 = "abcd", word2 = "pq";
        System.out.println(mergeAlternately(word1,word2));
    }
}
