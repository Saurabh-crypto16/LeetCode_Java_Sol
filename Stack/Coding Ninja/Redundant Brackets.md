```java
import java.util.*;

public class Solution {
    public static boolean findRedundantBrackets(String s) {
        Stack<Character> brackets = new Stack<Character>();
        int n = s.length();

        for (int i = 0; i < n; i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '+' || s.charAt(i) == '-' || 
				s.charAt(i) == '*' || s.charAt(i) == '/') {
                brackets.push(s.charAt(i));
            }else if (s.charAt(i) == ')') {
                boolean isRedundant = true;
                // Keep popping from the stack till we reach an opening bracket.
                while (brackets.peek() != '(') {
                    // If we find a operator then the current bracket is not redundant.
                    if (brackets.peek() == '+' || brackets.peek() == '-' || brackets.peek() == '*' 
						|| brackets.peek() == '/') {
                        isRedundant = false;
                    }
                    brackets.pop();
                }

                brackets.pop();
                // Return true if we did not find any operator before finding the opening bracket.
                if (isRedundant) {
                    return true;
                }
            }
        }

        // If no bracket is redundant then return false.
        return false;
    }
}

```
