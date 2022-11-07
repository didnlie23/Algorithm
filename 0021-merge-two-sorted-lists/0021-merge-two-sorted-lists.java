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
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        Queue<ListNode> queue = new LinkedList<>();
        ListNode head = null;
        if (list1.val > list2.val) {
            head = list2;
            queue.offer(list2);
            list2 = list2.next;
        } else {
            head = list1;
            queue.offer(list1);
            list1 = list1.next;
        }

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                queue.offer(list2);
                list2 = list2.next;
            } else {
                queue.offer(list1);
                list1 = list1.next;
            }
        }
        if (list1 == null)
            queue.offer(list2);
        else
            queue.offer(list1);
        
        ListNode temp = queue.poll();
        while(!queue.isEmpty()){
            temp.next = queue.poll();
            temp = temp.next;
        }
        return head;
    }
}
