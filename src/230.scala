/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def kthSmallest(root: TreeNode, k: Int): Int = {
        
        var count = 0
        var result: Int = -1 // a "placeholder" to help store the result later
        
        // This function will help traverse the binary tree inorder (in left-root-right order)
        def FUN_traverse(node: TreeNode): Unit = {
            if (node != null) {
                FUN_traverse(node.left)
                
                count += 1
                if (count == k) {
                    result = node.value
                } else {
                    FUN_traverse(node.right)
                }
            }
        }
        
        FUN_traverse(root)
        result
    }
}