/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    
    def convertBST(root: TreeNode): TreeNode = {
        
        // maintain a glocal variable to help store the current total sum of the "right side"
        var temp_sum = 0
        
        // recursively traverse the tree FROM RIGHT TO LEFT.
        // This is based on the SORTED nature of the input (binary search tree)
        def FUN_traverse(root: TreeNode): TreeNode = {
            
            if (root == null) {
                null
            } else {
                FUN_traverse(root.right)
                temp_sum += root.value
                root.value = temp_sum
                FUN_traverse(root.left)

                root
            }
        }
        
        FUN_traverse(root)
    }
}