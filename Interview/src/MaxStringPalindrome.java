public class MaxStringPalindrome {

    public static void main(String[] args) {

        String s = "abcbadgf";
        String res = longestPalindrome(s);
        System.out.println("The Palindrome is "+res);

    }

    public static int expandpal(String a,int l,int r) {
        if (a==null || l>r) {
            return 0;
        }while (l>=0 && r<a.length() && a.charAt(l)==a.charAt(r)) {
            l--;r++;
        }return r-l-1;
    }

    public static String longestPalindrome(String a) {
        if (a==null || a.length()<1) {
            return "";
        }int start=0,end=0;
        for (int i=0;i<a.length();i++) {
            int len1=expandpal(a,i,i);
            int len2=expandpal(a,i,i+1);
            int len=Math.max(len1,len2);
            if (len>end-start) {
                start=i-((len-1)/2);
                end=i+(len/2);
            }
        }return (a.substring(start, end+1));

    }


}
