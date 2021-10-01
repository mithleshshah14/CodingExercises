import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ZigZagConversion {
    public static void main(String[] args) {
        String s = "AB";
        String crList = convert(s,1);


        System.out.println(crList);

    }

    public static String convert(String s, int numRows) {

        String ss = "";

        if (numRows == 1)
        {
            return s;
        }
        char[] str1 = s.toCharArray();

        // Find length of string
        int len = s.length();

        // Create an array of
        // strings for all n rows
        String[] arr = new String[numRows];
        Arrays.fill(arr, "");

        // Initialize index for
        // array of strings arr[]
        int row = 0;
        boolean down = true; // True if we are moving
        // down in rows, else false

        // Traverse through
        // given string
        for (int i = 0; i < len; ++i)
        {
            // append current character
            // to current row
            arr[row] += (str1[i]);

            // If last row is reached,
            // change direction to 'up'
            if (row == numRows - 1)
            {
                down = false;
            }

            // If 1st row is reached,
            // change direction to 'down'
            else if (row == 0)
            {
                down = true;
            }

            // If direction is down,
            // increment, else decrement
            if (down)
            {
                row++;
            }
            else
            {
                row--;
            }
        }

        // Print concatenation
        // of all rows
        for (int i = 0; i < numRows; ++i)
        {
            ss = ss + arr[i];
        }

        return ss;
    }
}
