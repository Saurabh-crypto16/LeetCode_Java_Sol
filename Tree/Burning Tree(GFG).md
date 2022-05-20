```java
class Solution{
    public static Node mapToParent(Node root,HashMap<Node,Node> par,int target){
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        par.put(root,null);
        
        Node target_node=null;
        
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node curr=q.poll();
                
                if(curr.data==target){
                    target_node=curr;
                }
                
                if(curr.left!=null){
                    par.put(curr.left,curr);
                    q.offer(curr.left);
                }
                
                if(curr.right!=null){
                    par.put(curr.right,curr);
                    q.offer(curr.right);
                }
            }
        }
        
        return target_node;
    }
    public static int minTime(Node root, int target){
        HashMap<Node,Node> parent=new HashMap<>();
        Set<Node> vis=new HashSet<>();
        Node start=mapToParent(root,parent,target);
        int ans=0;
        
        Queue<Node> q=new LinkedList<>();
        q.offer(start);
        vis.add(start);
        
        while(!q.isEmpty()){
            int size=q.size();
            int fire=0;
            for(int i=0;i<size;i++){
                Node curr=q.poll();
                
                if(curr.left!=null && !vis.contains(curr.left)){
                    q.offer(curr.left);
                    vis.add(curr.left);
                    fire=1;
                }
                if(curr.right!=null && !vis.contains(curr.right)){
                    q.offer(curr.right);
                    vis.add(curr.right);
                    fire=1;
                }
                if(parent.get(curr)!=null && !vis.contains(parent.get(curr))){
                    q.offer(parent.get(curr));
                    vis.add(parent.get(curr));
                    fire=1;
                }
            }
            if(fire==1) ans++;
        }
        
        return ans;
    }
}
```
