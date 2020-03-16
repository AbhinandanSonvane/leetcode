package com.as.leetcode.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
  public static List<Integer> inorderTraversal(TreeNode root) {

    if (null == root) {
      return Collections.emptyList();
    }

    List<Integer> leftList = new ArrayList<>();
    if (null != root.left) {
      leftList = inorderTraversal(root.left);
    }

    leftList.add(root.val);

    List<Integer> rightList = new ArrayList<>();
    if (null != root.right) {
      rightList = inorderTraversal(root.right);
    }

    leftList.addAll(rightList);

    return leftList;
  }

  public static List<Integer> inorderTraversalIterative(TreeNode root) {

    if (null == root) {
      return Collections.emptyList();
    }

    List<Integer> list = new ArrayList<>();

    Stack<TreeNode> stack = new Stack<>();

    TreeNode node = root;

    while (stack.size() > 0 || node != null) {

      while(node!=null){
        stack.push(node.left);
        node = node.left;
      }

      node = stack.pop();
      list.add(node.val);
      node = node.right;

    }

    return list;
  }

  public static void main(String[] args) {

    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);

    n1.left = null;
    n1.right = n2;
    n2.left = n3;

    System.out.println(inorderTraversalIterative(n1));
  }
}
