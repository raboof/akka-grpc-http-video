package ticker

import akka.actor.ActorSystem
import akka.grpc.scaladsl.{ServerReflection, ServiceHandler}
import akka.http.scaladsl._
import akka.http.scaladsl.server.{Directive0, Route}
import akka.stream.SystemMaterializer
import akka.http.scaladsl.server.Directives._

object Main extends App {
  implicit val system = ActorSystem("ticker")

  //#authenticationRoute
  val authenticationRoute: Route = path("login") {
    get {
      complete("Psst, please use token XYZ!")
    }
  }
  //#authenticationRoute

  //#combine-without-authorization
  val concatenated =
    concat(
      authenticationRoute,
      handle(TickerServiceHandler(new TickerServiceImpl))
    )
  //#combine-without-authorization

  //#authorizationDirective
  val authorizationDirective: Directive0 =
    headerValueByName("token").flatMap { token =>
      if (token == "XYZ") pass
      else reject
    }
  //#authorizationDirective

  //#combined
  val combined = concat(
    authenticationRoute,
    authorizationDirective {
      handle(TickerServiceHandler(new TickerServiceImpl))
    }
  )
  //#combined

  //#main
  Http().newServerAt("127.0.0.1", 8080).bind(combined)
  //#main
}