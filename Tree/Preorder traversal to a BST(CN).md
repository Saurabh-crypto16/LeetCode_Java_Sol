```java
import java.util.ArrayList;
class Index{
    int index=0;
}

public class Solution {
    static BinaryTreeNode<Integer> prorderToBST(ArrayList<Integer> preOrder){
        Index preorderIndex=new Index();
        BinaryTreeNode<Integer> root = helper(preOrder, preorderIndex, Integer.MIN_VALUE, 
											Integer.MAX_VALUE);
        
		return root;
    }

    static BinaryTreeNode<Integer> helper(ArrayList<Integer> preOrder,Index preorderIndex,int minVal,int maxVal) {
        if (preorderIndex.index == preOrder.size())	return null;

        int currVal = preOrder.get(preorderIndex.index);
        if (currVal < minVal || currVal > maxVal)	return null;

        BinaryTreeNode<Integer>root = new BinaryTreeNode<Integer>(currVal);
        preorderIndex.index++;
        // Recursivley construct left subtree.
        root.left = helper(preOrder, preorderIndex, minVal, currVal - 1);
        // Recursivley construct right subtree.
        root.right = helper(preOrder, preorderIndex, currVal + 1, maxVal);

        return root;
    }
}
```
