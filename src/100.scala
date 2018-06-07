/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
        
        // // method-1: a nested pattern matching (not really beatifully written)
        // p match {
        //     case null =>
        //         {
        //             q match {
        //                 case null => true
        //                 case _ => false
        //             }
        //         }
        //     case _ => 
        //         {
        //             q match {
        //                 case null => false
        //                 case _ => {
        //                     if (p.value == q.value) {
        //                         isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
        //                     } else {
        //                         false
        //                     }
        //                 }
        //             }
        //         }
        // }

        
        
        // method-2: if-else. More straightforward for this case
        if (p == null && q == null) {
            true
        } else if (p != null && q == null) {
            false
        } else if (p == null && q != null) {
            false
        } else if (p.value == q.value) {
            isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
        } else {
            false
        }
        
        
    }
}