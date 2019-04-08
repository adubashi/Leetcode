package linkedlist;

public class OddEvenLinkedList {
	
	public ListNode oddEvenList(ListNode head) {
		/*
		 * Odd Even:
		 * 1. Have a odd node and even node to track the nodes
		 * 
		 * We use two pointers, p1 and p2, to trace the odd and even nodes, respectively.
		 *  If the length of the list is even, we stop at p2.next == null,
		 *  i.e, when p2 reaches to the last node. In this case, p1 is in the node next to the last.
		 *  
		 *  If the length of the list is odd, we stop at p2 == null, i.e, p1 is in the last node. 
		 */
		//0 nodes or 1 node
		if (head == null || head.next == null) {
            return head;
        }
		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenHead = even;
		
		while (even != null && even.next != null) {
			odd.next = even.next;
            odd = odd.next;
             
            even.next = odd.next;
            even = even.next;	
		}
		odd.next = evenHead;
        return head;
    }

}
