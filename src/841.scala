object Solution {
    def canVisitAllRooms(rooms: List[List[Int]]): Boolean = {
   
        
//      SOLUTION - 1: FAILED. not working for case like [[4],[3],[],[2,5,7],[1],[],[8,9],[],[],[6]]
//         val all_keys = rooms.zipWithIndex
//                             .map(x => (x._1.filter(_ != x._2), x._2))
//                             .map(_._1)
//                             .flatMap(x => x)
        
//         println(all_keys)
//         println((0 until rooms.length).filter(x => all_keys.contains(x)))
        
//         (1 until rooms.length).filter(x => all_keys.contains(x)).length == (rooms.length - 1)
        
        
        
        // SOLUTION - 2: a working solution using recursion idea
        import collection.mutable.ArrayBuffer

        val room_can_enter = ArrayBuffer[Int]()
        val n = rooms.length
        
        def FUN_traverse(keys: List[Int]): Unit = {
            
            val filtered_keys = keys.filter(room_can_enter.contains(_) == false)
            
            filtered_keys.foreach(room_can_enter += _)
            filtered_keys.foreach(x=> FUN_traverse(rooms(x)) )    

        }
        
        FUN_traverse(rooms(0))
    
        room_can_enter -= 0 // room 0 is already opened
        room_can_enter.distinct.length == (n - 1) // room 0 is already opened so "n minus 1"
        
    }
}