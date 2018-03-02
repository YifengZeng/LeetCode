public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
        return head;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null) {
        while (fast != null && fast.val == slow.val) {
            fast = fast.next;
        }

        if (slow.next == fast) {
            prev = slow;
            slow = fast;
        } else if (slow.next != fast) {
            prev.next = fast;
            slow = fast;
        }
    }

    return dummy.next;
}