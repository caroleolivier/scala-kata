package list

/**
  * Created by carole on 28/03/2016.
  */
class problemContainer {
  def lastBuiltIn[T](list : List[T]): T = {
    list.last
  }

  def last[T](list : List[T]) : T = list match {
    case i :: Nil => i
    case i :: tail => last(tail)
    case _ => throw new NoSuchElementException
  }

  def penultimate[T](list : List[T]) : T = list match {
    case i :: _ :: Nil => i
    case i :: tail => penultimate(tail)
    case _ => throw new NoSuchElementException
  }

  def kthEltBuiltIn[T](list: List[T], k: Int): T = list.size match {
    case l: Int if l > k => list(k)
    case _ => throw new NoSuchElementException
  }

  def kthElt[T](list: List[T], k: Int): T = (list, k) match {
    case (lst, 0) => lst.head
    case (lst, n) => kthElt(lst.tail, n-1)
    case _ => throw new NoSuchElementException
  }

  def size[T](list: List[T]) : Int = list match {
    case Nil => 0
    case _ :: tail => size(list.tail) + 1
  }

  def reverse[T](list: List[T]): List[T] = list match {
    case Nil => list
    case head :: Nil => List(head)
    case head :: tail => reverse(tail) ::: List(head)
  }

  def reverseFunc[T](list: List[T]): List[T] = {
    list.foldLeft(List[T]())((lst, i) => i :: lst)
  }

  def isPalindrome[T](list: List[T]): Boolean = {
    list == list.reverse
  }

  def flatten(list: List[Any]): List[Any] = list match {
    case Nil => Nil
    case (head : List[_]) :: tail => flatten(head) ++ flatten(tail)
    case head :: tail => head :: flatten(tail)
  }

  def compress[T](list: List[T]): List[T] = {
    list.foldRight(List[T]())((crt, acc) => {
      acc match {
        case head :: tail => crt match {
            case i: T if acc.head == crt => acc
            case _ => crt :: acc
          }
        case _ => crt :: acc
      }
    })
  }

  def pack[T](list: List[T]) : List[List[T]] = list match {
    case head :: Nil => List(List(head))
    case head :: _ => list span (_ == head) match {
        case (left: List[T], List()) => List(left)
        case (left: List[T], right: List[T]) => left :: pack(right)
      }
    case _ => List[List[T]]()
  }

  def encode[T](list: List[T]) : List[(T, Int)] = {
    pack(list) map { l => (l.head, l.length) }
  }

  def decode[T](list: List[(T, Int)]) : List[T] = {
    list.flatMap(pack => (0 to pack._2-1).map(i=> pack._1))
  }

  def encodeDirect[T](list: List[T]) : List[(T, Int)] = {
    list.foldRight(List[(T, Int)]())((crt, acc) => acc match {
      case head :: _ => {
        crt match {
          case i: T if i == acc.head._1 => (acc.head._1, acc.head._2 + 1) :: acc.drop(1)
          case i => (i, 1) :: acc
        }
      }
      case _ => List((crt, 1))
    })
  }

  def duplicateN[T](n: Int, list: List[T]): List[T] = {
    list.flatMap(elt => (1 to n).map(i => elt))
  }

  def drop[T](n: Int, list: List[T]): List[T] = n match
  {
    case 0 => throw new IllegalArgumentException
    case i => list.zipWithIndex.filter(pair => ((pair._2+1) % i) != 0).map(pair => pair._1)
  }

  def split[T](length: Int, list: List[T]): (List[T], List[T]) = {
    (list.take(length), list.drop(length))
  }

  def slice[T](i: Int, k: Int, list: List[T]): List[T] = {
    list.drop(i).take(k-i)
  }

  def rotate[T](n: Int, list: List[T]) : List[T] = {
    list.drop(n % list.length) ++ list.take(n % list.length)
  }

  def removeAt[T](k: Int, list: List[T]) : List[T] = {
    list.take(k) ++ list.drop(k+1)
  }

  def insertAt[T](k: Int, item: T, list: List[T]) : List[T] = {
    list.take(k) ++ (item :: list.drop(k))
  }

  def range(a: Int, b: Int): List[Int] = {
    List.range(a, b)
  }
}
