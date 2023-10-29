package LeetCodeHot100;

import java.util.HashMap;
import java.util.Map;

public class LeetCode138 {
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * > 100%
     */
   private static class Solution {
        public Node copyRandomList(Node head) {
            Node virtual = new Node(0);
            Node cur = head;
            Node newCur = virtual;
            Map<Node, Node> map = new HashMap<>();
            while (cur != null ) {
                newCur.next = new Node(cur.val);
                newCur = newCur.next;
                map.put(cur, newCur);
                cur = cur.next;
            }
            cur = head;
            newCur = virtual.next;
            while (cur != null ) {
                newCur.random = map.get(cur.random);
                newCur = newCur.next;
                cur = cur.next;
            }
            return virtual.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        head.next = node1;
        head.random = null;
        node1.next = node2;
        node1.random = head;
        node2.next = node3;
        node2.random = node4;
        node3.next = node4;
        node3.random = node2;
        node4.random = head;
        Node newHead = new Solution().copyRandomList(head);
        System.out.println(newHead);
    }
}