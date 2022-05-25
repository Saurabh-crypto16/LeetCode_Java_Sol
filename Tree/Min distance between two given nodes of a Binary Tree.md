```java
class GfG {
    Node LCA(Node root,int a,int b){
        if(root==null || root.data==a || root.data==b){
            return root;
        }
        
        Node l=LCA(root.left,a,b);
        Node r=LCA(root.right,a,b);
        
        if(l==null) return r;
        else if(r==null)    return l;
        else return root;
    }
    public static int findLevel(Node root, int a, int level)
    {
        if (root == null)
            return -1;
        if (root.data == a)
            return level;
        int left = findLevel(root.left, a, level + 1);
        if (left == -1)
            return findLevel(root.right, a, level + 1);
        return left;
    }
    int findDist(Node root, int a, int b) {
        Node lca=LCA(root,a,b);
        
        int l=findLevel(lca,a,0);
        int r=findLevel(lca,b,0);
        
        return l+r;
    }
}
```
