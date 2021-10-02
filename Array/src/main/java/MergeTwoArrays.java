public class MergeTwoArrays {

    public static void main(String[] args) {
        int[] a = {0,3,4,31};
        int[] b = {3,4,6,30};
        int[] c = mergeArrays(a,b);

        for (int d:c
             ) {
            System.out.println(d);
        }
    }

    public static int[] mergeArrays(int[] a, int[] b){
        int[] c  = new int[a.length+b.length];

        int len1 = a.length;
        int len2 = b.length;
        int i = 0, j = 0, k=0;

        for(k = 0; k<c.length;k++) {

            if( i == len1 ) {
                c[k] = b[j];
                j++;
            } else if(j == len2){
                c[k] = a[i];
                i++;
            }

            if(i<len1 && j<len2 && a[i]<b[j]) {
                c[k] = a[i];
                i++;
            } else if(j<len2){
                c[k] = b[j];
                j++;
            }


        }

        return c;
    }
}
