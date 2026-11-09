/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode  dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }




        ListNode prev = null;
        ListNode temp = slow.next;
        slow.next = null;
        slow = temp;

        while(slow!=null){
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        ListNode tail = prev;

        while(tail!=null && head!=null){
            temp = head.next;
            head.next = tail;
            tail = temp;
            head = head.next;
        }
    }
}
