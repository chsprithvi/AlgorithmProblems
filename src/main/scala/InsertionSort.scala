import scala.io.StdIn.readLine

object InsertionSort {
  def Isort(arr: Array[String]): Unit = {
    val number2 = arr.length
    for (loopIntial <- 1 until number2) {
      val key = arr(loopIntial)
      var loopSecond = loopIntial - 1
      /* Move elements of arr[0..loopArray-1], that are
        greater than key, to one position ahead
        of their current position 
      */
      while (loopSecond >= 0 && arr(loopSecond) > key) {
        arr(loopSecond + 1) = arr(loopSecond)
        loopSecond = loopSecond - 1
      }
      arr(loopSecond + 1) = key
    }
  }

  /* A utility function to print array of size number2*/
  def printArray(arr: Array[String]): Unit = {
    val number2 = arr.length
    for (loopArray <- 0 until number2) {
      print(arr(loopArray) + " ")
    }
    println()
  }
  def main(args: Array[String]): Unit = {
    val number1=readLine("Enter the number of strings you want to input:").toInt
    val arr=new Array[String](number1)
    for (loopArray <- 0 until(number1)){arr(loopArray)=readLine(s"String$loopArray")}
    Isort(arr)
    printArray(arr)
  }
}
