package LeetCodeHot100;

public class LeetCode234 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(arrayToList(new int[]{1})));
    }


    /**
     * 只让用 O(1)
     */
    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast == null) {
            fast = slow;
        } else {
            fast = slow.next;
        }
        slow = head;
        ListNode half = reverse(fast);
        boolean result = true;
        while (half != null && slow != null && result) {
            if (half.val != slow.val) {
                result = false;
            }
            half = half.next;
            slow = slow.next;
        }
        return result;
    }

    private static ListNode reverse(ListNode fast) {
        if (fast == null || fast.next == null) {
            return fast;
        }
        ListNode next = reverse(fast.next);
        fast.next.next = fast;
        fast.next = null;
        return next;
    }


    private static ListNode arrayToList(int[] arr) {
        ListNode virtual = new ListNode();
        ListNode head = virtual;
        for (int i: arr) {
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

    }
}