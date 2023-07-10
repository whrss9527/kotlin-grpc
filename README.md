# kotlin-grpc
kotlin 

``` sh 
./gradlew clean build 

```

generate in build/generated/source/proto/main
then 
use in your biz.

---

add to your project

``` groovy
import com.google.protobuf.gradle.*

plugins {
    id("com.google.protobuf") version "0.9.2"
}

dependencies {
    implementation("com.univocity:univocity-parsers:2.9.1")
    implementation("com.google.protobuf:protobuf-java:3.22.2")
    implementation("io.grpc:grpc-protobuf:1.53.0")
    implementation("com.google.protobuf:protobuf-kotlin:3.22.2")
    implementation("io.grpc:grpc-kotlin-stub:1.3.0")
    implementation("io.grpc:grpc-netty:1.56.1")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.19.4"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:${grpcVersion}"
        }
        id("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:1.3.0:jdk8@jar"
        }
    }

    // Enable Kotlin generation
    generateProtoTasks {
        all().forEach {
            it.plugins {
                id("grpc")
                id("grpckt")
            }
        }
    }
}

```
