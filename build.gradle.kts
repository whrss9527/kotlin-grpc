import com.google.protobuf.gradle.*;

plugins {
    id("org.springframework.boot") version "2.3.1.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    id("org.asciidoctor.convert") version "1.5.9.2"
    // 3.1.0 not support rest-docs
    kotlin("jvm") version "1.6.0"
    kotlin("plugin.spring") version "1.6.0"
    id("com.google.protobuf") version "0.9.2"
}
val protobufVersion by extra("3.17.3")
val protobufPluginVersion by extra("0.8.14")
val grpcVersion by extra("1.40.1")
repositories {
    maven {
        name = "publicRepo"
        url = uri("https://repository.icesimba.cn/repository/maven-public/")
    }
    mavenCentral()
}

group = "com.icesimba.game"
version = "0.0.1-SNAPSHOT"

java.sourceCompatibility = JavaVersion.VERSION_1_8
java.targetCompatibility = JavaVersion.VERSION_1_8

sourceSets.main {
    java.srcDirs("src/main/kotlin")
}



extra["spring-restdocs.version"] = "2.0.5.BUILD-SNAPSHOT"
val snippetsDir by extra { file("build/generated-snippets") }

dependencies {
    // tsv file reader
    implementation("com.univocity:univocity-parsers:2.9.1")
    implementation("com.google.protobuf:protobuf-java:3.22.2")
    implementation("io.grpc:grpc-protobuf:1.53.0")
    implementation("com.google.protobuf:protobuf-kotlin:3.22.2")
    implementation("io.grpc:grpc-kotlin-stub:1.3.0")
    implementation("io.grpc:grpc-netty:1.46.0")
    implementation("io.grpc:grpc-all:1.53.0")
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
//            it.builtins {
//                id("kotlin")
//            }
        }
    }
}
