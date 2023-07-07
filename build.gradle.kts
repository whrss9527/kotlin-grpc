import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.google.protobuf.gradle.*;

plugins {
    id("org.springframework.boot") version "2.3.1.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    id("org.asciidoctor.convert") version "1.5.9.2"
    // 3.1.0 not support rest-docs
//	id("org.asciidoctor.jvm.convert") version "3.1.0"
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

//	maven {
//		name = "springRepo"
//		url = uri("https://repo.spring.io/libs-snapshot")
//	}

}

group = "com.icesimba.game"
version = "0.0.1-SNAPSHOT"

java.sourceCompatibility = JavaVersion.VERSION_1_8
java.targetCompatibility = JavaVersion.VERSION_1_8

sourceSets.main {
    java.srcDirs("src/main/kotlin")
}

tasks.register("showRepos") {
    doLast {
        //TODO:kotlin-dsl remove filter once we're no longer on a kotlin eap
//        println(repositories.map { it.name }.filter { it != "maven" })
    }
}

configurations.all {
    // 排除spring boot中的logging。使用log子项目。
    exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
    // check for updates every build
    resolutionStrategy.cacheChangingModulesFor(0, TimeUnit.SECONDS)
}

extra["spring-restdocs.version"] = "2.0.5.BUILD-SNAPSHOT"
val snippetsDir by extra { file("build/generated-snippets") }

dependencies {
//    implementation("junit:junit:4.12")
//    val mybatisplusVersion = "3.4.0"
//    val sprintJwtVersion = "1.0.10.RELEASE"
//    val log4j2Version = "2.17.0"
//    implementation("com.google.code.google-collections:google-collect:snapshot-20080530")
//    implementation("org.apache.logging.log4j:log4j-layout-template-json:${log4j2Version}")
//
//    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
//
//    implementation("redis.clients:jedis:3.2.0")
//    implementation("org.springframework.boot:spring-boot-starter-data-redis"){
//
//    }
//
//    implementation("org.springframework.boot:spring-boot-starter-security")
//    implementation("org.springframework.security:spring-security-jwt:$sprintJwtVersion")
//    //jwt supports
//    implementation("io.jsonwebtoken:jjwt:0.9.1")
//
//    implementation("org.springframework.boot:spring-boot-starter-web") {
//        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
//    }
//    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
//    implementation("org.jetbrains.kotlin:kotlin-reflect")
//    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//
//    // mybatis & mybatis plus supports
//    implementation("org.mybatis.dynamic-sql:mybatis-dynamic-sql:1.2.0")
//    implementation("com.baomidou:mybatis-plus-boot-starter:$mybatisplusVersion")
//    testImplementation("com.baomidou:mybatis-plus-generator:$mybatisplusVersion")
////	testImplementation("org.apache.velocity:velocity-engine-core:2.2")
//    testImplementation("org.freemarker:freemarker:2.3.30")
//
//    // for WebClient
//    implementation("org.springframework.boot:spring-boot-starter-webflux"){
//        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
//    }
//
//    developmentOnly("org.springframework.boot:spring-boot-devtools")
//
//    runtimeOnly("mysql:mysql-connector-java")
//
//    testImplementation("org.springframework.boot:spring-boot-starter-test") {
//        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
//    }
//
//    asciidoctor("org.springframework.restdocs:spring-restdocs-asciidoctor")
//    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
//    testImplementation("org.springframework.security:spring-security-test")
//
//    // test support
//    testImplementation("io.mockk:mockk:1.9")
////	testImplementation("org.junit.jupiter:junit-jupiter-api:5.2.0")
////	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.2.0")
//    testImplementation("org.assertj:assertj-core:3.11.1")
//    testImplementation("com.h2database:h2")
//
//    // log4j2 support
////	testImplementation("org.springframework.boot:spring-boot-starter-log4j2")
//
//    implementation("org.apache.logging.log4j:log4j-slf4j-impl:$log4j2Version")
//    implementation("org.apache.logging.log4j:log4j-core:$log4j2Version") {
//        //exclusions for avoiding conflict.
//        exclude(group = "ch.qos.logback", module = "logback-classic")
//        exclude(group = "ch.qos.logback", module = "log4j-to-slf4j")
//    }
//    implementation("org.apache.logging.log4j:log4j-api:$log4j2Version")
//    implementation("org.apache.logging.log4j:log4j-jul:$log4j2Version")
//    implementation("org.slf4j:jul-to-slf4j:1.7.25")
//
//    val hutoolVersion = "4.5.5"
//    implementation("cn.hutool:hutool-all:$hutoolVersion")
//	implementation("com.icesimba.simba:hutool-wrapper:4.5.5:all")
//	implementation("com.icesimba.simba:okhttp-wrapper:4.9.0:all")
    // dependencies of simba
//    implementation("com.icesimba.simba:exception:0.0.1-SNAPSHOT")
//    implementation("com.icesimba.simba:log:0.0.1-SNAPSHOT")
//    implementation("com.icesimba.simba:security:0.0.2-SNAPSHOT")
//    implementation("com.icesimba.simba:mybatis-utils:0.0.1-SNAPSHOT")
//    implementation("com.icesimba.simba:common-utils:0.0.1-SNAPSHOT")
//    implementation("com.icesimba.simba:scheduler:0.0.1-SNAPSHOT")
//    implementation("com.icesimba.simba:enumeration:0.0.1-SNAPSHOT")
//    implementation("com.squareup.okhttp3:okhttp:4.2.0")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    implementation("com.google.code.gson:gson:2.8.7")
    // tsv file reader
    implementation("com.univocity:univocity-parsers:2.8.4")
//    implementation("org.apache.httpcomponents:httpclient:4.5.12")

    implementation("com.google.protobuf:protobuf-java:3.18.1")
    implementation("io.grpc:grpc-protobuf:1.53.0")
//    implementation("io.grpc:grpc-stub:1.53.0")
    implementation("com.google.protobuf:protobuf-kotlin:3.18.1")
    implementation("io.grpc:grpc-kotlin-stub:1.3.0")
    implementation("io.grpc:grpc-netty:1.46.0")
    implementation("io.grpc:grpc-all:1.53.0")
    implementation("com.google.guava:guava:30.1.1-jre")
    // https://mvnrepository.com/artifact/io.grpc/grpc-okhttp
//    implementation("io.grpc:grpc-okhttp:1.30.1")
//    implementation("io.grpc:grpc-protobuf:1.33.1")
//    implementation("io.grpc:grpc-stub:1.33.1")
//    implementation("io.grpc:grpc-netty:1.33.1")
//    api("com.google.protobuf:protobuf-java-util:3.13.0")
//    implementation("io.grpc:grpc-all:1.33.1")
//    api("io.grpc:grpc-kotlin-stub:0.2.1")
//    implementation("io.grpc:protoc-gen-grpc-kotlin:0.1.5")

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.test{
    outputs.dir(snippetsDir)
    useJUnitPlatform()
}

tasks.asciidoctor{
    sources(delegateClosureOf<PatternSet> {
        include("**")
    })
    logDocuments = true
    inputs.dir(snippetsDir)
    dependsOn(tasks.test)
    val outputDir = tasks.asciidoctor.get().outputDir

    //copy to web resources directory
    doLast{
        copy{
            from("$outputDir/html5")
            into("build/resources/main/docs")
        }
    }
}

tasks.bootRun {
    dependsOn(tasks.getByName("asciidoctor"))
}

tasks.bootJar {
    dependsOn(tasks.getByName("asciidoctor"))
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
