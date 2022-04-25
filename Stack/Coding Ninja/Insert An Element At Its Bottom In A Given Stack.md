```java
import java.util.*;

public class Solution 
{
	public static Stack<Integer> pushAtBottom(Stack <Integer> myStack, int x) {
		// Base Case
		if (myStack.empty()){
			myStack.push(x);
			return myStack;
		}

		// Store top element in 'num'
		int num = myStack.pop();

		// Recursive call
		pushAtBottom(myStack, x);

		// Add 'num' to stack
		myStack.push(num);

		return myStack;
	}
}

```
