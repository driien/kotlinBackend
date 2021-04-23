plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":context:book:domain"))

    implementation("org.axonframework:axon-spring-boot-starter:4.3.2") {
        exclude(group = "org.axonframework", module = "axon-server-connector")
    }
    implementation("org.axonframework.extensions.tracing:axon-tracing-spring-boot-starter:4.3")

}