package ticker

import akka.actor.ActorSystem
import akka.grpc.scaladsl.{ServerReflection, ServiceHandler}
import akka.http.scaladsl._
import akka.http.scaladsl.server.{Directive0, Route}
import akka.stream.SystemMaterializer
import akka.http.scaladsl.server.Directives._

//#plain-grpc
object PlainMain extends App {
    implicit val system = ActorSystem("ticker")

    Http().newServerAt("127.0.0.1", 8080)
      .bind(TickerServiceHandler(new TickerServiceImpl))
}
//#plain-grpc