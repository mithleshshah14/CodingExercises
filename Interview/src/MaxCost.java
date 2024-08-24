public class MaxCost {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 3;
        int mx = 10;
        int max_cost = 20;

        int count = 0;
        int cost = 0;
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < mx) {
                cost = mx - arr[i];
                sum += cost;

                if (sum <= max_cost) {
                    arr[i] = mx;
                    count++;
                } else {
                    break;
                }
            }
        }

        int extra_cost = 0;
        for (int i = 0; i < arr.length && sum <= max_cost; i++) {
            if (arr[i] != mx) {
                extra_cost = k + mx - arr[i];
                if (extra_cost <= max_cost - sum) {
                    arr[i] = mx;
                    count++;
                    sum += extra_cost;
                } else {
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
