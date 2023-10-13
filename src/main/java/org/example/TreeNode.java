package org.example;

/**
 * Описание класса
 *
 * @author Имя Фамилия
 * @since 31.07.2023
 */
public class TreeNode {
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
