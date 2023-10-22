import java.util.PriorityQueue;

public class LeetCode21 {

    public static void main(String[] args) {
        mergeTwoLists(arrayToList(new int[]{1, 2, 4}), arrayToList(new int[]{1, 3, 4})).print();
    }

    /**
     * > 100% 简单题感觉没人做
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode virtualRoot = new ListNode();
        ListNode cur = virtualRoot;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        } else  {
            cur.next = list2;
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