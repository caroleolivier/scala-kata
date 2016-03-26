package reverseLinkedList

/**
  * Created by carole on 24/03/2016.
  */
class Node(content: Int, next: Option[Node]) {
  private val _content = content
  private var _next = next

  def this(content: Int, next: Node){
    this(content, Option(next))
  }

  def this(content: Int) {
    this(content, None)
  }

  def getContent() = _content
  def getNext() = _next

  def setNext(next: Option[Node]) = {
    _next = next
  }
}
