```java
class Solution{
    int ans=0,maxsize=0;
    public int sumOfLongRootToLeafPath(Node root){
        solve(root,new ArrayList<Integer>());
        
        return ans;
    }
    public void solve(Node root,ArrayList<Integer> arr){
        if(root==null){
            if(arr.size()>=maxsize){
                ans=Math.max(ans,arr.stream().mapToInt(Integer::intValue).sum());
                maxsize=Math.max(maxsize,arr.size());
            }
            return;
        }
        
        arr.add(root.data);
        solve(root.left,arr);
        solve(root.right,arr);
        arr.remove(arr.size()-1);
    }
}
```
