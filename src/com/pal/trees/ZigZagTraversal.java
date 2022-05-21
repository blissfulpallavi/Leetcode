package com.pal.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ZigZagTraversal {
    List<List<Integer>> result = new ArrayList<>();
    Stack<TreeNode> leftStack = new Stack<>();
    Stack<TreeNode> rightStack = new Stack<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<Integer> ll = new ArrayList<>();

        if(root==null)
            return new ArrayList<>(new ArrayList<>());

        ll.add(root.val);
        addToResult(ll);
        rightStack.add(root.right);
        rightStack.add(root.left);

        while(!rightStack.isEmpty() || !leftStack.isEmpty()){
            ll = new ArrayList<>();

            while(!rightStack.isEmpty()) {
                TreeNode node = rightStack.pop();
                if (node != null) {
                    ll.add(node.val);
                    leftStack.add(node.left);
                    leftStack.add(node.right);
                }
            }
            if(ll.size()>0) {
                Collections.reverse(ll);
                addToResult(ll);
                ll = new ArrayList<>();
            }

            while(!leftStack.isEmpty()) {
                TreeNode node = leftStack.pop();
                if (node != null) {
                    ll.add(node.val);
                    rightStack.add(node.right);
                    rightStack.add(node.left);
                }
            }
            if(ll.size()>0) {
                Collections.reverse(ll);
                addToResult(ll);
            }
        }

        return result;
    }

    private void addToResult(List ll) {
        result.add(ll);
    }


    public static void main(String[] args){
        ZigZagTraversal zigZagTraversal = new ZigZagTraversal();
        /**
         * Test case 1
        tree.root = new TreeNode(2147483647);
         */

        /**
         * Test case 2
         */
        TreeNode tree = new TreeNode();
         tree.val = 3;
         tree.left = new TreeNode(9);
         tree.right = new TreeNode(20);
         tree.left.left = new TreeNode(8);
         tree.left.right = new TreeNode(6);
         tree.right.left = new TreeNode(15);
         tree.right.right = new TreeNode(7);

        /**
         * Test case 3
         *
         * tree.val = 2;
         * tree.left = new TreeNode(2);
         * tree.right = new TreeNode(2);
         */

        List<List<Integer>> result = zigZagTraversal.zigzagLevelOrder(tree);
        System.out.println("result of zig zag="+result);
    }

}
