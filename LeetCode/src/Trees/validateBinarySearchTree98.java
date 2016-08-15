package Trees;

public class validateBinarySearchTree98 {
	public static boolean isValidBST(TreeNode root) {
        return isValidBST(root,Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        
    }
    
    public static boolean isValidBST(TreeNode root,Double min, Double max){
        if(root == null){
            return true;
        }
        if(root.val  <= min || root.val >= max){
            return false;
        } 
        return isValidBST(root.left,min,(double)root.val) && isValidBST(root.right,(double)root.val,max);

    }

}
