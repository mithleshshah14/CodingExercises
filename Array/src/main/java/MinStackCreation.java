import java.util.Stack;

/**
 * @author mithl
 * @date 04-06-2025
 * @email mithleshshah84@gmail.com
 */
public class MinStackCreation {

    Stack<Integer> minStack;
    Stack<Integer> stack;


    public MinStackCreation() {
       minStack = new Stack<>();
         stack = new Stack<>();
    }

    public void push(int val) {
      stack.push(val);
      if (minStack.isEmpty()) {
          minStack.push(val);
      } else {
              minStack.push(Math.min(val, minStack.peek()));

      }
    }

    public void pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        } else {
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
      if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        } else {
            return stack.peek();
      }
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        } else {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStackCreation minStackCreation = new MinStackCreation();
        minStackCreation.push(5);
        minStackCreation.push(1);
        minStackCreation.push(3);
        System.out.println("Top: " + minStackCreation.top()); // Output: 1
        System.out.println("Min: " + minStackCreation.getMin()); // Output: 1
        minStackCreation.pop();
        System.out.println("Top after pop: " + minStackCreation.top()); // Output: 3
        System.out.println("Min after pop: " + minStackCreation.getMin()); // Output: 3
    }

}
