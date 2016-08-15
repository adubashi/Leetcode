package Stack.binaryTreeZigZagLevelOrderTraversal;
import java.util.*;
public class binaryTreeZigZagLevelOrderTraversal {
	
	//Printing Spiral Order
	public void printSpiral(TreeNode node) {
        int h = height(node);
        int i;
  
        /* ltr -> left to right. If this variable is set then the
           given label is transversed from left to right */
        boolean ltr = false;
        for (i = 1; i <= h; i++) 
        {
            printGivenLevel(node, i, ltr);
            /*Revert ltr to traverse next level in opposite order*/
            ltr = !ltr;
        }
  
    }
	
	public int height(TreeNode node)  {
        if (node == null) 
            return 0;
        else
        {
              
            /* compute the height of each subtree */
            int lheight = height(node.left);
            int rheight = height(node.right);
            /* use the larger one */
            if (lheight > rheight)  {
                return (lheight + 1);
            } else {
                return (rheight + 1);
            }
        }
    }
	
	public void printGivenLevel(TreeNode node, int level, boolean ltr) 
    {
        if (node == null) 
            return;
        if (level == 1) 
            System.out.print(node.val + " ");
        else if (level > 1) 
        {
            if (ltr != false) 
            {
                printGivenLevel(node.left, level - 1, ltr);
                printGivenLevel(node.right, level - 1, ltr);
            } 
            else
            {
                printGivenLevel(node.right, level - 1, ltr);
                printGivenLevel(node.left, level - 1, ltr);
            }
        }
    }
	
	//ZigZag order traversal
	//O(N) time and O(N) space
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		
		List<List<Integer>> result=new ArrayList<List<Integer>>(); 
		if(root==null) return result; 
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(root);
        boolean flag=false; 
        while(!stack.isEmpty())
        {
        	Stack<TreeNode> Tpstack=new Stack<TreeNode>();
            List<Integer> list=new ArrayList<Integer>();
            while(!stack.isEmpty())
            {
                TreeNode pop=stack.pop();
                list.add(pop.val);
                if(!flag){
                	//left then right
                	if(pop.left!=null) Tpstack.push(pop.left);
                    if(pop.right!=null) Tpstack.push(pop.right);
                } else {
                	//right then left
                	if(pop.right!=null) Tpstack.push(pop.right);
                    if(pop.left!=null) Tpstack.push(pop.left);
                }
            }
            flag = !flag;
            result.add(list);
            stack=Tpstack;
        }   
       return result; 
	}
	

}
