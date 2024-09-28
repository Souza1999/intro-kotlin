plugins {
    kotlin("jvm") version "1.9.22"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.0")
}

tasks.test {
    useJUnitPlatform()
}

// Excluir arquivos .ipynb da compilação
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    exclude("**/*.ipynb")
}

kotlin {
    jvmToolchain(21)
}
