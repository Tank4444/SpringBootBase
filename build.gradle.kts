import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.lombok") version "1.8.0"
    id("io.freefair.lombok") version "5.3.0"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.8.0"
    application
}

group = "ru.chuikov"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

val springBootVersion:String by project
val springSecJwt:String by project
val h2Database: String by project
val springAuthorizationServer:String by project

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.boot:spring-boot-starter:$springBootVersion")
    implementation("org.springframework.boot:spring-boot-starter-web:$springBootVersion")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:$springBootVersion")
    implementation("org.springframework.boot:spring-boot-starter-security:$springBootVersion")
    //implementation("org.springframework.security:spring-security-jwt:$springSecJwt")

    compileOnly("org.projectlombok:lombok")
    runtimeOnly("com.h2database:h2:$h2Database")
    annotationProcessor("org.projectlombok:lombok")
    implementation("org.springframework.security:spring-security-oauth2-authorization-server:$springAuthorizationServer")



}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}
/*
application {
    mainClass.set("MainKt")
}
 */
