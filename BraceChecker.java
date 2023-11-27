import java.util.Map;
import java.util.Stack;

public class BraceChecker {
    public boolean isValid(String braces) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = Map.of(
                '{', '}',
                '(', ')',
                '[', ']'
        );
        char[] chars = braces.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (map.getOrDefault(stack.pop(), '0') != c)
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
