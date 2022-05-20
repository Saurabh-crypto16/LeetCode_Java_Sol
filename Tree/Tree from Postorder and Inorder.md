```java
class GfG{
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        HashMap<Integer,Integer> inMap=new HashMap<>();
        for(int i=0;i<n;i++)    inMap.put(in[i],i);
        
        return construct(post,0,n-1,in,0,n-1,inMap);
    }
    public static Node construct(int []post,int pStart,int pEnd,int[] in,int iStart,int iEnd,
        HashMap<Integer,Integer> inMap){
        if(pStart>pEnd || iStart>iEnd)  return null;
        
        Node root=new Node(post[pEnd]);
        int inRoot=inMap.get(root.data);
        int numsLeft=inRoot-iStart;
        
        root.left=construct(post,pStart,pStart+numsLeft-1,in,iStart,inRoot-1,inMap);
        root.right=construct(post,pStart+numsLeft,pEnd-1,in,inRoot+1,iEnd,inMap);
        
        return root;
    }
}
```
