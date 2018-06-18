/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def largestValues(root: TreeNode): List[Int] = {
        
        // prepare a Map to store the max valu in each depth. Depth will be the key in this Map.
        val result = collection.mutable.HashMap[Int, Int]()
        
        def FUN_traverse(node: TreeNode, depth: Int): Unit = {
            if(node != null) {
                // order here does NOT matter
                FUN_traverse(node.left, depth + 1)
                FUN_traverse(node.right, depth + 1)
                if (result.contains(depth)) {
                    if(result(depth) < node.value) result(depth) = node.value
                } else {
                    result(depth) = node.value
                }   
            } else {
                null
            }
        }
        
        // trigger the recursion
        FUN_traverse(root, 0)
        
        // order the result by depth and show the max value in each depth
        result.toList.sortBy(_._1).map(_._2)
    }
}