/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        // find mid
        ListNode mid = findMid(head);
        // System.out.println(mid.val);

        // reverse
        ListNode tail = reverseList(mid.next);
        // tail will be the start of the second half
        mid.next = null; // actuall we don't need this
        // tail is now the start of the reversed second half
        // print(head);
        // print(tail);

        // now merge two list head & tail
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head != null && tail != null) {
            cur.next = head;
            head = head.next;
            cur = cur.next;
            cur.next = tail;
            tail = tail.next;
            cur = cur.next;
        }
        cur.next = head;

        // return dummy.next;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}