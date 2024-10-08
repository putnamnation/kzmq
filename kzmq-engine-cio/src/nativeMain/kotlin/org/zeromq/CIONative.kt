/*
 * Copyright (c) 2021-2024 Didier Villevalois and Kzmq contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */

package org.zeromq

import kotlinx.coroutines.*
import kotlin.coroutines.*

import org.zeromq.util.*

@OptIn(InternalAPI::class)
internal actual fun addToLoader() {
    Engines.append(CIO)
}

internal actual fun createEngine(coroutineContext: CoroutineContext) =
    CIOEngine(coroutineContext + Dispatchers.IO)

@Suppress("DEPRECATION", "unused")
@OptIn(ExperimentalStdlibApi::class)
@EagerInitialization
private val initHook = CIO
