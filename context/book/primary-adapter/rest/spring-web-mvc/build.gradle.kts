plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":context:book:domain"))

    implementation("org.springframework.boot:spring-boot-starter-web:2.3.3.RELEASE")
    implementation(project(":context:book:domain"))
    implementation(project(":library-source:command-query"))
    implementation("org.axonframework:axon-spring-boot-starter:4.3.2") {
        exclude(group = "org.axonframework", module = "axon-server-connector")
    }
    implementation("org.axonframework.extensions.tracing:axon-tracing-spring-boot-starter:4.3")
}
