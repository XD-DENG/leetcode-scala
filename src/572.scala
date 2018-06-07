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
    
    
    def isSubtree(s: TreeNode, t: TreeNode): Boolean = {
        
        if (s == null) {
            if (t == null) {
                true
            } else {
                false
            }
        } else if (s.value == t.value) {
            if (isSameTree(s, t)) {
                true
            } else {
              isSubtree(s.left, t) || isSubtree(s.right, t)  
            }
        } else {
            isSubtree(s.left, t) || isSubtree(s.right, t)  
        } 
        
    }
}