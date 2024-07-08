public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode sp = head;
        ListNode fp = head;
        while (true) {
            if (fp == null || fp.next == null) {
                return null;
            }
            sp = sp.next;
            fp = fp.next.next;
            if (sp == fp) {
                break;
            }
        }
        sp = head;
        while (sp != fp) {
            sp = sp.next;
            fp = fp.next;
        }
        return sp;
    }
}
