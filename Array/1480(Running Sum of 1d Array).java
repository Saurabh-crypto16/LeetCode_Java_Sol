class Solution {
    public int[] runningSum(int[] nums) {
        int s[]=new int[nums.length];
        int k=0;
        while(k<nums.length){
        for(int i=0;i<k+1;i++){
            s[k]+=nums[i];
        }
            k++;
        }
       return(s); 
    }
}
