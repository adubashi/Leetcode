package Problems;

public class invertBinaryTree226 {
	public static TreeNode invertTree(TreeNode root) {
        if(root!=null){
            helper(root);
        }
 
        return root;    
    }
    public static void helper(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        
        if(node.left != null){
            helper(node.left);
        }
        if(node.right != null){
            helper(node.right);
        }
    }

}
