/**
 * @author mithl
 * @date 06-10-2024
 * @email mithleshshah84@gmail.com
 */
public class MaxProfit {

    public static int maxProfit(int[] prices) {
        int r = 0, l = 0, i=0, val = 0;

        r = prices[i];
        l = prices[i];
        while(i<prices.length) {
            val = Math.max(val,(l-r));
            if(prices[i]<r) {
                r = prices[i];
            }

            l = prices[i];
            i++;
        }

        val = Math.max(val, (l-r));


        return val;
    }

    public static void main(String[] args) {
       int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

}
