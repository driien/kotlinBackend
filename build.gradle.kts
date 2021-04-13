plugins {
    kotlin("jvm") version "1.4.32"
    id("org.springframework.boot") version "2.3.3.RELEASE"
}

group = "org.backend.sample"
version = "1.0-SNAPSHOT"

allprojects {
    apply(plugin = "kotlin")
    repositories {
        mavenCentral()
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:2.3.3.RELEASE")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
}
