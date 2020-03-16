package com.as.leetcode.trees;

import java.util.Stack;

public class SerializeDeserializeBinaryTree {

  public static String serialize(TreeNode node) {

    if (node == null) {
      return "-1";
    }

    /*Stack<TreeNode> stack = new Stack<>();
    StringBuilder str = new StringBuilder();
    while (stack.size() > 0 || node != null) {

      while (node != null) {
        str.append(node.val).append(",");
        stack.push(node);
        node = node.left;

        if (node == null) {
          str.append("-1,");
        }
      }

      node = stack.pop();
      node = node.right;
    }

    return str.toString();*/

    return node.val + "," + serialize(node.left) + "," + serialize(node.right);
  }

  public static TreeNode deserialize(String str) {

    if (str.equals("-1")) {
      return null;
    }

    String[] tokens = str.split(",");

    Stack<TreeNode> stack = new Stack<>();

    TreeNode root = new TreeNode(Integer.valueOf(tokens[0]));
    stack.push(root);
    for (int i = 0; i < tokens.length - 2; i++) {
      if (!tokens[i].equals("-1")) {
        TreeNode pop = stack.pop();
        TreeNode node = new TreeNode(Integer.valueOf(tokens[i]));
        if (!tokens[i + 2].equals("-1")) {
          pop.right = new TreeNode(Integer.valueOf(tokens[i + 2]));
          stack.push(pop.right);
        }
        if (!tokens[i+1].equals("-1")) {
          pop.left = new TreeNode(Integer.valueOf(tokens[i + 1]));
          stack.push(pop.left);
        }
      }
    }

    return root;
  }

  public static void main(String[] args) {

    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);

    n1.left = null;
    n1.right = n2;
    n2.left = n3;

    System.out.println(serialize(n1));

    System.out.println(InorderTraversal.inorderTraversal(deserialize(serialize(n1))));
  }
}
