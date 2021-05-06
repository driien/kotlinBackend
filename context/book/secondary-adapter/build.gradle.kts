plugins {
    id("org.springframework.boot") apply(false)
    id("io.spring.dependency-management")
    kotlin("jvm")
}

dependencyManagement {
    imports {
        mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
    }
}

dependencies {
    implementation(project(":context:book:domain"))
    implementation("org.springframework.boot:spring-boot-starter-web:2.3.3.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}