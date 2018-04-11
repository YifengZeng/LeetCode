class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode mid = getMid(dummy);

        ListNode cur = mid.next;
        mid.next = null;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        ListNode left = head;
        ListNode right = prev;
        while (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    private ListNode getMid(ListNode head) {
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            head = head.next;
            fast = fast.next.next;
        }
        return head;
    }
}




class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // get mid
        ListNode mid = getMid(head);

        // reverse 2nd half
        ListNode right = reverse(mid.next);

        // check palindrom
        return isPalindrom(head, right);
    }

    private ListNode getMid(ListNode head) {
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            head = head.next;
            fast = fast.next.next;
        }
        return head;
    }

    // return the head of the reversed linked list
    private ListNode reverse(ListNode cur) {
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private boolean isPalindrom(ListNode left, ListNode right) {
        while (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
