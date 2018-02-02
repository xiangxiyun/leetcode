public class LinkedListCycle{
	public static void main(String[] args){

	}
	private static boolean hasCycle(ListNode head){
		ListNode fast = head;
		ListNode slow = head;

		while(fast!=null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow)
				return true;
		}
		return false;
	}
}

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){this.val = x;}
}