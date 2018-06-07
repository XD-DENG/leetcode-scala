/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def invertTree(root: TreeNode): TreeNode = {
        
//         // method-1: using if-else
//         if (root == null) {
//             null
//         } else {
//             val left = root.left
//             val right = root.right
//             root.left = invertTree(right)
//             root.right = invertTree(left)
            
//             root
//         }
        
        
        // method-2: using pattern matching
        root match {
            case null =>
                 null
            case _ =>
                 val left = root.left
                 val right = root.right

                 root.left = invertTree(right)
                 root.right = invertTree(left)
                 root
        }
        
        
    }
}