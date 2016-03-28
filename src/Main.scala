import list.problemContainer
import reverseLinkedList.{ReverseLinkedList, Node}

/**
  * Created by carole on 24/03/2016.
  */
object Main {
  def main(args: Array[String]): Unit = {
    println("Go!")

    val list = List(3, 6, 2, 19, 8, 15, 4)

    val problemContainer = new problemContainer
    println(problemContainer.pack(List(1, 2, 2, 3, 4, 4, 4, 5, 5, 6, 5, 6, 6)))

    println(problemContainer.pack(List()))

  }
}
