object Solution {
    def isValidSudoku(board: Array[Array[Char]]): Boolean = {
        
        
        import util.control.Breaks._
        
        def check_a_single_array(l: Array[Char]): Boolean = {
            // input: Array of char, an Array of 9 elments to check using the three rules
            // return: Boolean, if the array given can pass the exam
            val temp = l.filter(_ != '.')
            if (temp.length != temp.distinct.length) {
                false
            } else {
                true
            }
        }
        
        
        var error_flag = 0
        
        breakable {
            
            // check rule-1
            for (i <- 0 until 9) {
                if (check_a_single_array(board(i)) ==  false) {
                    error_flag += 1
                    break
                }
              }

            // check rule-2
            for (i <- 0 until 9) {
                val temp_list = board.map(_(i))
                
                if (check_a_single_array(temp_list) == false) {
                    error_flag += 1
                    break
                }
            }
            
            // check rule-3
            for (i <- 0 until 3; j <- 0 until 3) {
                // get each 3x3 sub-boxes and flatten it to a 9-length Array
                val temp_list = board.slice(i * 3, i * 3 + 3).flatMap(_.slice(j * 3, j*3 + 3))
                
                if (check_a_single_array(temp_list) == false) {
                    error_flag += 1
                    break
                }
            }
 
        }

 
        if (error_flag > 0) false else true
         
    }
}