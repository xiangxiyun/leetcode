public class RemoveDuplicates{
	/*
	* Leetcode 83
	* Given a sorted linked list, delete all duplicates such that each element appear only once.
	* For example,
	* Given 1->1->2, return 1->2.
	* Given 1->1->2->3->3, return 1->2->3.
	*
	*/

	public static void main(String[] args){
		int[] list = new int[]{1,1,1,2,2};

		ListNode head = constructList(list);

		ListNode cur = deleteDuplicates(head);

		while(cur != null){
			System.out.print(cur.val);
			System.out.print(" ");
			cur = cur.next;
		}
		System.out.println("");

	}
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;

        ListNode cur = head, next = cur.next;
        
        while(next!=null){
            if(cur.val == next.val){
                cur.next = next.next;
                next = cur.next;
            }
            else{
                cur = next;
                next = cur.next;
            }
        }
        
        return head;
    }

    private static ListNode constructList(int[] list){

		ListNode head = new ListNode(0);
    	ListNode cur = head;

    	int len = list.length;
    	for(int i = 0; i < len; i++){
    		cur.next = new ListNode(list[i]);
    		cur = cur.next;
    	}
    	return head.next;
    }
}

// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
