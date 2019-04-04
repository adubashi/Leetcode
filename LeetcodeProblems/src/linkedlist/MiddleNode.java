package linkedlist;

public class MiddleNode {
	public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        /*
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        */
        return slow;
    }

}
