package challange

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.prop.{TableDrivenPropertyChecks, TableFor2}

class NumericUtilsGenTest extends AnyFlatSpec with TableDrivenPropertyChecks {

  val doubleTestCases =
    Table(
      ("input", "output"),
      (Double.MinValue, Right(-1)),
      (Double.MaxValue, Right(1)),
      (1797693.123d, Right(1797693)),
      (-179769.123d, Right(-179769)),
      (0d, Right(0)),
      (Int.MaxValue.toDouble + 0.3d, Right(2)),
      (Int.MinValue.toDouble - 0.3d, Right(-2)),
    )

  val floatTestCases: TableFor2[Float, Either[IntOverFlowError, Int]] =
    Table(
      ("input", "output"),
      (Float.MinValue, Right(-3)),
      (Float.MaxValue, Right(3)),
      (0f, Right(0)),
      (Int.MaxValue.toFloat + 0.3f, Right(2)),
      (Int.MinValue.toFloat - 0.3f, Right(-2)),
    )

  val bigDecimalTestCases: TableFor2[BigDecimal, Either[IntOverFlowError, Int]] =
    Table(
      ("input", "output"),
      (BigDecimal(Double.MinValue), Right(-1)),
      (BigDecimal(Double.MaxValue), Right(1)),
      (0f, Right(0)),
      (BigDecimal(Double.MinValue) + 0.3d, Right(-1)),
      (BigDecimal(Double.MaxValue) - 0.3d,  Right(1)),
    )

  val longTestCases: TableFor2[Long, Either[IntOverFlowError, Int]] =
    Table(
      ("input", "output"),
      (Long.MaxValue, Left(IntOverFlowError())),
      (Long.MinValue, Left(IntOverFlowError())),
      (0l, Right(0)),
    )

  behavior of "NumericUtils"

  forAll(doubleTestCases) { (input: Double, output: Either[IntOverFlowError, Int]) =>
    it should s"cast Double $input value to $output" in {
      NumericUtils.takeWholePart(input) shouldBe output
    }
  }

  forAll(floatTestCases) { (input: Float, output: Either[IntOverFlowError, Int]) =>
    it should s"cast Float $input value to $output" in {
      NumericUtils.takeWholePart(input) shouldBe output
    }
  }

  forAll(bigDecimalTestCases) { (input: BigDecimal, output: Either[IntOverFlowError, Int]) =>
    it should s"cast BigDecimal $input value to $output" in {
      NumericUtils.takeWholePart(input) shouldBe output
    }
  }
  forAll(longTestCases) { (input: Long, output: Either[IntOverFlowError, Int]) =>
    it should s"cast Long $input value to $output" in {
      NumericUtils.takeWholePart(input) shouldBe output
    }
  }

}
