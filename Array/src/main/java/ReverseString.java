public class ReverseString {

    public static void main(String[] args) {

        String s = "Mithlesh Shah";
        String ss = reverseString(s);
        System.out.println(ss);
    }

    public static String reverseString(String s) {

        String ss = "";

        for (int i = s.length()-1; i>=0;i--)
        {
            ss += s.charAt(i);
        }
        return ss;
    }
}
