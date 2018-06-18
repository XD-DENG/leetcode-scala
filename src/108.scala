/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def sortedArrayToBST(nums: Array[Int]): TreeNode = {
        
        val n = nums.length
        
        if (n != 0) {
            val mid_index = n/2
            val node = TreeNode(nums(mid_index))
            node.left = sortedArrayToBST(nums.take(mid_index))
            node.right = sortedArrayToBST(nums.slice(mid_index + 1, n))

            node
        } else {
            null
        }
    }
}