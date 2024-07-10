/**
 * 25. Reverse Nodes in k-Group
 *
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        ListNode p = head;
        ListNode newHead = null;
        boolean flag = true;

        int totalKGroups = count / k;
        ListNode prevFirst = null;
        while (totalKGroups-- > 0) {
            ListNode first = reverseList(p, k);
            if (flag) {
                newHead = first;
                flag = false;
            }

            int j = 0;
            ListNode last = first;
            while (++j < k) {
                last = last.next;
            }

            p = last.next;
            last.next = null;
            if (prevFirst != null) {
                prevFirst.next = first;
            }
            prevFirst = last;
        }
        prevFirst.next = p;

        return newHead;
    }

    public ListNode reverseList(ListNode list, int k) {
        ListNode last = list;
        ListNode p = null;
        ListNode c = list;
        ListNode n = list.next;

        int count = 0;
        while (count++ < k) {
            c.next = p;
            p = c;
            c = n;
            if (count == k) break;
            n = n.next;
        }
        last.next = c;
        return p;
    }
}
