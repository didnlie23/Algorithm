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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2; else if (list2 == null) return list1;

        ListNode head = null;
        ListNode current = null;
        ListNode opposite = null;
        ListNode temp = null;
        if (list1.val > list2.val) {
            head = list2;
            current = list2;
            opposite = list1;
        } else {
            head = list1;
            current = list1;
            opposite = list2;
        }

        while (current.next != null) {
            if (current.next.val > opposite.val){
                temp = current.next;
                current.next = opposite;
                opposite = temp;
            }
            current = current.next;
        }
        
        current.next = opposite;
        return head;
    }
}
