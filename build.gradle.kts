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
        maven { setUrl ("https://jitpack.io")}
    }

    dependencies {
        implementation("javax.inject:javax.inject:1")
    }

}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:2.3.3.RELEASE")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")

    //JavaX
    implementation("javax.transaction:javax.transaction-api:1.3")

    //Axon framework
    implementation("org.axonframework:axon-spring-boot-starter:4.3.2") {
        exclude(group = "org.axonframework", module = "axon-server-connector")
    }
    implementation("org.axonframework.extensions.tracing:axon-tracing-spring-boot-starter:4.3")

    //CQRS
    implementation("com.github.kotato:KAxon-CQRS:0.0.10")

    //Test
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")


}

