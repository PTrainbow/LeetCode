package LeetCodeHot100;

import java.util.List;
import java.util.PriorityQueue;

public class LeetCode23 {

    public static void main(String[] args) {

    }


    class ListNodeWrapper implements Comparable<ListNodeWrapper> {
        ListNode node;

        ListNodeWrapper(ListNode node) {
            this.node = node;
        }

        public int compareTo(ListNodeWrapper node) {
            return this.node.val - node.node.val;
        }
    }

    PriorityQueue<ListNodeWrapper> queue = new PriorityQueue<>();


    /**
     * 看了解答的优先级队列，但是依然只击败了 42%
     */
    public ListNode mergeKLists(ListNode[] lists) {
        for (ListNode node: lists) {
            if (node != null) {
                queue.offer(new ListNodeWrapper(node));
            }
        }
        ListNode virtual = new ListNode(0);
        ListNode tmp = virtual;
        while (!queue.isEmpty()) {
            ListNodeWrapper nodeWrapper = queue.poll();
            tmp.next = nodeWrapper.node;
            tmp = tmp.next;
            if (nodeWrapper.node.next != null) {
                queue.offer(new ListNodeWrapper(nodeWrapper.node.next));
            }
        }
        return virtual.next;
    }

    private static ListNode merge2List(ListNode list1, ListNode list2) {
        ListNode virtual = new ListNode();
        ListNode tmp = virtual;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tmp.next = list1;
                list1 = list1.next;
            } else  {
                tmp.next = list2;
                list2 = list2.next;
            }
            tmp = tmp.next;
        }
        if (list1 != null) {
            tmp.next = list1;
        }
        if (list2 != null) {
            tmp.next = list2;
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

    }

}