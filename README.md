# aiyou

[![Travis CI](https://travis-ci.org/adelbertc/io.svg?branch=master)](https://travis-ci.org/adelbertc/io)

### Origin
ǎi you is a romanized spelling of the Chinese phrase 哎呦, which is onomatopoeic for the sound
made when surprised, as is the case when programming with side effects.

aiyou provides IO types and classes for Scala.

```scala
import cats.data.Kleisli
import cats.implicits._
import aiyou._
import aiyou.implicits._

object MyApp extends SafeApp {
  def ioAction: IO[Int] = for {
    _ <- IO.print("hello")
    _ <- IO.print(" ")
    _ <- IO.println("world")
  } yield 42

  def foo[F[_]: MonadIO]: F[Int] = ioAction.liftIO[F]

  override def runl(args: List[String]): IO[Unit] = {
    val kleisli = foo[Kleisli[IO, Unit, ?]]
    val ioInt = kleisli.run(())
    ioInt.void
  }
}
```

The **aiyou** project and contributors support the
[Typelevel](http://typelevel.org/) [Code of Conduct](http://typelevel.org/conduct.html) and want all its
associated channels to be a safe and friendly environment for contributing and learning.

## Quick Start
**aiyou** is natively built against Scala 2.10.x, Scala 2.11.x, 2.12.x, Cats 0.8.1, and Scalaz 7.2.x.

The modules of **aiyou** are (append `-cats` or `-scalaz` to get the full module name for the corresponding environment):

* `core`: IO related types and classes
* `laws`: laws for the type classes

## License
Code is provided under the MIT license available at https://opensource.org/licenses/MIT,
as well as in the LICENSE file. The design is informed by many other projects, in particular
[Cats](https://github.com/typelevel/cats) and [Scalaz](https://github.com/scalaz/scalaz).
