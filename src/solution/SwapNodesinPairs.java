package solution;

// medium
// url: https://leetcode.com/problems/swap-nodes-in-pairs/

// Example 1:
// Input: head = [1,2,3,4]
// Output: [2,1,4,3]

// Constraints:

// The number of nodes in the list is in the range [0, 100].
// 0 <= Node.val <= 100

public class SwapNodesinPairs {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        // need a dummy to return head at the end
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        // while still have 2 nodes
        while (prev.next != null && prev.next.next != null) {
            ListNode a = prev.next;
            ListNode b = a.next;

            // swap pointer to last node
            a.next = b.next;
            // swap nodes
            b.next = a;
            prev.next = b;

            prev = a;
        }

        return dummy.next;
    }
}
