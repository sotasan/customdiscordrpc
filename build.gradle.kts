import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.5.21"
  id("org.openjfx.javafxplugin") version "0.0.10"
}

javafx {
  version = JavaVersion.VERSION_11.toString()
  modules("javafx.controls", "javafx.fxml")
}

group = "net.pryoscode"
version = "2.0.0"

tasks.jar {
  archiveFileName.set(project.name + ".jar")
  duplicatesStrategy = DuplicatesStrategy.EXCLUDE
  manifest.attributes["Implementation-Title"] = project.name
  manifest.attributes["Implementation-Version"] = project.version
  manifest.attributes["Main-Class"] = project.group.toString() + "." + project.name.toLowerCase() + ".Main"
  from(configurations.runtimeClasspath.get().map { if (it.isDirectory()) it else zipTree(it) })
}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
}

repositories {
  mavenCentral()
  maven(url = "https://jitpack.io")
}

dependencies {
  implementation("com.github.MinnDevelopment:java-discord-rpc:v2.0.1")
  implementation("com.github.MinnDevelopment:discord-rpc-release:v3.3.0")
  implementation("org.yaml:snakeyaml:1.29")
  implementation("com.google.code.gson:gson:2.8.7")
  implementation("com.github.Dansoftowner:FXTaskbarProgressBar:v11.4")
}