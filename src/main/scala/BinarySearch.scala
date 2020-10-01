import java.io.{File, PrintWriter}

import scala.io.Source
import scala.io.StdIn.readLine

object BinarySearch {
  val myArray = new Array[String](7)
  def fileToArray:Unit = {
    var letterInFile = ""
    try{
      val fileObject = new File("abc.txt" )
      val printWriter = new PrintWriter(fileObject)
      printWriter.write("Hello,Apple,a,day,keeps,doctor,away,")
      printWriter.close()
      var newWord = ""
      val filename = new File("abc.txt")
      val fileSource = Source.fromFile(filename)
      var arrayLocation = 0
      while (fileSource.hasNext) {
        letterInFile=fileSource.next.toString
        if (!letterInFile.equals(",")){
          newWord+=letterInFile
        }
        else{
          myArray(arrayLocation)=newWord
          newWord=""
          arrayLocation+=1
        }
      }
      fileSource.close()
      println("After appending strings from file to array")
      for(arrayLocation<-myArray) println(arrayLocation)
    }
    catch {
      case _:java.io.FileNotFoundException=>println("file not found")
    }
  }

  def binarySearch(sortArray:Array[String],checkName:String): Unit = {
    for(arrayLocation<-sortArray){
      if(checkName.equals(arrayLocation)){
        println(s"$checkName is present in the list")
        return
      }
    }
    println(s"$checkName not found")
  }

  def main(args: Array[String]): Unit = {
    fileToArray
    val sortedArray=myArray.sorted
    println("$$$$$$$$$ After sorting $$$$$$$$$$")
    for(arrayLocation<-sortedArray) println(arrayLocation)
    val checkName=readLine("Enter a name to check if present or not:")
    binarySearch(sortedArray,checkName)
  }
}
