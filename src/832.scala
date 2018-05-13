object Solution {
    def flipAndInvertImage(A: Array[Array[Int]]): Array[Array[Int]] = {
        
        A.map(row => row.map(x => if (x==1) 0 else 1).reverse)
        
    }
}