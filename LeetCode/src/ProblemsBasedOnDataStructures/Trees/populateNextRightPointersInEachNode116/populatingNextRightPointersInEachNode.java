package Trees.populateNextRightPointersInEachNode116;

import java.util.LinkedList;

public class populatingNextRightPointersInEachNode {
	/*
	 * 1. Add two queues
	 * 2. Depth queue/ Node queue. 
	 */
	public static void connect(TreeLinkNode root) {
		if(root==null)
	        return;
	 
	    LinkedList<TreeLinkNode> nodeQueue = new LinkedList<TreeLinkNode>();
	    LinkedList<Integer> depthQueue = new LinkedList<Integer>();
	 
	    if(root!=null){
	        nodeQueue.offer(root);
	        depthQueue.offer(1);
	    }
	    
	    while(!nodeQueue.isEmpty()){
	    	TreeLinkNode topNode = nodeQueue.poll();
	        int depth = depthQueue.poll();
	        
	        if(depthQueue.isEmpty()){
	        	topNode.next = null;
	        } else if(depthQueue.peek() > depth){
	        	topNode.next = null; 
	        } else {
	        	topNode.next = nodeQueue.peek();
	        }
	        
	        if(topNode.left!=null){
	            nodeQueue.offer(topNode.left);
	            depthQueue.offer(depth+1);
	        }
	 
	        if(topNode.right!=null){
	            nodeQueue.offer(topNode.right);
	            depthQueue.offer(depth+1);
	        }  
	    }  
    }
	
	public static void connectSimple(TreeLinkNode root){
	    if(root == null) 
	        return;
	 
	    TreeLinkNode lastHead = root;//prevous level's head 
	    TreeLinkNode lastCurrent = null;//previous level's pointer
	    TreeLinkNode currentHead = null;//currnet level's head 
	    TreeLinkNode current = null;//current level's pointer
	    
	    while(lastHead!=null){
	    	lastCurrent = lastHead;
	        while(lastCurrent!=null){
	        	if(currentHead == null){
	        		currentHead = lastCurrent.left;
	                current = lastCurrent.left;
	        	} else {
	        		current.next = lastCurrent.left;
	                current = current.next; 	
	        	}
	        	
	        	if(currentHead != null){
	                current.next = lastCurrent.right;
	                current = current.next;
	            }
	 
	            lastCurrent = lastCurrent.next;
	        }
	        //update last head
	        lastHead = currentHead;
	        currentHead = null;
	    }
	}

}
