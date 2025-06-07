import java.util.Stack;

/**
 * @author mithl
 * @date 04-06-2025
 * @email mithleshshah84@gmail.com
 */
public class MaxStackCreation {

    Stack<Integer> maxStack;
    Stack<Integer> stack;


    public MaxStackCreation() {
        maxStack = new Stack<>();
         stack = new Stack<>();
    }

    public void push(int val) {
      stack.push(val);
      if (maxStack.isEmpty()) {
          maxStack.push(val);
      } else {
              maxStack.push(Math.max(val, maxStack.peek()));

      }
    }

    public void pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        } else {
            stack.pop();
            maxStack.pop();
        }
    }

    public int top() {
      if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        } else {
            return stack.peek();
      }
    }

    public int getMax() {
        if (maxStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        } else {
            return maxStack.peek();
        }
    }

    public static void main(String[] args) {
        MaxStackCreation maxStackCreation = new MaxStackCreation();
        maxStackCreation.push(5);
        maxStackCreation.push(1);
        maxStackCreation.push(3);
        System.out.println("Top: " + maxStackCreation.top()); // Output: 1
        System.out.println("Max: " + maxStackCreation.getMax()); // Output: 1
        maxStackCreation.pop();
        System.out.println("Top after pop: " + maxStackCreation.top()); // Output: 3
        System.out.println("Max after pop: " + maxStackCreation.getMax()); // Output: 3
    }

}
