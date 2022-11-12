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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int[] array = new int[100];
        int length = 0;
        int idx = 0;
        while (l1 != null) {
            array[idx++] = l1.val;
            l1 = l1.next;
        }
        length = idx;
        idx = 0;
        while (l2 != null) {
            array[idx] = array[idx] + l2.val;
            l2 = l2.next;
            idx++;
        }
        length = Math.max(length, idx);
        ListNode answer = new ListNode(array[0] % 10);
        array[1] += array[0] / 10;
        ListNode temp = answer;
        for (int i = 1; i < length; i++) {
            temp.next = new ListNode(array[i] % 10);
            array[i + 1] += array[i] / 10;
            temp = temp.next;
        }
        if (array[length] != 0) temp.next = new ListNode(array[length]);
        return answer;
    }
}
