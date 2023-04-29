import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//from chat gpt
public class SpringArray {
    public static Spring equivalentSpring(String springExpr) {
        Stack<Spring> stack = new Stack<>();
        char[] chars = springExpr.toCharArray();
        for (char c : chars) {
            if (c == '{') {
                stack.push(new Spring());
            } else if (c == '[') {
                stack.push(null);
            } else if (c == '}') {
                Spring s = stack.pop();
                if (!stack.isEmpty() && stack.peek() != null) {
                    stack.peek().inSeries(s);
                } else {
                    stack.push(s);
                }
            } else if (c == ']') {
                Spring s = stack.pop();
                while (stack.peek() != null) {
                    s.inParallel(stack.pop());
                }
                stack.push(s);
            }
        }
        return stack.pop();
    }

    public static Spring equivalentSpring(String springExpr, Spring[] springs) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('{', 1);
        map.put('[', 2);
        map.put('}', -1);
        map.put(']', -2);

        Stack<Spring> stack = new Stack<>();
        char[] chars = springExpr.toCharArray();
        for (char c : chars) {
            if (map.get(c) > 0) {
                stack.push(springs[stack.size()]);
            } else if (map.get(c) == -1) {
                Spring s = stack.pop();
                if (!stack.isEmpty() && map.get(chars[stack.size()]) == 1) {
                    stack.peek().inSeries(s);
                } else {
                    stack.push(s);
                }
            } else if (map.get(c) == -2) {
                Spring s = stack.pop();
                while (map.get(chars[stack.size()]) == 2) {
                    s.inParallel(stack.pop());
                }
                stack.push(s);
            }
        }
        return stack.pop();
    }
}
