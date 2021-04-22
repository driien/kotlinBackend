plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":context:book:domain"))

    implementation("org.springframework.boot:spring-boot-starter-web:2.3.3.RELEASE")
<<<<<<< HEAD:context/book/primary-adapter/rest/spring-web-mvc/build.gradle.kts
    implementation(project(":context:book:domain"))
    implementation(project(":library-source:command-query"))
=======
    implementation("org.axonframework:axon-spring-boot-starter:4.3.2") {
        exclude(group = "org.axonframework", module = "axon-server-connector")
    }
    implementation("org.axonframework.extensions.tracing:axon-tracing-spring-boot-starter:4.3")
>>>>>>> 155397145ce434e135eaf372f3850b5fa0a0935b:context/book/primary-adapter/build.gradle.kts
}
