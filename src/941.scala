object Solution {
  def validMountainArray(A: Array[Int]): Boolean = {

    // Use || here to ensure `A(1) <= A(0)` will not be called if A.length < 3
    if (A.length < 3 || A(1) <= A(0)) {
      return false
    }

    var first_half_met = false

    for (i <- 1 until A.length) {
      if (A(i) == A(i-1)) {
        return false
      }

      if (first_half_met == false) {
        if (A(i) < A(i-1)) {
          first_half_met = true
        }
      } else {
        if (A(i) > A(i-1)) {
          return false
        }
      }
    }

    if (first_half_met == false) return false
    
    return true
  }
}