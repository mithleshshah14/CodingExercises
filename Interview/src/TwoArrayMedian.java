import java.util.Arrays;

public class TwoArrayMedian {
    public static void main(String[] args) {

        int[] num1 = {1,2};
        int[] num2 = {3,4};
        System.out.printf("Val  "+findMedianSortedArrays(num1,num2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] n = new int[nums1.length+nums2.length];
        int k = 0;

        for(int i = 0; i<nums1.length;i++)
        {
            n[k] = nums1[i];
            k++;
        }

        for(int i = 0; i<nums2.length;i++)
        {
            n[k] = nums2[i];
            k++;
        }

        Arrays.sort(n);
        int mid = n.length / 2;
        return n.length%2==0?(n[mid]+n[mid-1])/2.0:n[mid];
    }
}
