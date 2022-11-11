import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.5"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"

    //pitest
    id("info.solidsoft.pitest") version "1.5.1"
}

group = "com.me.injin"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

//pitest
apply(plugin = "info.solidsoft.pitest")

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    //approval test
    testImplementation("com.approvaltests:approvaltests:18.5.0")

    testImplementation("info.solidsoft.gradle.pitest:gradle-pitest-plugin:1.5.1")
    pitest ("com.groupcdg.pitest:pitest-kotlin-plugin:0.2.2")

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

pitest {
//    setProperty("junit5PluginVersion", "0.12")
//    setProperty("testPlugin", "junit5")
//    targetClasses.set(setOf("${project.group}.*"))  //by default "${project.group}.*"
//
//    setProperty("targetClasses", listOf("target package"))
//    setProperty("outputFormats", listOf("XML", "HTML"))

    junit5PluginVersion.set("0.12")
    avoidCallsTo.set(setOf("kotlin.jvm.internal"))
//    mutators.set(setOf("STRONGER"))
    targetClasses.set(setOf("com.me.injin.refectoringbygildedrose.legacyrefactoring.*"))  //by default "${project.group}.*"
    targetTests.set(setOf("com.me.injin.refectoringbygildedrose.legacyrefactoring.*Test"))
//    pitestVersion.set("1.7.4")   //current defined for Gradle plugin PIT version should be used
    threads.set(Runtime.getRuntime().availableProcessors())
    outputFormats.set(setOf("XML", "HTML"))
}