```java
class Tree{
    public ArrayList<Integer> diagonal(Node root)
    {
        Queue<Node> q=new LinkedList<>();
        ArrayList<Integer> res=new ArrayList<>();
        
        q.offer(root);
        
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node curr=q.poll();
                
                while(curr!=null){
                    res.add(curr.data);
                    if(curr.left!=null) q.offer(curr.left);
                    curr=curr.right;
                }
            }
        }
        
        return res;
    }
}
```
