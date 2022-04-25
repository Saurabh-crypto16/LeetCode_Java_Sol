```java
//Solution 1 - Another stack
import java.util.*;

public class Solution {
	public static void deleteMiddle(Stack<Integer> inputStack, int n) {
		Stack<Integer> st=new Stack<>();
		
		if(n%2==0)	{n/=2;n--;}
		else	n/=2;
		
		while(n-->0){
			st.push(inputStack.pop());
		}
		
		inputStack.pop();
		
		while(!st.isEmpty()){
			inputStack.push(st.pop());
		}
	}
}

//Solution 2 - Recursive
import java.util.*;

public class Solution 
{
    public static void deleteMiddleUtil(Stack<Integer> inputStack, int N, int count){
        if(inputStack.empty() || count == N){
            return;
        }
        
        // Initialise top as top element of stack
        int top = inputStack.pop();
        // Recursively call for rest of the stack
        deleteMiddleUtil(inputStack, N, count + 1);
        // If count is not equal to (N - 1) / 2
        if(count != (N - 1) / 2){
            inputStack.push(top);
        }
    }
    public static void deleteMiddle(Stack<Integer> inputStack, int N){
        // Initialising recursive function
        deleteMiddleUtil(inputStack, N, 0);
    }
}
```
