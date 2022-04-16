import scala.annotation.tailrec

object Hakimi {

  def remove0(ns: Seq[Int]) = ns.filterNot(_ == 0)

  def sortDesc(ns: Seq[Int]) = ns.sorted.reverse

  def lengthCheck(n: Int, ns: Seq[Int]) = n > ns.length

  def frontReduce(n: Int, ns: Seq[Int]) = ns.take(n).map(_-1) ++ ns.drop(n)


//  1. Remove all 0's from the sequence (i.e. warmup1).
//  2. If the sequence is now empty (no elements left), stop and return true.
//  3. Sort the sequence in descending order (i.e. warmup2).
//  4. Remove the first answer (which is also the largest answer, or tied for the largest) from the sequence and call it N.
  //  The sequence is now 1 shorter than it was after the previous step.
//  5. If N is greater than the length of this new sequence (i.e. warmup3), stop and return false.
//  6. Subtract 1 from each of the first N elements of the new sequence (i.e. warmup4).
//  7. Continue from step 1 using the sequence from the previous step.

  @tailrec
  def hakimiAlgorithm(ns: Seq[Int]): Boolean = {
    var seq = remove0(ns)
    if (seq.isEmpty) return true
    seq = sortDesc(seq)
    val n = seq.head
    seq = seq.tail
    if (lengthCheck(n, seq)) return false
    seq = frontReduce(n, seq)

    hakimiAlgorithm(seq)
  }

  println(hakimiAlgorithm(Seq(16, 9, 9, 15, 9, 7, 9, 11, 17, 11, 4, 9, 12, 14, 14, 12, 17, 0, 3, 16)))
  println(hakimiAlgorithm(Seq(14, 10, 17, 13, 4, 8, 6, 7, 13, 13, 17, 18, 8, 17, 2, 14, 6, 4, 7, 12)))
  println(hakimiAlgorithm(Seq(15, 18, 6, 13, 12, 4, 4, 14, 1, 6, 18, 2, 6, 16, 0, 9, 10, 7, 12, 3)))
  println(hakimiAlgorithm(Seq(6, 0, 10, 10, 10, 5, 8, 3, 0, 14, 16, 2, 13, 1, 2, 13, 6, 15, 5, 1)))

}