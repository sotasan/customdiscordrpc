plugins {
  kotlin("jvm") version "1.5.20"
}

group = "net.pryoscode"
version = "2.0.0"

tasks {
  register("fatJar", Jar::class.java) {
    archiveName = project.name + ".jar"
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    manifest {
      attributes["Implementation-Title"] = project.name
      attributes["Implementation-Version"] = project.version
      attributes["Main-Class"] = "net.pryoscode.customdiscordrpc.MainKt"
    }
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    from(sourceSets.main.get().output)
  }
}

repositories {
  mavenCentral()
  maven { setUrl("https://jitpack.io") }
}

dependencies {
  implementation("com.github.MinnDevelopment:java-discord-rpc:v2.0.1")
  implementation("com.github.MinnDevelopment:discord-rpc-release:v3.3.0")
  implementation("org.yaml:snakeyaml:1.29")
  implementation("com.google.code.gson:gson:2.8.7")
}