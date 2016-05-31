package Problems;

public class StanfordBinaryTreeProblems {

	
	//height
	public static int height(TreeNode head){
		if(head == null){
			return 0;
		} else {
			return 1 + Math.max(height(head.left),height(head.right));
		}	
	}
	
	//Valid BST
	public static boolean isValidBST(TreeNode head, Integer max, Integer min){
		if(head == null){
			return true;
		} 
		if(head.val > max || head.val < min){
			return false;
		}
		return isValidBST(head.left,head.val,min) && isValidBST(head.right,max,head.val);
	}
	
	//Limit Path Sum
	public static void limitPathSum(TreeNode head, int currentSum, int maximum){
		if(head == null){
			return;
		} else {
			int cur = currentSum + head.val;
			if(cur > maximum){
				head = null;
			} else {
				limitPathSum(head.left, cur, maximum);
				limitPathSum(head.right,cur,maximum);
			}	
		}
	}
	
	//Check if a binary tree is balanced 
	public static boolean isBalanced(TreeNode root){
		if(root == null){
			return true;
		} 
		int heightDiff = height(root.left) - height(root.right);
		if(Math.abs(heightDiff)  > 1){
			return false;
		} else {
			return isBalanced(root.left)  && isBalanced(root.right);
		}
	}
	
	public static void completeToLevel(TreeNode root, int curlevel, int klevel){
		if(curlevel <= klevel){
			if(root == null){
				root = new TreeNode(-1);
 			}
			completeToLevel(root.left,curlevel+1,klevel);
			completeToLevel(root.right,curlevel+1,klevel);
		}
		return;
	}

	
	public static int countLeftNodes(TreeNode root){
		if(root == null){
			return 0;
		} else {
			if(root.left == null){
				return countLeftNodes(root.right);
			} 
			return 1 + countLeftNodes(root.right) + countLeftNodes(root.left);
		}
	}
	
}
