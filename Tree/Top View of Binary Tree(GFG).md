```java
class Solution
{
    static class hNode{
        Node node;
        int h;
        hNode(Node node,int h){
            this.node=node;
            this.h=h;
        }
    }
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Queue<hNode> q=new LinkedList<>();
        
        q.offer(new hNode(root,0));
        
        while(!q.isEmpty()){
            hNode curr=q.poll();
            
            if(!map.containsKey(curr.h)){
                map.put(curr.h,curr.node.data);
            }
            
            if(curr.node.left!=null){
                q.offer(new hNode(curr.node.left,curr.h-1));
            }
            if(curr.node.right!=null){
                q.offer(new hNode(curr.node.right,curr.h+1));
            }
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        for(int key: map.keySet()){
            ans.add(map.get(key));
        }
        
        return ans;
    }
}
```
