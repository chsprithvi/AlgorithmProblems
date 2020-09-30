import scala.io.StdIn.readLine

object InsertionSort {
  def Isort(arr: Array[String]): Unit = {
    val n = arr.length
    for (i <- 1 until n) {
      val key = arr(i)
      var j = i - 1
      /* Move elements of arr[0..i-1], that are
                     greater than key, to one position ahead
                     of their current position */
      while (j >= 0 && arr(j) > key) {
        arr(j + 1) = arr(j)
        j = j - 1
      }
      arr(j + 1) = key
    }
  }

  /* A utility function to print array of size n*/
  def printArray(arr: Array[String]): Unit = {
    val n = arr.length
    for (i <- 0 until n) {
      print(arr(i) + " ")
    }
    println()
  }
  def main(args: Array[String]): Unit = {
    val number1=readLine("Enter the number of strings you want to input:").toInt
    val arr=new Array[String](number1)
    for (i <- 0 until(number1)){arr(i)=readLine(s"String$i")}
    Isort(arr)
    printArray(arr)
  }
}
