package LeetCodeHot100;

public class LeetCode2 {

    public static void main(String[] args) {
        addTwoNumbers(arrayToList(new int[]{9, 9, 9, 9, 9, 9, 9}), arrayToList(new int[]{9, 9, 9, 9})).print();
    }

    /**
     * > 100% 简单题感觉没人做
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode virtualRoot = new ListNode();
        ListNode cur = virtualRoot;
        int rid = 0;
        while (l1 != null && l2 != null){
            int curValue = (rid + l1.val + l2.val) % 10;
            rid = (rid + l1.val + l2.val) / 10;
            ListNode tmp = new ListNode(curValue);
            cur.next = tmp;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        while (l1 != null) {
            int curValue = (rid + l1.val) % 10;
            rid = (rid + l1.val) / 10;
            ListNode tmp = new ListNode(curValue);
            cur.next = tmp;
            l1 = l1.next;
            cur = cur.next;
        }
        while (l2 != null) {
            int curValue = (rid + l2.val) % 10;
            rid = (rid + l2.val) / 10;
            ListNode tmp = new ListNode(curValue);
            cur.next = tmp;
            l2 = l2.next;
            cur = cur.next;
        }
        if (rid != 0) {
            cur.next = new ListNode(rid);
        }
        return virtualRoot.next;
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