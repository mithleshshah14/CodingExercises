public class ReverseInteger {

    public static void main(String[] args) {

        int x = 1534236469;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {

        int temp = 0, temp2 = 0;
        long val = 0;
        boolean bool = false;

        if(x<0){
            bool = true;
            x = -(x);
        }


        while(x>0){
            temp = x %10;
            x= x/10;
            val = val*10+temp;

        }

        if(val > Integer.MAX_VALUE || val<Integer.MIN_VALUE) {
            temp2 = 0;
        } else {
            temp2 = Math.toIntExact(val);
        }

        if(bool){
            temp2 = -(temp2);
        }

        return temp2;
    }
}
