import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}


dependencies {

    implementation(compose.desktop.currentOs)
    //
    implementation("ca.uhn.hapi:hapi-base:2.2")
    implementation("ca.uhn.hapi:hapi-structures-v21:2.2")
    implementation("ca.uhn.hapi:hapi-structures-v251:2.2")
    implementation("org.slf4j:slf4j-log4j12:1.7.30")
    implementation("log4j:log4j:1.2.17")
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "KotlinDesktopHAPI"
            packageVersion = "1.0.0"
        }
    }
}
