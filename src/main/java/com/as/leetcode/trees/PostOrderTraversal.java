package com.as.leetcode.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

  public static List<Integer> postOrderTraversal(TreeNode root) {

    if (null == root) {
      return Collections.emptyList();
    }

    List<Integer> list = new ArrayList<>();

    Stack<TreeNode> s1 = new Stack<>();
    Stack<TreeNode> s2 = new Stack<>();

    s1.push(root);
    while(s1.size()>0) {

      TreeNode node = s1.pop();
      s2.push(node);

      if(node.left!=null){
        s1.push(node.left);
      }
      if(node.right!=null) {
        s1.push(node.right);
      }
    }

    while(s2.size()>0){
      list.add(s2.pop().val);
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

    System.out.println(postOrderTraversal(n1));
  }
}
