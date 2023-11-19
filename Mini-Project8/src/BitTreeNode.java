

// Taken from Samr's 207 Lab       11/12/2023

/**
 * Nodes in a binary search tree.
 */
class BitTreeNode {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The key.  May not be null.
   *

  /**
   * The associated value.
   */
  String value;

  /**
   * The left subtree.
   */
  BitTreeNode left;

  /**
   * The right subtree.
   */
  BitTreeNode right;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new node.
   */
  public BitTreeNode(String value) {
    this.value = value;
    this.left = null;
    this.right = null;
  } // BSTNode(K,V)

} // class BSTNode<K,V>