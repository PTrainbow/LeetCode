import java.util.Arrays;

public class LeetCode206 {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        head.print();
        reverseList(head).print();
    }

    /**
     *
     * 龟龟 链表翻转捏，这莫名 > 100%，太简单了没人提交？
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
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

        public void print() {
            ListNode tmp =this;
            while (tmp != null) {
                System.out.print((tmp.val +" "));
                tmp = tmp.next;
            }
            System.out.println();

        }
    }

}