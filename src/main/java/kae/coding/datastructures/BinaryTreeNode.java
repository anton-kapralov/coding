package kae.coding.datastructures;

import java.util.StringJoiner;
import java.util.function.Consumer;

public class BinaryTreeNode {
  private int value;
  private BinaryTreeNode left;
  private BinaryTreeNode right;

  public BinaryTreeNode(int value) {
    this.value = value;
  }

  public BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public int value() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public BinaryTreeNode left() {
    return left;
  }

  public void setLeft(BinaryTreeNode left) {
    this.left = left;
  }

  public BinaryTreeNode right() {
    return right;
  }

  public void setRight(BinaryTreeNode right) {
    this.right = right;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", BinaryTreeNode.class.getSimpleName() + "[", "]")
        .add("val=" + value)
        .add("left=" + (left != null ? left.value : "null"))
        .add("right=" + (right != null ? right.value : "null"))
        .toString();
  }

  public static void inOrder(BinaryTreeNode root, Consumer<BinaryTreeNode> visitor) {
    if (root == null) {
      return;
    }
    inOrder(root.left(), visitor);
    visitor.accept(root);
    inOrder(root.right(), visitor);
  }

  public static void preOrder(BinaryTreeNode root, Consumer<BinaryTreeNode> visitor) {
    if (root == null) {
      return;
    }
    visitor.accept(root);
    preOrder(root.left(), visitor);
    preOrder(root.right(), visitor);
  }

  public static void postOrder(BinaryTreeNode root, Consumer<BinaryTreeNode> visitor) {
    if (root == null) {
      return;
    }
    postOrder(root.left(), visitor);
    postOrder(root.right(), visitor);
    visitor.accept(root);
  }
}
