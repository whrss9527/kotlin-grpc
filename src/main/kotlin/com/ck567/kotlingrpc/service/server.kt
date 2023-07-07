//package com.ck567.kotlingrpc.service
//
//import io.grpc.ServerBuilder
//
//fun helloServer() {
//    val helloService = HelloWorldService()
//    val server = ServerBuilder
//        .forPort(15001)
//        .addService(helloService)
//        .build()
//
//    Runtime.getRuntime().addShutdownHook(Thread {
//        server.shutdown()
//        server.awaitTermination()
//    })
//
//    server.start()
//    server.awaitTermination()
//}
//
//fun main(args: Array<String>) {
//    helloServer()
//}