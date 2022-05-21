package com.pal.linkedList;

import java.math.BigDecimal;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode nodeB = new ListNode(2);
        nodeB.next = new ListNode(4);
        nodeB.next.next = new ListNode(3);

        ListNode nodeA = new ListNode(5);
        nodeA.next = new ListNode(6);
        nodeA.next.next = new ListNode(4);
        //String input = "10000000000000000000000000000";
        //nodeA = addNode(28,nodeA,input);

        System.out.println("result="+addTwoNumbers.addTwoNumbers(nodeA,nodeB));
    }

    public ListNode addTwoNumbers(ListNode inputA, ListNode inputB) {
        BigDecimal a=null;
        BigDecimal b=null;

        String str="";
        if(inputA!=null){
            a= new BigDecimal(getNumber(inputA,str));
            str="";
        }
        if(inputB!=null){
            b=new BigDecimal(getNumber(inputB,str));
        }

        BigDecimal total = a.add(b);
        ListNode result = getLinkedList(total.toPlainString());

        return result;
    }

    private ListNode getLinkedList(String totalStr) {
        int len = totalStr.length();
        ListNode node = new ListNode((Character.getNumericValue(totalStr.charAt(len-1))));
        node=addNode(len-2,node,totalStr);

        return node;
    }

    private static ListNode addNode(int i, ListNode node,String totalStr) {
        if(node!=null && i>=0) {
            node.next = new ListNode(Character.getNumericValue(totalStr.charAt(i)));
            i--;
            addNode(i,node.next,totalStr);
        }

        return node;
    }

    private String getNumber(ListNode input,String str) {
        if(input!=null){
            str=input.val+str;
            str=getNumber(input.next,str);
        }

        return str;
    }
}
