```java
import java.util.Stack;

public class Solution {
    
	public static void reverseStack(Stack<Integer> stack) {
		if(stack.isEmpty()){
			return;
		}
		
		int ele=stack.pop();
		reverseStack(stack);
		
		insertAtBottom(stack,ele);
	}
	public static Stack<Integer> insertAtBottom(Stack<Integer> stack,int x){
		if(stack.isEmpty()){
			stack.push(x);
			return stack;
		}
		
		int ele=stack.pop();
		insertAtBottom(stack,x);
		stack.push(ele);
		
		return stack;
	}
}

```
