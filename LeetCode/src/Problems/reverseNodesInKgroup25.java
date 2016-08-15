package Problems;

public class reverseNodesInKgroup25 {
	/*
	 * Algorithm: reverse(head, k)
	1) Reverse the first sub-list of size k. While reversing keep track of the next node and previous node. 
	Let the pointer to the next node be next and pointer to the previous node be prev.
	2) head->next = reverse(next, k) /* Recursively call for rest of the list and link the two sub-lists */
  //3) return prev /* prev becomes the new head of the list (see the diagrams of iterative method of this post) */
	
	//Reverses the list in k group if the list is shorter than k
    public static ListNode reverse(ListNode head, int k)
    {
       ListNode current = head;
       ListNode next = null;
       ListNode prev = null;
        
       int count = 0;
 
       /* Reverse first k nodes of linked list */
       while (count < k && current != null) 
       {
           next = current.next;
           current.next = prev;
           prev = current;
           current = next;
           count++;
       }
       /* next is now a pointer to (k+1)th node 
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
       if (next != null) 
          head.next = reverse(next, k);
       // prev is now head of input list
       return prev;
    } 
    
    public static ListNode reverse(ListNode pre, ListNode next){
        ListNode last = pre.next;
        ListNode curr = last.next;
     
        while(curr != next){
            last.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = last.next;
        }
     
        return last; 
    }
    
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k==1)
            return head;
     
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode pre = fake;
        int i=0;
     
        ListNode p = head;
        while(p!=null){
            i++;
            if(i%k==0){
                pre = reverse(pre, p.next);
                p = pre.next;
            }else{
                p = p.next; 
            }
        }
     
        return fake.next; 
    }
	 
}
