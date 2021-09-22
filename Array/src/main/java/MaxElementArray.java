class MaxElementArray {

    public static void main(String[] args) {
        int[] arr = {-1,-2,-5,-3,-7};
        int val = getMaxElement(arr);
        System.out.println(val);
    }

    private static int getMaxElement(int[] arr) {

        if (arr.length == 0) {
            return 0;
        }

        int val = arr[0];

        for (int i = 0; i < arr.length; i++){

            if (val < arr[i])
                val = arr[i];
        }

        return val;
    }
}