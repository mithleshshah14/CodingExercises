import java.util.Arrays;

/**
 * @author mithl
 * @date 26-05-2025
 * @email mithleshshah84@gmail.com
 */
public class ArraySumOfLeft {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        Arrays.stream(sumOfLeft(arr)).forEach(System.out::println);
    }

    public static int[] sumOfLeft(int[] arr) {
        int sum = 1;
        int[] result = new int[arr.length];
        result[0] = 1;
        for(int i = 1; i < arr.length; i++) {
            result[i] = sum * arr[i - 1];
           sum = result[i];
        }

        return result;

    }
}
