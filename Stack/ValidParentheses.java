import java.util.Stack;

public class ValidParentheses {

  public static void main(String[] args) {
    System.out.println(isValid("[()]"));
  }
  public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        Character top = stack.pop();
        if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}


/*
input: [()]
output: true


If [, (, { will push into stack
If ], ), } will check and remove top element of stack.


Time complexity:
Space complexity:
 */