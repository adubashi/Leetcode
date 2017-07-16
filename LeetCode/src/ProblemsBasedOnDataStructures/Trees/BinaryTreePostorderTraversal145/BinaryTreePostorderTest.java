package ProblemsBasedOnDataStructures.Trees.BinaryTreePostorderTraversal145;

import java.util.List;

import ProblemsBasedOnDataStructures.Trees.TreeNode;


public class BinaryTreePostorderTest {
	
	public static void main(String args[]){
		
		BinaryTreePostorderTraversal mBinaryTreePostorder = new BinaryTreePostorderTraversal();
		
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);

		
		t1.right = t2;
		t2.left = t3;
		
		List<Integer> output = mBinaryTreePostorder.postorderTraversalIterative(t1);

		for(int i = 0; i < output.size(); i++){
			System.out.print(output.get(i) + " ");
		}
		
	}

}
