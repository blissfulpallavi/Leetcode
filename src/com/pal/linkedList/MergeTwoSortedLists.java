package com.pal.linkedList;

/**
 * Merge two sorted linked lists and return it as a sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 *
 * Example 1:
 *
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Example 2:
 *
 * Input: l1 = [], l2 = []
 * Output: []
 *
 * Example 3:
 *
 * Input: l1 = [], l2 = [0]
 * Output: [0]
 */
public class MergeTwoSortedLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        MergeTwoSortedLists mtsl = new MergeTwoSortedLists();
        ListNode nodeA = new ListNode(1);
        nodeA.next = new ListNode(2);
        nodeA.next.next = new ListNode(4);

        ListNode nodeB = new ListNode(1);
        nodeB.next = new ListNode(3);
        nodeB.next.next = new ListNode(4);

        ListNode rootNode = mtsl.mergeTwoLists(nodeA,nodeB);

        System.out.println("Result="+rootNode);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}
