```java
class Tree
{
    int ans=-1;
    public int kthAncestor(Node root, int k, int node)
    {
        ArrayList<Integer> arr=new ArrayList<>();
        solve(root,node,arr,k);
        
        return ans;
    }
    public void solve(Node root,int node,ArrayList<Integer> arr,int k){
        if(root==null)   return;
        
        arr.add(root.data);
        
        if(root.data==node){
            int idx=-1;
            for(int i=0;i<arr.size();i++){
                if(arr.get(i)==node){
                    idx=i;
                    break;
                }
            }
            if(idx!=-1 && idx-k>=0){
                ans=arr.get(idx-k);
            }
            return;
        }
        
        solve(root.left,node,arr,k);
        solve(root.right,node,arr,k);
        
        arr.remove(arr.size()-1);
    }
}
```
