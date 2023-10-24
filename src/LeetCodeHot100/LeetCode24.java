package LeetCodeHot100;

public class LeetCode24 {
    private static int min = Integer.MAX_VALUE;


    public static void main(String[] args) {
        ListNode h = swapPairs(arrayToList(new int[]{1}));
        if (h == null) {
            System.out.println("null");
        } else {
            h.print();
        }
    }

    /**
     * > 100%
     *
     * 虽然写的不好看
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode virtual = new ListNode();
        virtual.next = head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode pre = virtual;
        while (p1 != null && p2 != null) {
            ListNode p1_next = p1.next;
            if (p1_next == null) {
                break;
            }
            p1_next = p1_next.next;
            ListNode p2_next = p2.next;
            if (p2_next == null) {
                pre.next = p2;
                p1.next = null;
                p2.next = p1;
                break;
            }
            p2_next = p2_next.next;
            pre.next = p2;
            p1.next = p2.next;
            p2.next = p1;
            pre = p1;
            p1 = p1_next;
            p2 = p2_next;
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