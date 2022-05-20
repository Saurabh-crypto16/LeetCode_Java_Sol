```java
class Solution{
    int ans=0;
    public int sumK(Node root,int k){
        solve(root,k,new ArrayList<Integer>());
        
        return ans;
    }
    public void solve(Node root,int k,ArrayList<Integer> arr){
        if(root==null)  return;
        
        arr.add(root.data);
        
        solve(root.left,k,arr);
        solve(root.right,k,arr);
        
        int sum=0;
        for(int i=arr.size()-1;i>=0;i--){
            sum+=arr.get(i);
            if(sum==k)  ans++;
        }
        
        arr.remove(arr.size()-1);
    }
}
```
