import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.allopen") version "1.9.22"
    kotlin("plugin.noarg") version "1.9.22"
    id("io.quarkus")
    id("org.graalvm.buildtools.native") version "0.10.1"
}

repositories {
    mavenCentral()
    mavenLocal()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    implementation (enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation (enforcedPlatform("${quarkusPlatformGroupId}:quarkus-google-cloud-services-bom:${quarkusPlatformVersion}"))

    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.22")
    implementation ("org.jetbrains.kotlin:kotlin-reflect:1.9.22")
    implementation ("org.jetbrains.kotlinx:multik-default:0.2.3")

    implementation ("io.quarkus:quarkus-arc")
    implementation ("io.quarkus:quarkus-kotlin")
    implementation ("io.quarkus:quarkus-cache")
    implementation ("io.quarkus:quarkus-resteasy-reactive")
    implementation ("io.quarkus:quarkus-resteasy-reactive-jackson")
    implementation ("io.quarkus:quarkus-resteasy-reactive-qute")
    implementation ("io.quarkus:quarkus-websockets")
    implementation ("io.quarkus:quarkus-swagger-ui")
    implementation ("io.quarkus:quarkus-smallrye-openapi")
    implementation ("io.quarkus:quarkus-smallrye-jwt")
    implementation ("io.quarkus:quarkus-smallrye-jwt-build")
    implementation ("io.quarkus:quarkus-rest-client-reactive-jackson")
    implementation ("io.quarkus:quarkus-hibernate-validator")
    implementation ("io.quarkus:quarkus-mongodb-panache-kotlin")
    implementation ("io.quarkus:quarkus-mutiny")
    implementation ("io.quarkus.platform:quarkus-google-cloud-services-bom")
    implementation ("com.google.code.gson:gson")
    implementation ("com.google.firebase:firebase-admin")
    implementation ("com.google.api-client:google-api-client")
    implementation ("io.quarkiverse.googlecloudservices:quarkus-google-cloud-storage")
    implementation ("io.quarkiverse.googlecloudservices:quarkus-google-cloud-firebase-admin")
    implementation("com.sun.mail:javax.mail:1.6.2")

    implementation ("io.smallrye.reactive:mutiny-kotlin:2.5.8")
    implementation ("jakarta.annotation:jakarta.annotation-api:2.1.1")
    implementation ("commons-codec:commons-codec:1.16.0")
    implementation ("com.github.seancfoley:ipaddress:5.4.2")

    implementation ("com.cloudinary:cloudinary-core:1.35.0")
    implementation ("com.cloudinary:cloudinary-http45:1.35.0")
    implementation ("software.amazon.awssdk:s3:2.22.0")
    implementation ("com.hyperwallet:sdk:2.4.5")
    implementation ("com.paypal.sdk:payouts-sdk:1.1.1")
    implementation ("com.stripe:stripe-java:24.18.0")
    implementation ("io.seruco.encoding:base62:0.1.3")

    implementation ("com.fasterxml.jackson.module:jackson-module-kotlin:2.17.0")
    implementation ("org.jboss.logging:commons-logging-jboss-logging:1.0.0.Final")
    implementation ("org.jboss.logmanager:log4j-jboss-logmanager:1.3.0.Final")
    implementation ("org.jboss.slf4j:slf4j-jboss-logmanager:2.0.1.Final")

    annotationProcessor ("io.quarkus:quarkus-panache-common")
    testImplementation ("io.quarkus:quarkus-junit5")
    testImplementation ("io.rest-assured:rest-assured")
}

group = "id.gen8.api.entity"
version = "0.9.0"

// ref. Guava issue : https://github.com/quarkusio/quarkus/issues/35499
configurations.all {
    resolutionStrategy.capabilitiesResolution.withCapability("com.google.collections:google-collections") {
        select("com.google.guava:guava:0")
    }
    // and/or
    resolutionStrategy.capabilitiesResolution.withCapability("com.google.guava:listenablefuture") {
        select("com.google.guava:guava:0")
    }
    resolutionStrategy.capabilitiesResolution.withCapability("aws.sdk.kotlin:s3") {
        select("com.squareup.okhttp3:okhttp:5.0.0-alpha.11")
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

allOpen {
    annotation("jakarta.ws.rs.Path")
    annotation("jakarta.enterprise.context.ApplicationScoped")
    annotation("jakarta.persistence.Entity")
    annotation("io.quarkus.test.junit.QuarkusTest")
}

tasks.withType<Test> {
    systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
    exclude("ai.bitflow.api.*")
    exclude("id.g8id.api.*")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
    kotlinOptions.javaParameters = true
}

noArg {
    annotation("id.g8id.api.antn.NoArg")
}
