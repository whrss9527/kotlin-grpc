package com.ck567.kotlingrpc



import io.grpc.ManagedChannelBuilder
import vampire_ios.v1.AdminGetCommodityStatisticsReq
import vampire_ios.v1.AdminGrpc


fun main() {
    val channel = ManagedChannelBuilder.forAddress("localhost", 8070).usePlaintext()
    val stub = AdminGrpc.newBlockingStub(channel.build())
    val response = stub.getCommodityStatistics(AdminGetCommodityStatisticsReq.newBuilder().setCommodityId("").setStartTime("0").setEndTime("111111111111111").build())
    println(response)
}
