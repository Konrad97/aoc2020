plugins {
    kotlin("multiplatform") version "1.4.20"
}
group = "me.melze"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    nativeTarget.apply {
        binaries {
            executable("d01") {
                entryPoint = "y2020.d01.main"
            }
            executable("d02") {
                entryPoint = "y2020.d02.main"
            }
            executable("d03") {
                entryPoint = "y2020.d03.main"
            }
            executable("d04") {
                entryPoint = "y2020.d04.main"
            }
            executable("d05") {
                entryPoint = "y2020.d05.main"
            }
            executable("d06") {
                entryPoint = "y2020.d06.main"
            }
            executable("d07") {
                entryPoint = "y2020.d07.main"
            }
            executable("d08") {
                entryPoint = "y2020.d08.main"
            }
            executable("d09") {
                entryPoint = "y2020.d09.main"
            }
            executable("d10") {
                entryPoint = "y2020.d10.main"
            }
            executable("d11") {
                entryPoint = "y2020.d11.main"
            }
        }
    }
    sourceSets {
        val nativeMain by getting
        val nativeTest by getting
    }
}