import scala.io.StdIn.readLine

object BubbleSort {
  def bSort(arr: Array[Int]): Unit = {
    val number = arr.length
    for (loopArray <- 0 until number - 1) {
      for (intialValue <- 0 until number - loopArray - 1) {
        if (arr(intialValue) > arr(intialValue + 1)) { // swap arr[intialValue+1] and arr[loopArray]
          val temp = arr(intialValue)
          arr(intialValue) = arr(intialValue + 1)
          arr(intialValue + 1) = temp
        }
      }
    }
  }
  /* A utility function to print array of size number*/
  def printArray(arr: Array[Int]): Unit = {
    val number2 = arr.length
    for (loopArray <- 0 until number2) {
      print(arr(loopArray) + " ")
    }
    println()
  }
  def main(args: Array[String]): Unit = {
    val number1=readLine("Enter the number of Values you want to input:").toInt
    val arr=new Array[Int](number1)
    for (loopArray <- 0 until number1){arr(loopArray)=readLine(s"Number$loopArray").toInt}
    bSort(arr)
    printArray(arr)
  }
}
