```java
import java.util.*;

public class Solution {
	public static void sortStack(Stack<Integer> stack) {
		if(stack.isEmpty())	return;
		
		int ele=stack.pop();
		sortStack(stack);
		
		sortedInsert(stack,ele);
	}
	public static void sortedInsert(Stack<Integer> st,int x){
		if(st.isEmpty() || st.peek()<x){
			st.push(x);
			return;
		}
		
		int ele=st.pop();
		sortedInsert(st,x);
		st.push(ele);
	}
}
```
