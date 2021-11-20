package org.zeromq

import kotlin.coroutines.*

object JS : Engine {
    override val name = "zeromq.js"
    override fun createInstance(coroutineContext: CoroutineContext): EngineInstance = JSInstance()
}
