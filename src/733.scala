object Solution {
    def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = {
        
        val n_row = image.length
        val n_col = image(0).length
        val startColor = image(sr)(sc)
        
        if (startColor == newColor) {
            image
        } else {

            def FUN_update_pixel(r: Int, c: Int): Unit = {
                if (image(r)(c) == startColor) {
                    image(r)(c) = newColor
                    println(s"($r, $c)")

                    // Check four directions one by one, and invoke RECURSION
                    if (r - 1 >= 0) FUN_update_pixel(r-1, c)
                    if (r + 1 < n_row) FUN_update_pixel(r+1, c)
                    if (c - 1 >= 0) FUN_update_pixel(r, c-1)
                    if (c + 1 < n_col) FUN_update_pixel(r, c+1)
                }
            }

            FUN_update_pixel(sr, sc)

            image
        }
    }
}