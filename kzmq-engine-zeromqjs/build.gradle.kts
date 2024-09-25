/*
 * Copyright (c) 2021-2024 Didier Villevalois and Kzmq contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("plugin.library")
    id("maven-publish")
}

kotlin {
    jsTargets()
    wasmTargets()

    sourceSets {
        jsMain {
            dependencies {
                implementation(project(":kzmq-core"))
                implementation(libs.kotlinx.io.core)
                implementation(npm("zeromq", libs.versions.zeromqjs.get()))
            }
        }
        wasmJsMain {
            dependencies {
                implementation(project(":kzmq-core"))
                implementation(libs.kotlinx.io.core)
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kotlinx.coroutines.core.wasm.js)
                implementation(libs.kotlin.stdlib.wasm.js)
                implementation(npm("zeromq", libs.versions.zeromqjs.get()))
            }
        }
    }
}
