/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def trimBST(root: TreeNode, L: Int, R: Int): TreeNode = {
        
        if (root == null) {
            null
        } else if (root.value > R) {
            trimBST(root.left, L, R)
        } else if (root.value < L) {
            trimBST(root.right, L, R)
        } else {
            root.left = trimBST(root.left, L, R)
            root.right = trimBST(root.right, L, R)
            root
        }
        
    }
}