package com.pal.trees;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ValidateBST {
    static TreeNode root;

    /* can give min and max value according to your code or
    can write a function to find min and max value of tree. */

    /* returns true if given search tree is binary
     search tree (efficient version) */
    public boolean isValidBST(TreeNode root){
        return checkForBST(root,null,null);
    }

    /* Returns true if the given tree is a BST and its
      values are >= min and <= max. */
    private boolean checkForBST(TreeNode node, Integer minValue, Integer maxValue) {

        /* an empty tree is BST */
        if (node == null)
            return true;

        /* false if this node violates the min/max constraints */
        if((minValue!=null && node.val <= minValue) || (maxValue!=null && node.val >= maxValue))
            return false;

        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (checkForBST(node.left,minValue,node.val) &&
                checkForBST(node.right,node.val,maxValue));
    }


    public static void main(String[] args){
        ValidateBST tree = new ValidateBST();
        /**
         * Test case 1
         */
        tree.root = new TreeNode(2);
        tree.root.left = new TreeNode(1);
        tree.root.right = new TreeNode(3);


        /**
         * Test case 2
         *
        tree.root = new TreeNode(5);
        tree.root.left = new TreeNode(4);
        tree.root.right = new TreeNode(6);
        tree.root.right.left = new TreeNode(3);
        tree.root.right.right = new TreeNode(7);
         */

        /**
         * Test case 3
         *
        tree.root = new TreeNode(2);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(2);
         */

        if (tree.isValidBST(root))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }
}
