```java
public class Solution {
    public static boolean canPartition(int[] arr, int n) {
        int totalSum = 0;

        for (int num : arr) totalSum += num;

        // If sum is odd, then it can't be partitioned into equal sum subsets.
        if (totalSum % 2 != 0) 	return false;

        // One subset sum will always be totalSum/2.
        int subsetSum = totalSum / 2;
        boolean dp[] = new boolean[subsetSum + 1];
        dp[0] = true;

        // Traversing the given array.
        for (int i = 1; i <= n; i++) {
            for (int j = subsetSum; j >= 0; j--) {
                if (j - arr[i - 1] >= 0) {
                    dp[j] = dp[j - arr[i - 1]] || dp[j];
                }
            }
        }

        return dp[subsetSum];
    }
}
```
