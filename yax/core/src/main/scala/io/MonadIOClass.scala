package aiyou

trait MonadIOClass[F[_]] extends MonadIO[F] {
  final def monadIO: MonadIO[F] = this
}
