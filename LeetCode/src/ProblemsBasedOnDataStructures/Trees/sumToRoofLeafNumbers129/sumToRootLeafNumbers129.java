package Trees.sumToRoofLeafNumbers129;

import Trees.TreeNode;

public class sumToRootLeafNumbers129 {
	
	public static int sumNumbers(TreeNode root) {
	    if(root == null) 
	        return 0;
	 
	    return dfs(root, 0, 0);
    }
	
	public static int dfs(TreeNode node, int sum, int num){
		if(node == null){
			return sum;
		}
		
		num = num*10 + node.val;
		//Leaf
		if(node.left == null && node.right == null){
			sum = sum + num;
			return sum;
		}
		
		sum = dfs(node.left,sum,num) + dfs(node.right,sum,num);
		return sum;
	}

}
