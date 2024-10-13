import java.util.ArrayList;
import java.util.List;

/**
 * @author mithl
 * @date 09-10-2024
 * @email mithleshshah84@gmail.com
 */
public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right on the top row
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;  // Move the top boundary down

            // Traverse from top to bottom on the right column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;  // Move the right boundary left

            if (top <= bottom) {
                // Traverse from right to left on the bottom row
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;  // Move the bottom boundary up
            }

            if (left <= right) {
                // Traverse from bottom to top on the left column
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;  // Move the left boundary right
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        System.out.println(spiralOrder(matrix));

    }
}
