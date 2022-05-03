```java
import java.util.*;

public class Solution {
    public static int frogJump(int n, int heights[]) {
		int dp[]=new int[n+1];
		Arrays.fill(dp,-1);
		
		dp[n]=0;	//last stair
		dp[n-1]=Math.abs(heights[n-1]-heights[n-2]);
		
		for(int i=n-2;i>0;i--){
			int oneJump = dp[i + 1] + Math.abs(heights[i - 1] - heights[i]);
			int twoJump = dp[i + 2] + Math.abs(heights[i - 1] - heights[i + 1]);
			
			dp[i] = Math.min(oneJump, twoJump);
		}
		
		//1 based indexing
		return dp[1];
    }
}
```
