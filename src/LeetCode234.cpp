class Solution {
public:
    bool isPalindrome(ListNode* head) {
        if (head == NULL) {
            return true;
        }

        ListNode* mid = getMid(head);
        ListNode* right = reverse(mid->next);
        return isPalindrome(head, right);
    }

    ListNode* getMid(ListNode* head) {
        ListNode* fast = head;
        while (fast->next != NULL && fast->next->next != NULL) {
            head = head->next;
            fast = fast->next->next;
        }
        return head;
    }

    ListNode* reverse(ListNode* cur) {
        ListNode* prev = NULL;
        while (cur != NULL) {
            ListNode* next = cur->next;
            cur->next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    bool isPalindrome(ListNode* left, ListNode* right) {
        while (left != NULL && right != NULL) {
            if (left->val != right->val) {
                return false;
            }
            left = left->next;
            right = right-> next;
        }
        return true;
    }
};
