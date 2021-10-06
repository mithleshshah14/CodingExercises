public class Container {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
            int x = height.length-1;
            int i = 0, a = 0, b = 0;
            int mul = 0, avg = 0;

            while(i<x) {
                a= height[i];
                b=height[x];

                if(a < b) {

                    mul = a*(x-i);

                    i++;
                } else {
                    mul = b*(x-i);
                    x--;
                }

                if(mul>avg){
                    avg = mul;
                }

            }



            return avg;
        }
    }

