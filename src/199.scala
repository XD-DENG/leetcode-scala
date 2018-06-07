/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def rightSideView(root: TreeNode): List[Int] = {
        
        if (root == null) {
            List()
        } else {
            // A "stupid" idea:
            // we traverse the whole tree, use an ArrayBuffer of Tuple2(current depth, value) to describe the whole tree
            // then we group these tuples using their depth, and get the element at the most right side position
            import collection.mutable.ArrayBuffer
            val storage = ArrayBuffer[Tuple2[Int, Int]]()

            def FUN_traverse(tree: TreeNode, i: Int): Unit = {
                if (tree != null) {
                    // the order of statements 1 to 4 can NOT be changed
                    // later we use ".last" method to get the element at the most right side position. The order is important
                    if (tree.left != null) storage += Tuple2(i, tree.left.value) // statement-1
                    if (tree.right != null) storage += Tuple2(i, tree.right.value) // statement-2

                    if (tree.left != null) FUN_traverse(tree.left, i+1) // statement-3
                    if (tree.right != null) FUN_traverse(tree.right, i+1) // statement-4
                }
            }

            FUN_traverse(root, 1)
            
            List(root.value) ++ storage.groupBy(_._1).toList.sortBy(_._1)
                                .map(x=>(x._1, x._2.last))
                                .map(x=>(x._1, x._2._2))
                                .map(_._2)
        }

    }
}