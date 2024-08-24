import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParanthesisRearrange {

    public static void main(String[] args) {
        String paranthesis = "{]([})]{]([})]";
        Queue<Character> queue = new LinkedList<>();

        StringBuilder res = new StringBuilder();

        for(char c : paranthesis.toCharArray()) {
            if(c == '{' || c == '(' || c == '[') {
                queue.add(c);
            }
        }



        while (!queue.isEmpty())
        {
            char c = queue.remove();

            for(int i = 0; i<paranthesis.length(); i++) {
                if(c == '{' && paranthesis.charAt(i) == '}') {
                    res.append(c).append(paranthesis.charAt(i));
                }
                else if(c == '[' && paranthesis.charAt(i) == ']') {
                    res.append(c).append(paranthesis.charAt(i));
                }
                else if(c == '(' && paranthesis.charAt(i) == ')') {
                    res.append(c).append(paranthesis.charAt(i));
                }

            }

        }

        System.out.println(res);



    }
}
