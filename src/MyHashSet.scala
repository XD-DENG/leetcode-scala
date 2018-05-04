class MyHashSet (var n_buckets: Int = 10) {

  private var container = Array(List[Int]())
  
  for (i <- 1 until n_buckets) container :+= List[Int]()

  def add(key: Int): Unit = {
    val index = key % n_buckets
    if (container(index).contains(key) == false) container(index) = container(index) ::: List(key)
  }
  
  def remove(key: Int): Unit = {
    val index = key % n_buckets
    if (container(index).contains(key) == true) container(index) = container(index).filter(_ != key)
  }
  
  def contains(key: Int): Boolean = {
    val index = key % n_buckets
    if (container(index).contains(key) == true) true else false
  }
  
}


val set_1 = new MyHashSet(100)

println(set_1.contains(10))
set_1.add(10)
println(set_1.contains(10))
set_1.remove(10)
println(set_1.contains(10))