```java
import java.util.*;

public class Solution {
    public static int findLargestMinDistance(ArrayList<Integer> arr, int k){
        int left=0,right=0,ans=-1;
		for(int a: arr)	right+=a;
		
		while(left<=right){
			int mid=left+(right-left)/2;
			
			if(isPossible(arr,k,arr.size(),mid)){
				ans=mid;
				right=mid-1;
			}else{
				left=mid+1;
			}
		}
		
		return ans;
    }
	public static boolean isPossible(ArrayList<Integer> arr, int m, int n,int maxpages){
		int studentCount=1,pageSum=0;
		
		for(int i=0;i<n;i++){
			if(pageSum+arr.get(i)<=maxpages){
				pageSum+=arr.get(i);
			}else{
				studentCount++;
				if(studentCount>m || arr.get(i)>maxpages)	return false;
				pageSum=arr.get(i);
			}
		}
		
		return true;
	}
}
```
