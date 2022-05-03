```java
import java.util.*;

public class Solution {
	public static int frogJump(int n, int heights[]) {
		int dp[] = new int[n];
		Arrays.fill(dp,-1);
		
		dp[0]=0;
		dp[1]=Math.abs(heights[1]-heights[0]);

		for (int i = 2; i < n; i++) {

			int oneJump = dp[i-1] + Math.abs(heights[i - 1] - heights[i]);
			int twoJump = dp[i-2] + Math.abs(heights[i - 2] - heights[i]);

			dp[i] = Math.min(oneJump, twoJump);
		}

		return dp[n-1];
	}
}
```
