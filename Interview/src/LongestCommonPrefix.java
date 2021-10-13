public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] s = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(s));
    }


    public static String longestCommonPrefix(String[] strs) {

        char[] c = strs[0].toCharArray();
        int k = 0, count = 0;
        boolean bool = false;
        while(k<c.length){

            for(int i = 1; i<strs.length;i++) {
                if(k != strs[i].length() && strs[i].charAt(k) == c[k]) {
                    bool = true;
                } else {
                    bool = false;
                    break;
                }
            }

            if(bool == true) {
                count++;
            } else {
                break;
            }
            k++;
        }

        return strs[0].substring(0,count);
    }
}
