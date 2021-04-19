plugins {
    kotlin("jvm")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:2.3.3.RELEASE")
    implementation(project(":context:book:interaction"))
    implementation(project(":context:book:secondary-adapter"))
}

