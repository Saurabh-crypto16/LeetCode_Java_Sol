```java
//Solution 1 - Space optimized
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        boolean dp[]=new boolean[k+1];
		
		//1st column all true because target 0 is always possible
		dp[0]=true;	
		//in 1st row value equals to 1st element of arr is possible
		if(arr[0]<k)	dp[arr[0]]=true;		
		
		for(int ind=1;ind<n;ind++){
			boolean curr[]=new boolean[k+1];
			curr[0]=true;
			
			for(int target=1;target<=k;target++){
				boolean notTake=dp[target];	//just above the cell
				boolean take=false;
				
				if(arr[ind]<=target){
					//if current val in arr is less than target
					//then to take use 0-1 knapsack approach
					take=dp[target-arr[ind]];
				}
				
				curr[target]=take | notTake;
			}
			
			dp=curr.clone();
		}
		
		return dp[k];
    }
}


//Solution 2
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        boolean dp[][]=new boolean[n][k+1];
		
		//1st column all true because target 0 is always possible
		for(int i=0;i<n;i++)	dp[i][0]=true;	
		//in 1st row value equals to 1st element of arr is possible
		if(arr[0]<k)	dp[0][arr[0]]=true;		
		
		for(int ind=1;ind<n;ind++){
			for(int target=1;target<=k;target++){
				boolean notTake=dp[ind-1][target];	//just above the cell
				boolean take=false;
				
				if(arr[ind]<=target){
					//if current val in arr is less than target
					//then to take use 0-1 knapsack approach
					take=dp[ind-1][target-arr[ind]];
				}
				
				dp[ind][target]=take | notTake;
			}
		}
		
		return dp[n-1][k];
    }
}

```
