```java
class Solution{
    //Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(Node node) {
        ArrayList<Integer> res=new ArrayList<>();
        solve(node,0,res);
        
        return res;
    }
    public void solve(Node root,int currDepth,ArrayList<Integer> res){
        if(root==null)  return;
        
        if(currDepth==res.size())   res.add(root.data);
        
        solve(root.right,currDepth+1,res);
        solve(root.left,currDepth+1,res);
    }
}
```
