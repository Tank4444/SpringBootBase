import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.lombok") version "1.8.0"

    id("io.freefair.lombok") version "5.3.0"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.8.0"
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
    jcenter()
}

val springBootVersion:String by project
val springSecJwt:String by project
val h2Database: String by project
val springAuthorizationServer:String by project
val springOAuth2:String by project

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.boot:spring-boot-starter:$springBootVersion")
    implementation("org.springframework.boot:spring-boot-starter-web:$springBootVersion")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:$springBootVersion")
    implementation("org.springframework.boot:spring-boot-starter-security:$springBootVersion")
    implementation("org.springframework.security.oauth:spring-security-oauth2:$springOAuth2")

    implementation("javax.xml.bind:jaxb-api:2.3.0")
    //implementation("org.hibernate.javax.persistence:hibernate-jpa-2.1-api:1.0.2.Final")
    implementation("javax.validation:validation-api:2.0.1.Final")
    implementation("org.springframework.boot:spring-boot-starter-actuator:$springBootVersion")
    runtimeOnly("com.h2database:h2:$h2Database")
    annotationProcessor("org.projectlombok:lombok")
    implementation("org.springframework.boot:spring-boot-devtools:$springBootVersion")
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
