public class PalindromeLinkedList{
	public static void main(String[] arg){
		ListNode l1 = new ListNode(1);
		ListNode cur = l1;
		cur.next = new ListNode(3);
		cur = cur.next;
		cur.next = new ListNode(5);
		cur = cur.next;
		cur.next = new ListNode(3);
		cur = cur.next;
		cur.next = new ListNode(2);

		boolean res = isPalindrome(l1);

		System.out.println(res);

	}
	private static boolean isPalindrome(ListNode head){
		ListNode fast = head;
		ListNode slow = head;

		//find the start of the second half linked list
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}

		//reverse the second half linked list
		ListNode pre = null;
		while(slow!= null){
			ListNode next = slow.next;
			slow.next = pre;
			pre = slow;
			slow = next;
		}

		//compare two linked list
		ListNode cur1 = head;
		ListNode cur2 = pre;
		while(cur2 != null){
			if(cur2.val!=cur1.val)
				return false;
			cur2 = cur2.next;
			cur1 = cur1.next;
		}

		return true;

	}
}




/* Definition for singly-linked list.*/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
