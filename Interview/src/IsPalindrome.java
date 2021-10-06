public class IsPalindrome {
    public static void main(String[] args) {
        int x = -121;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        String s = ""+x;

        int i = 0, j = s.length()-1;
        boolean bool = true;
        while(i<j) {

            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }

        }

        return bool;

    }
}
