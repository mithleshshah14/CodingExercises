public class StringToInteger {

    public static void main(String[] args) {

        String s = "4193 with words";
        int n = getResult(s);
        System.out.println(n);
        s = "00000-42a1234";

        int x = -123;
        String sss = ""+x;

        char[] ch = sss.toCharArray();
      //  System.out.println(myAtoi(s));
        String ss = s;
        System.out.println(getResult(ss));
    }


    public static int getResult(String s) {
        double result = 0;
        boolean isNegative = false;
        int len = s.length();

        int start = 0, end = len - 1;
        //removal of leading whitespaces
        while(start < len && s.charAt(start) == ' '){
            start++;
        }
        //removal of trailing whitespaces
        while(end > start && s.charAt(end) == ' '){
            end--;
        }

        if(start > end)return 0;

        //cheking the first character after removing the leading spaces
        char ch = s.charAt(start);
        if(ch == '-'){
            isNegative = true;
        }else if(ch == '+'){
            isNegative = false;
        }else if(ch <= '9' && ch >= '0'){
            result = ch - '0';
        }else{
            return 0;
        }

        //checking the rest of the characters to calculate result
        for(int i = start + 1; (i <= end && s.charAt(i) <= '9' && s.charAt(i) >= '0'); i++){
            result = result * 10 + s.charAt(i) - '0';
        }

        //if the first character was -, then the result is negative.
        if(isNegative){
            result = 0 - result;
        }

        //checking if the result lies between min and max int
        if(result < Integer.MIN_VALUE)return Integer.MIN_VALUE;
        else if(result > Integer.MAX_VALUE)return Integer.MAX_VALUE;

        return (int)result;
    }
}
