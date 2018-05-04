object Solution {
    def fizzBuzz(n: Int): List[String] = {
        
        def temp(x: Int): String = {
            val condition_1 = (x % 3==0)
            val condition_2 = (x % 5==0)
            
            if (condition_1 & condition_2) {
                "FizzBuzz"
            }
            else if (condition_1) {
                "Fizz"
            }
            else if (condition_2) {
                "Buzz"
            }
            else {
                x.toString
            }
        }
        
        (1 to n).toList.map(x => temp(x))
        
    }
}