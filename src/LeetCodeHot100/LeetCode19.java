package LeetCodeHot100;

public class LeetCode19 {
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
        ListNode h = removeNthFromEnd(arrayToList(new int[]{1}), 1);
        if (h == null) {
            System.out.println("null");
        } else {
            h.print();
        }
    }

    /**
     * > 100%
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode virtual = new ListNode();
        virtual.next = head;
        int total = 0;
        ListNode cur = virtual;
        while (cur != null) {
            cur = cur.next;
            total++;
        }
        int real = total - n;
        cur = virtual;
        int count = 0;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            if (real == count) {
                pre.next = cur.next;
                break;
            }
            next = cur.next;
            pre = cur;
            cur = next;
            count++;
        }
        return virtual.next;
    }

    private static ListNode arrayToList(int[] arr) {
        ListNode virtual = new ListNode();
        ListNode head = virtual;
        for (int i : arr) {
            head.next = new ListNode(i);
            head = head.next;
        }
        return virtual.next;
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

        void print() {
            System.out.println(val);
            ListNode tmp = next;
            while (tmp != null) {
                System.out.println(tmp.val);
                tmp = tmp.next;
            }
        }
    }

}