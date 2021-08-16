val kotlinxCoroutinesVersion: String by project
val jeromqVersion: String by project

kotlin {
    js(IR) {
        nodejs {}
        binaries.library()
    }

    sourceSets {
        all {
            languageSettings.useExperimentalAnnotation("kotlinx.coroutines.ExperimentalCoroutinesApi")
        }

        val jsMain by getting {
            dependencies {
                implementation(project(":ktzmq-core"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinxCoroutinesVersion")
                implementation(npm("zeromq", "6.0.0-beta.6"))
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile>().configureEach {
    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
    }
}
