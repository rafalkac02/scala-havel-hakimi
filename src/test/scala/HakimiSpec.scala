import org.scalatest._
import flatspec._
import matchers._
import Hakimi._

class HakimiSpec extends AnyFlatSpec with should.Matchers {

  "remove0()" should "return new number according to special adding rules" in {

    remove0(Seq.empty[Int]) shouldBe Seq.empty[Int]
    remove0(Seq(0, 1, 2, 3)) shouldBe Seq(1, 2, 3)
    remove0(Seq(2, 0, 4, 0)) shouldBe Seq(2, 4)
    remove0(Seq(0, 0, 0)) shouldBe Seq.empty[Int]
  }

  "sortDesc()" should "return Seq sorted in descending order" in {
    sortDesc(Seq.empty[Int]) shouldBe Seq.empty[Int]
    sortDesc(Seq(5)) shouldBe Seq(5)
    sortDesc(Seq(0, 0, 0, 4, 0)) shouldBe Seq(4, 0, 0 , 0, 0)
    sortDesc(Seq(5, 1, 3, 4, 2)) shouldBe Seq(5, 4, 3, 2, 1)
  }

  "lengthCheck()" should "return true if N is greater than the number of answers" in {

    lengthCheck(7, Seq(6, 5, 5, 3, 2, 2, 2)) shouldBe false
    lengthCheck(5, Seq(5, 5, 5, 5, 5)) shouldBe false
    lengthCheck(5, Seq(5, 5, 5, 5)) shouldBe true
    lengthCheck(3, Seq(1, 1)) shouldBe true
    lengthCheck(1, Seq()) shouldBe true
    lengthCheck(0, Seq()) shouldBe false
  }

  "frontReduce()" should "subtract 1 from each of the first N elements in the sequence, and return the result" in {

    frontReduce(4, Seq(5, 4, 3, 2, 1)) shouldBe Seq(4, 3, 2, 1, 1)
    frontReduce(11,Seq(14, 13, 13, 13, 12, 10, 8, 8, 7, 7, 6, 6, 4, 4, 2)) shouldBe Seq(13, 12, 12, 12, 11, 9, 7, 7, 6, 6, 5, 6, 4, 4, 2)
    frontReduce(1, Seq(10, 10, 10)) shouldBe Seq(9, 10, 10)
    frontReduce(3, Seq(10, 10, 10)) shouldBe Seq(9, 9, 9)
    frontReduce(1, Seq(1)) shouldBe Seq(0)
  }

  "hakimiAlgorithm()" should "return true if the answers are consistent (i.e. it's possible that everyone is telling the truth) " +
    "and false if the answers are inconsistent (i.e. someone must be lying)" in {

    hakimiAlgorithm(Seq(5, 3, 0, 2, 6, 2, 0, 7, 2, 5)) shouldBe false
    hakimiAlgorithm(Seq(4, 2, 0, 1, 5, 0)) shouldBe false
    hakimiAlgorithm(Seq(3, 1, 2, 3, 1, 0)) shouldBe true
    hakimiAlgorithm(Seq(16, 9, 9, 15, 9, 7, 9, 11, 17, 11, 4, 9, 12, 14, 14, 12, 17, 0, 3, 16)) shouldBe true
    hakimiAlgorithm(Seq(14, 10, 17, 13, 4, 8, 6, 7, 13, 13, 17, 18, 8, 17, 2, 14, 6, 4, 7, 12)) shouldBe true
    hakimiAlgorithm(Seq(15, 18, 6, 13, 12, 4, 4, 14, 1, 6, 18, 2, 6, 16, 0, 9, 10, 7, 12, 3)) shouldBe false
    hakimiAlgorithm(Seq(6, 0, 10, 10, 10, 5, 8, 3, 0, 14, 16, 2, 13, 1, 2, 13, 6, 15, 5, 1)) shouldBe false
    hakimiAlgorithm(Seq(2, 2, 0)) shouldBe false
    hakimiAlgorithm(Seq(3, 2, 1)) shouldBe false
    hakimiAlgorithm(Seq(1, 1)) shouldBe true
    hakimiAlgorithm(Seq(1)) shouldBe false
    hakimiAlgorithm(Seq()) shouldBe true

  }


}