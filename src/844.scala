object Solution {
    def backspaceCompare(S: String, T: String): Boolean = {
        
        import collection.mutable.ArrayBuffer
        
        def FUN_process(X: String): String = {
            // Use ArrayBuffer as a Stack
            val XX = ArrayBuffer[Char]()
            
            for (i <- X) {
                if (i == '#') {
                    if (XX.length != 0) {
                        XX.remove(XX.length - 1)
                    }
                } else {
                    XX += i
                }
            }
            
            XX.mkString
        }
        
        FUN_process(S) == FUN_process(T) 
    }
}