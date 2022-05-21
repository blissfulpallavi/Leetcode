package com.pal.linkedList;

import java.util.Stack;

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 *
 * Example:
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 *
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 5 * 104].
 * 1 <= Node.val <= 1000
 */

class ListNode {
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

/**
 * Approach 1: I'm using extra space to hold the reference of the linkedList
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        ListNode node = head.next;
        Stack<Integer> stack = new Stack<>();
        int count=0;
        while(node!=null){
            stack.push(node.val);
            node=node.next;
            count++;
        }
        count=count/2;

        ListNode resultNode=new ListNode(head.val);
        ListNode tmpNode = resultNode;
        while(count!=0){
            tmpNode.next = new ListNode(stack.pop());
            tmpNode.next.next = new ListNode(head.next.val);
            head = head.next;
            tmpNode = tmpNode.next.next;
            count--;
        }

        System.out.println(resultNode);
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next .next.next = new ListNode(5);
        list.next.next .next.next.next = new ListNode(6);

        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(list);
    }
}
