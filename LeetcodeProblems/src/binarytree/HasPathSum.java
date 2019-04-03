package binarytree;

public class HasPathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
        return hasSum(root, 0, sum);
    }
	
	public static boolean hasPathSumHelper(TreeNode root, int cur, int sum) {
		if(root == null) {
			return false;
		}
		cur = cur + root.val;
		boolean condition = ((sum==cur)&& root.left==null && root.right == null );
		return condition || hasPathSumHelper(root.left, sum, cur) ||hasPathSumHelper(root.right, sum, cur);
    }
	

    public boolean hasSum( TreeNode root, int sum, int curr ){
        if(root == null){
            return false;
        }
        curr = curr + root.val;
        return ((sum==curr)&& root.left==null && root.right == null ) || hasSum(root.left, sum, curr) || hasSum(root.right, sum, curr);
    }
	
	

}
