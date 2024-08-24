import java.util.Stack;

public class ParenthesesRearrangement {

    public static String rearrange(String s) {

        int openCurly = 0;
        int closeCurly = 0;
        int openSquare = 0;
        int closeSquare = 0;

        int steps = 0;

        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {

            if (c == '{') {
                openCurly++;
                result.append(c);

            } else if (c == '}') {
                if (openCurly == 0) {
                    result.append('{');
                    steps++;
                    openCurly++;
                } else {
                    openCurly--;
                    result.append(c);
                }

            } else if (c == '[') {
                openSquare++;
                result.append(c);

            } else if (c == ']') {
                if (openSquare == 0) {
                    result.append('[');
                    steps++;
                    openSquare++;
                } else {
                    openSquare--;
                    result.append(c);
                }

            } else if (c == '(') {
                closeSquare++;
                result.append(c);

            } else if (c == ')') {
                if (closeSquare == 0) {
                    result.append('(');
                    steps++;
                    closeSquare++;
                } else {
                    closeSquare--;
                    result.append(c);
                }
            }
        }

        while (openCurly > 0) {
            result.append('}');
            openCurly--;
        }

        while (closeCurly > 0) {
            result.append(')');
            closeCurly--;
        }

        while (openSquare > 0) {
            result.append(']');
            openSquare--;
        }

        while (closeSquare > 0) {
            result.append('[');
            closeSquare--;
        }

        return result.toString();

    }
    public static void main(String[] args) {
        String input = "[{)}(]";
        String rearrangedString = rearrange(input);
        System.out.println("String after rearrangement: " + rearrangedString);
    }
}
