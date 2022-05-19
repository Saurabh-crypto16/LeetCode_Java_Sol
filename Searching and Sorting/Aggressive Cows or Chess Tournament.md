```java
import java.util.*;

public class Solution {
    public static int aggressiveCows(ArrayList<Integer> stalls, int k) {
        int start=0,end=0;
		for(int i: stalls)	end=Math.max(end,i);
		Collections.sort(stalls);
		
		int ans=-1;
		while(start<=end){
			int mid=start+(end-start)/2;
			
			if(isPossible(stalls,k,mid)){
				ans=mid;
				start=mid+1;
			}else{
				end=mid-1;
			}
		}
		
		return ans;
    }
	public static boolean isPossible(ArrayList<Integer> stalls, int k,int mid){
		int cowCount=1,prevStall=stalls.get(0);
		
		for(int i=0;i<stalls.size();i++){
			if(stalls.get(i)-prevStall>=mid){
				prevStall=stalls.get(i);
				cowCount++;
				
				if(cowCount==k)	return true;
			}
		}
		
		return false;
	}
}
```
