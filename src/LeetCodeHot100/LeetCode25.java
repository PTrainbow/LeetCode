package LeetCodeHot100;

public class LeetCode25 {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        reverseKGroup(node1, 3);
    }

    /**
     * 抄了一份递归的答案 > 100%，感觉逻辑比较清晰
     *
     * 自己用 while 写了半天，节点处理有问题
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        ListNode start,end;
        start = end = head;
        for (int i =0;i < k;i++) {
            if (end == null) {
                return head;
            }
            end = end.next;
        }
        ListNode newHead = reverse(start, end);
        start.next = reverseKGroup(end, k);
        return newHead;
    }

    private static ListNode reverse(ListNode start, ListNode end) {
        ListNode pre, cur, nxt;
        pre = null; cur = start; nxt = start;
        while (cur != end) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private static class ListNode {
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

}