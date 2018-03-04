class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null || lists.length == 0) {
          return null;
      }

      Queue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
      for (ListNode list : lists) {
          if (list != null) {
              pq.offer(list);
          }
      }

      ListNode dummy = new ListNode(0);
      ListNode head = dummy;
      while (!pq.isEmpty()) {
          ListNode cur = pq.poll();
          head.next = cur;
          head = head.next;
          if (cur.next != null) {
              pq.offer(cur.next);
          }
      }

      return dummy.next;
  }
}



class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }

        int mid = (end - start) / 2 + start;
        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid + 1, end);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                head.next = left;
                left = left.next;
            } else {
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }
        if (left != null) {
            head.next = left;
        }
        if (right != null) {
            head.next = right;
        }
        return dummy.next;
    }
}
