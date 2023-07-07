//package com.ck567.kotlingrpc.service
//
//import com.ck567.kotlingrpc.out.HelloReply
//import com.ck567.kotlingrpc.out.HelloRequest
//import com.ck567.kotlingrpc.out.HelloServiceGrpcKt
//
//class HelloWorldService : HelloServiceGrpcKt.HelloServiceCoroutineImplBase() {
//     override suspend fun hello(request: HelloRequest): HelloReply {
//        return HelloReply.newBuilder()
//            .setMessage("Hello, ${request.name}")
//            .build()
//    }
//}