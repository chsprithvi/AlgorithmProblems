import java.io.{File, PrintWriter}

import scala.io.Source
import scala.io.StdIn.readLine

object BinarySearch {

  def main(args: Array[String]): Unit = {
    var token1 = ""
    val temps = new Array[String](6)
    try{
      // Creating a file
      val file_Object = new File("abc.txt" )
      // Passing reference of file to the printwriter
      val print_Writer = new PrintWriter(file_Object)
      // Writing to the file
      print_Writer.write("Hello,This,is,Geeks,For,Geeks,")
      // Closing printwriter
      print_Writer.close()
      var newString = ""
      val fname = new File("abc.txt")
      val fSource = Source.fromFile(fname)
      var i = 0
      while (fSource.hasNext) {
        token1=fSource.next.toString
        if (!token1.equals(",")){
          newString+=token1
        }
        else{
          temps(i)=newString
          newString=""
          i+=1
        }
      }
      fSource.close()
      for(i<-temps) println(i)
      println("******************")
      val sortedArray=temps.sorted
      for(i<-sortedArray) println(i)
      val checkName=readLine("Enter a name to check if present or not:")
      if (sortedArray.contains(checkName)){println(s"The ->$checkName<- is present in the file $fname")}
    }
    catch {
      case _:java.io.FileNotFoundException=>println("file not found")
    }
  }
}
