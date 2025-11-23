plugins {
    id("org.jetbrains.kotlin.jvm") version "2.1.10"
    {% if cookiecutter.test_framework == "kotest" %}
    id("io.kotest") version "6.0.4"
    {% endif %}
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.14.1")

    {% if cookiecutter.test_framework == "assertk" %}
    testImplementation("com.willowtreeapps.assertk:assertk:0.28.1")
    {% elif cookiecutter.test_framework == "kotest" %}
    testImplementation("io.kotest:kotest-runner-junit5:6.0.4")
    testImplementation("io.kotest:kotest-assertions-core:6.0.4")
    {% endif %}
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
