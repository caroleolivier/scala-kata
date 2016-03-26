import reverseLinkedList.{ReverseLinkedList, Node}

/**
  * Created by carole on 24/03/2016.
  */
object Main {
  def main(args: Array[String]): Unit = {
    println("Go!")
    val node4 = new Node(4)
    val node3 = new Node(3, node4)
    val node2 = new Node(2, node3)
    val node1 = new Node(1, node2)

    val reverseLinkedList = new ReverseLinkedList
    reverseLinkedList.display(Option(node1))
    reverseLinkedList.display(reverseLinkedList.reverse(Option(node1)))
  }
}
