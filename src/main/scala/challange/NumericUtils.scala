package challange

import cats.syntax.either._

case class IntOverFlowError()

object NumericUtils {
  def takeWholePart[T: Numeric](x: T): Either[IntOverFlowError, Int] = {
    val stringify = String.valueOf(x).split('.').head
    Either.catchNonFatal(BigDecimal(stringify).toIntExact).leftMap(_ => IntOverFlowError())
  }
}
