import java.util.ArrayList;
import java.util.List;

/**
 * @author mithl
 * @date 06-06-2025
 * @email mithleshshah84@gmail.com
 */
public class GenerateParanthesis1 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int n) {
        // If we've used n pairs (2n chars), add the track to the playlist
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // Add an opening '(' if we haven't used all n yet
        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }

        // Add a closing ')' if we have an unmatched '(' to close
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }

    public static void main(String[] args) {
        GenerateParanthesis1 generator = new GenerateParanthesis1();
        int n = 3; // Example input
        List<String> result = generator.generateParenthesis(n);
        System.out.println(result); // Output the generated parentheses combinations
    }
}
