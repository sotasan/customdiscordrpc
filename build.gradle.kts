plugins {
    kotlin("multiplatform") version "1.5.20"
}

repositories {
    mavenCentral()
    maven { setUrl("https://jitpack.io") }
}

kotlin {
  mingwX64("native") {
    binaries {
      executable()
    }
  }
}