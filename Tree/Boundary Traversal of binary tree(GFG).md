```java
class Solution
{
    ArrayList <Integer> ans;
	ArrayList <Integer> rightNodes;
	ArrayList <Integer> boundary(Node node)
	{
	    ans=new ArrayList<>();
	    rightNodes=new ArrayList<>();
	    
	    if(node==null)  return ans;
	    
	    if(node.left==null && node.right==null){
	        ans.add(node.data);
	        return ans;
	    }
	    
	    ans.add(node.data);
	    leftTraversal(node.left);
	    leafTraversal(node);
	    rightTraversal(node.right);
	    
	    ans.addAll(rightNodes);
	    return ans;
	}
	public void leftTraversal(Node root){
	    if(root==null || (root.left==null && root.right==null))  return;
	    
	    ans.add(root.data);
	    if(root.left!=null) leftTraversal(root.left);
	    else leftTraversal(root.right);
	}
	public void leafTraversal(Node root){
	    if(root==null)  return;
	    
	    leafTraversal(root.left);
	    if(root.left==null && root.right==null) ans.add(root.data);
	    leafTraversal(root.right);
	}
	public void rightTraversal(Node root){
	    if(root==null || (root.left==null && root.right==null))  return;
	    
	    rightNodes.add(0,root.data);
	    if(root.right!=null)    rightTraversal(root.right);
	    else rightTraversal(root.left);
	}
}

```
