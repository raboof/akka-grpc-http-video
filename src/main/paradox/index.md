@@@section { data-background-color="#15a8ce" data-background-image="./front-bg.svg" }

### ![](./akka-reverse.svg) Akka HTTP + gRPC interop

#### Arnout Engelen

![lightbend-title](images/lightbend-color-reverse.svg)

@@@

@@@section

* https://github.com/raboof/akka-grpc-intro-video
* https://github.com/raboof/akka-grpc-http-video

@@@

@@@section

@@@@section

<img src="images/path-grpc-only.svg">

@@@@

@@@@section

<img src="images/paths-with-login-and.svg">

@@@@

@@@@section

<img src="images/paths-with-login-and-auth.svg">

@@@@

@@@

@@@section

Plain gRPC:

@@snip[Main.scala](/src/main/scala/PlainMain.scala) { #plain-grpc }

@@@

@@@section

Authentication route:

@@snip[Main.scala](/src/main/scala/Main.scala) { #authenticationRoute }

@@snip[Main.scala](/src/main/scala/Main.scala) { #combine-without-authorization }

@@@

@@@section

The new login endpoint works:

```
$ curl localhost:8080/login
Psst, please use token XYZ!
```

And the gRPC service on the same port also still runs:

```
$ grpcurl -d '{"name": "foo"}' -plaintext \
    -import-path /home/aengelen/dev/akka-grpc-http-video/src/main/protobuf \
    -proto ticker.proto \
    localhost:8080 ticker.TickerService.MonitorSymbol
{
  "name": "foo",
  "value": -1725700895
}
{
  "name": "foo",
...
```

@@@


@@@section

Authorization directive:

@@snip[Main.scala](/src/main/scala/Main.scala) { #authorizationDirective }

@@snip[Main.scala](/src/main/scala/Main.scala) { #combined }

@@@

@@@section

Now grpcurl without a token no longer works:

```
$ grpcurl -d '{"name": "foo"}' -plaintext \
    -import-path /home/aengelen/dev/akka-grpc-http-video/src/main/protobuf \
    -proto ticker.proto \
    localhost:8080 ticker.TickerService.MonitorSymbol
```
But with a token it does:
```
$ grpcurl -rpc-header "Token: XYZ" \
    -d '{"name": "foo"}' -plaintext \
    -import-path /home/aengelen/dev/akka-grpc-http-video/src/main/protobuf \
    -proto ticker.proto \
    localhost:8080 ticker.TickerService.MonitorSymbol
{
  "name": "foo",
  "value": -1725700895
}
{
  "name": "foo",
...
```

@@@

@@@section { data-background-color="#15a8ce" data-background-image="./front-bg.svg" }

### Links

* [https://github.com/raboof/akka-grpc-http-video](https://github.com/raboof/akka-grpc-http-video)
* [https://doc.akka.io/docs/akka](https://doc.akka.io/docs/akka)
* [https://doc.akka.io/docs/akka-grpc](https://doc.akka.io/docs/akka-grpc)
* [https://www.lightbend.com/videos-and-webinars](https://www.lightbend.com/videos-and-webinars)
* [https://discuss.akka.io/](https://discuss.akka.io)

![lightbend-title](./images/lightbend-color-reverse.svg)

@notes[
  That concludes today's video.
]

@@@
