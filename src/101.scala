/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    
    def isSymmetric(l: List[Option[Int]]): Boolean = {
        // check if a List is symmetric.
        // Use Option here to allow null values
        if (l.length % 2 != 0) {
            false
        } else {
            val n = l.length
            if ((0 until n / 2).exists(v => l(v) != l(n - v - 1))) false else true
        }
    }
    
    
    def isSymmetric(root: TreeNode): Boolean = {
        if (root == null) {
            true
        } else {

            val result = collection.mutable.ArrayBuffer[Tuple2[Option[Int], Int]]()

            def FUN_check_branch(tree_branch: TreeNode, current_depth: Int): Unit = {
                if (tree_branch != null) {
                    result += Tuple2(Some(tree_branch.value), current_depth)
                    FUN_traverse(tree_branch, current_depth + 1)
                } else {
                    result += Tuple2(null, current_depth)
                } 
            }
            
            def FUN_traverse(tree_node: TreeNode, current_depth: Int): Unit = {
                // LEFT first, then RIGHT. This order can NOT be changed
                FUN_check_branch(tree_node.left, current_depth)
                FUN_check_branch(tree_node.right, current_depth)
            }
        
            FUN_traverse(root, 2)
            
            if (result.toList.groupBy(_._2).mapValues(v => v.map(_._1)).mapValues(isSymmetric(_)).values.forall(_ == true)) {
                true
            } else {
                false
            }
            
        }
     
    }
}