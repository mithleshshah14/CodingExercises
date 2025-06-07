import java.util.Stack;

/**
 * @author mithl
 * @date 04-06-2025
 * @email mithleshshah84@gmail.com
 */
public class ReversePolish {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<Integer>();

       for (int i = 0; i < tokens.length; i++) {
           if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
               int b = stack.pop();
               int a = stack.pop();
               switch (tokens[i]) {
                   case "+":
                       stack.push(a + b);
                       break;
                   case "-":
                       stack.push(a - b);
                       break;
                   case "*":
                       stack.push(a * b);
                       break;
                   case "/":
                       stack.push(a / b);
                       break;
               }
           } else {
               stack.push(Integer.parseInt(tokens[i]));
           }
       }

       return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"1","2","+","3","*","4","-"};
        ReversePolish reversePolish = new ReversePolish();
        System.out.println(reversePolish.evalRPN(tokens));
    }
}
