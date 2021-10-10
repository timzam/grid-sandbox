import org.jetbrains.gradle.ext.ModuleSettings

plugins {
    kotlin("jvm") version "1.5.31"
    id("org.jetbrains.gradle.plugin.idea-ext") version "1.1"
}

repositories {
    mavenCentral()
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
    gradleVersion = "7.2"
}

idea {
    module {
        (this as ExtensionAware)
        configure<ModuleSettings> {
            excludeDirs = setOf(
                file(".gradle"),
                file("build"),
            )
        }
    }
}

kotlin {
    target.compilations.all {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
    sourceSets {
        all {
            languageSettings.apply {
                languageVersion = "1.5"
                apiVersion = "1.5"
                progressiveMode = true
            }
        }
        main {
            dependencies {
            }
        }
    }
}
