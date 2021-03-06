package aiyou

#+cats
import cats.Monad
#-cats

#+scalaz
import scalaz.Monad
#-scalaz

trait MonadThrow[F[_]] {
  def monad: Monad[F]

  /** Throws an exception in the effect. */
  def throwM[A](e: Throwable): F[A]
}

object MonadThrow {
  def apply[F[_]](implicit F: MonadThrow[F]): MonadThrow[F] = F
}
