```java
//Memoization
import java.util.*;

public class Solution {
	public static int maximumChocolates(int r, int c, int[][] grid) {
		int dp[][][]=new int[r][c][c];
		for(int i[][]: dp){
			for(int j[]: i){
				Arrays.fill(j,-1);
			}
		}
		return solve(0,0,c-1,r,c,grid,dp);
	}
	public static int solve(int i,int j1,int j2,int r,int c,int[][] grid,int dp[][][]){
		if(j1<0 || j2<0 || j1>=c || j2>=c){
			return Integer.MIN_VALUE;
		}
		
		if(i==r-1){
			if(j1==j2){
				//both alice and bob reach same box so add only once
				return grid[i][j1];
			}else{
				return grid[i][j1]+grid[i][j2];
			}
		}
		
		if(dp[i][j1][j2]!=-1)	return dp[i][j1][j2];
		
		int max=Integer.MIN_VALUE;
		//j1 options to move to next row 
		for(int dj1=-1;dj1<=1;dj1++){
			//j2 options to move to next row
			for(int dj2=-1;dj2<=1;dj2++){
				int val=0;
				if(j1==j2){
					//both alice and bob reach same box so add only once
					val= grid[i][j1];
				}else{
					val= grid[i][j1]+grid[i][j2];
				}
				val+=solve(i+1,j1+dj1,j2+dj2,r,c,grid,dp);
				max=Math.max(max,val);
			}
		}
		
		return dp[i][j1][j2]=max;
	}
}

//Tabulation method
public class Solution {
	public static int maximumChocolates(int r, int c, int[][] grid) {
		int dp[][][]=new int[r][c][c];
		
		//base case
		for(int j1=0;j1<c;j1++){
			for(int j2=0;j2<c;j2++){
				if(j1==j2)	dp[r-1][j1][j2]=grid[r-1][j1];
				else	dp[r-1][j1][j2]=grid[r-1][j1]+grid[r-1][j2];
			}
		}
		
		for(int i=r-2;i>=0;i--){
			for(int j1=0;j1<c;j1++){
				for(int j2=0;j2<c;j2++){
					int max=Integer.MIN_VALUE;
					//j1 options to move to next row 
					for(int dj1=-1;dj1<=1;dj1++){
						//j2 options to move to next row
						for(int dj2=-1;dj2<=1;dj2++){
							int val=0;
							if(j1==j2){
								//both alice and bob reach same box so add only once
								val= grid[i][j1];
							}else{
								val= grid[i][j1]+grid[i][j2];
							}
							
							if(j1+dj1>=0 && j1+dj1<c && j2+dj2>=0 && j2+dj2<c)
								val+=dp[i+1][j1+dj1][j2+dj2];
							else	val+=Integer.MIN_VALUE;
							
							max=Math.max(max,val);
						}
					}
					
					dp[i][j1][j2]=max;
				}
			}
		}
		
		return dp[0][0][c-1];
	}
}
```
