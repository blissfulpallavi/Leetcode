package com.pal.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Calculate average at every level of a tree
 */
public class CalculateAvgOfTree {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        tree.val = 3;
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.left.left = new TreeNode(8);
        tree.left.right = new TreeNode(6);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        CalculateAvgOfTree calc = new CalculateAvgOfTree();
        List<Integer> result = calc.calculateAvg(tree);
        System.out.println(result);
    }

    private List<Integer> calculateAvg(TreeNode tree) {
        List<Integer> ll = new ArrayList<>();
        Stack<TreeNode> stackOfNode1 = new Stack<>();
        Stack<TreeNode> stackOfNode2 = new Stack<>();

        if(tree==null)
            return null;

        ll.add(tree.val);
        stackOfNode1.push(tree.left);
        stackOfNode1.push(tree.right);

        while (!stackOfNode1.isEmpty() || !stackOfNode2.isEmpty()){
            int size = 0;
            int tmp=0;

            while(!stackOfNode1.isEmpty()) {
                int val = 0;
                if(stackOfNode1.pop()!=null){
                    val = stackOfNode1.pop().val;
                    size++;
                }
                tmp = tmp + val;
                stackOfNode2.push(stackOfNode2.pop().left);
                stackOfNode2.push(stackOfNode2.pop().right);
            }
            int avg = tmp/size;
            ll.add(avg);
            tmp=size=0;
            while(!stackOfNode2.isEmpty()) {
                int val = 0;
                if(stackOfNode2.pop()!=null){
                    val = stackOfNode1.pop().val;
                    size++;
                }
                tmp = tmp + val;
                stackOfNode1.push(stackOfNode1.pop().left);
                stackOfNode1.push(stackOfNode1.pop().right);
            }
            avg = tmp/size;
            ll.add(avg);
            tmp=size=0;
        }

        return ll;
    }
}
