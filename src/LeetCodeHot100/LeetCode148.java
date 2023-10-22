package LeetCodeHot100;

public class LeetCode148 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        sortList(node1).print();
    }

    /**
     * 要求空间复杂度 O(1)  时间复杂度 O(nlogn) 分治
     * 时间 90%, 空间 40%
     * 瞄了一眼空间复杂度低的，思路是一致的，可能是多余的方法和变量的问题？
     */
    public static ListNode sortList(ListNode head) {
        return sortInternal(head, null);
    }

    private static ListNode sortInternal(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            // 手动断链，不然死循环了，毕竟不是真的两个链表
            head.next = null;
            return head;
        }
        ListNode mid = getMid(head, tail);
        // mid 两边都包含没有问题，后续是个 merge 过程
        ListNode list1 = sortInternal(head, mid);
        ListNode list2 = sortInternal(mid, tail);
        return merge(list1, list2);
    }

    // 从小到大，合并两个列表
    private static ListNode merge(ListNode list1, ListNode list2) {
        ListNode virtual = new ListNode();
        ListNode head = virtual;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        if (list1 != null) {
            head.next = list1;
        }
        if (list2 != null) {
            head.next = list2;
        }
        return virtual.next;
    }

    private static ListNode getMid(ListNode head, ListNode tail) {
        ListNode fast = head, slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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
