import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

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

    java.sourceCompatibility = JavaVersion.VERSION_11
    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "11"
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }
    tasks.withType<Test> {
        useJUnitPlatform()
    }

    dependencies {
        implementation("javax.inject:javax.inject:1")
        implementation("org.springframework.boot:spring-boot-starter-web:2.3.3.RELEASE")
    }
}

dependencies {
    implementation(project(":library-source:command-query"))
    implementation(project(":library-source:fp"))
    implementation(project(":context:book:primary-adapter:rest:spring-web-mvc"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("javax.transaction:javax.transaction-api:1.3")
    implementation("org.axonframework:axon-spring-boot-starter:4.3.2") {
        exclude(group = "org.axonframework", module = "axon-server-connector")
    }
    implementation("org.axonframework.extensions.tracing:axon-tracing-spring-boot-starter:4.3")
    implementation("com.github.kotato:KAxon-CQRS:0.0.10")
    implementation("io.arrow-kt:arrow-core:0.11.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
}
