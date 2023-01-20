plugins {
    id("org.springframework.boot") version "3.0.1"
    id("io.spring.dependency-management") version ("1.0.12.RELEASE")
}

dependencies {
    implementation(project(path = ":starlucks-store"))
    implementation(project(path = ":starlucks-menu"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.mockito:mockito-junit-jupiter:4.11.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")
}

tasks {
    bootJar { enabled = true }
    jar { enabled = false }
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
