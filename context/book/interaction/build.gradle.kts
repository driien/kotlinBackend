plugins {
    kotlin("jvm")
}

dependencies {
    //Project implementation
    implementation(project(":context:book:domain"))

    //Springboot framework
    implementation("org.springframework.boot:spring-boot-starter-web:2.3.3.RELEASE")

    //Axon framework
    implementation("org.axonframework:axon-spring-boot-starter:4.3.2") {
        exclude(group = "org.axonframework", module = "axon-server-connector")
    }
    implementation("org.axonframework.extensions.tracing:axon-tracing-spring-boot-starter:4.3")

}