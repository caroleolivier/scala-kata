package reverseLinkedList

class ReverseLinkedList {
  def reverse(node: Option[Node]) = {
    reverseRec(node, None)
  }

  // display
  def display(node: Option[Node]): Unit = node match {
    case Some(n) =>
      println(node.get.getContent())
      display(node.get.getNext())
    case None =>
      println("nothing")
  }

  private def reverseRec(current: Option[Node], previous: Option[Node]): Option[Node] = current match {
    case Some(node) =>
      val next = current.get.getNext()
      current.get.setNext(previous)
      reverseRec(next, current)
    case None =>
      previous
  }
}

