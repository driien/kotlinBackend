plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":context:book:domain"))
    implementation("org.springframework.boot:spring-boot-starter-web:2.3.3.RELEASE")
}