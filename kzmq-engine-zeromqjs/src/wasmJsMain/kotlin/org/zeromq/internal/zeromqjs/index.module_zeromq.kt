/*
 * Copyright (c) 2021-2024 Didier Villevalois and Kzmq contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */

@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)

@file:JsModule("zeromq")

package org.zeromq.internal.zeromqjs

import org.khronos.webgl.*
import kotlin.js.*

internal external interface Writable {
    var multicastHops: Int
    var sendBufferSize: Int
    var sendHighWaterMark: Int
    var sendTimeout: Int
    fun send(message: JsArray<ArrayBuffer>): Promise<JsAny>
}

internal external interface Readable {
    var receiveBufferSize: Int
    var receiveHighWaterMark: Int
    var receiveTimeout: Int
    fun receive(): Promise<JsArray<ArrayBuffer>>
}

internal external interface `T$0` {
    var context: Context
}

//internal external interface EventSubscriber {
//    fun <E : Any> on(type: E, listener: (data: EventOfType<E>) -> Unit): EventSubscriber
//    fun <E : Any> off(type: E, listener: (data: EventOfType<E>) -> Unit): EventSubscriber
//}

internal open external class Pair() : Socket, Writable,
    Readable {
    override var multicastHops: Int
    override var sendBufferSize: Int
    override var sendHighWaterMark: Int
    override var sendTimeout: Int
    override fun send(message: JsArray<ArrayBuffer>): Promise<JsAny>
    override var receiveBufferSize: Int
    override var receiveHighWaterMark: Int
    override var receiveTimeout: Int
    override fun receive(): Promise<JsArray<ArrayBuffer>>
}

internal open external class Publisher() : Socket,
    Writable {
    override var multicastHops: Int
    override var sendBufferSize: Int
    override var sendHighWaterMark: Int
    override var sendTimeout: Int
    override fun send(message: JsArray<ArrayBuffer>): Promise<JsAny>
    open var noDrop: Boolean
    open var conflate: Boolean
    open var invertMatching: Boolean
}

internal open external class Subscriber() : Socket,
    Readable {
    override var receiveBufferSize: Int
    override var receiveHighWaterMark: Int
    override var receiveTimeout: Int
    override fun receive(): Promise<JsArray<ArrayBuffer>>
    open var conflate: Boolean
    open var invertMatching: Boolean
    open fun subscribe(vararg prefixes: String /* Buffer | String */)
    open fun unsubscribe(vararg prefixes: String /* Buffer | String */)
}

internal open external class Request() : Socket, Readable,
    Writable {
    override var receiveBufferSize: Int
    override var receiveHighWaterMark: Int
    override var receiveTimeout: Int
    override fun receive(): Promise<JsArray<ArrayBuffer>>
    override var multicastHops: Int
    override var sendBufferSize: Int
    override var sendHighWaterMark: Int
    override var sendTimeout: Int
    override fun send(message: JsArray<ArrayBuffer>): Promise<JsAny>
    open var routingId: String?
    open var probeRouter: Boolean
    open var correlate: Boolean
    open var relaxed: Boolean
}

internal open external class Reply() : Socket, Readable,
    Writable {
    override var receiveBufferSize: Int
    override var receiveHighWaterMark: Int
    override var receiveTimeout: Int
    override fun receive(): Promise<JsArray<ArrayBuffer>>
    override var multicastHops: Int
    override var sendBufferSize: Int
    override var sendHighWaterMark: Int
    override var sendTimeout: Int
    override fun send(message: JsArray<ArrayBuffer>): Promise<JsAny>
    open var routingId: String?
}

internal open external class Dealer() : Socket, Readable,
    Writable {
    override var receiveBufferSize: Int
    override var receiveHighWaterMark: Int
    override var receiveTimeout: Int
    override fun receive(): Promise<JsArray<ArrayBuffer>>
    override var multicastHops: Int
    override var sendBufferSize: Int
    override var sendHighWaterMark: Int
    override var sendTimeout: Int
    override fun send(message: JsArray<ArrayBuffer>): Promise<JsAny>
    open var routingId: String?
    open var probeRouter: Boolean
    open var conflate: Boolean
}

internal open external class Router() : Socket, Readable,
    Writable {
    override var receiveBufferSize: Int
    override var receiveHighWaterMark: Int
    override var receiveTimeout: Int
    override fun receive(): Promise<JsArray<ArrayBuffer>>
    override var multicastHops: Int
    override var sendBufferSize: Int
    override var sendHighWaterMark: Int
    override var sendTimeout: Int
    override fun send(message: JsArray<ArrayBuffer>): Promise<JsAny>
    open var routingId: String?
    open var mandatory: Boolean
    open var probeRouter: Boolean
    open var handover: Boolean
    open fun connect(address: String, options: RouterConnectOptions = definedExternally)
}

internal external interface RouterConnectOptions {
    var routingId: String?
        get() = definedExternally
        set(value) = definedExternally
}

internal open external class Pull() : Socket, Readable {
    override var receiveBufferSize: Int
    override var receiveHighWaterMark: Int
    override var receiveTimeout: Int
    override fun receive(): Promise<JsArray<ArrayBuffer>>
    open var conflate: Boolean
}

internal open external class Push() : Socket, Writable {
    override var multicastHops: Int
    override var sendBufferSize: Int
    override var sendHighWaterMark: Int
    override var sendTimeout: Int
    override fun send(message: JsArray<ArrayBuffer>): Promise<JsAny>
    open var conflate: Boolean
}

internal open external class XPublisher() : Socket,
    Readable, Writable {
    override var receiveBufferSize: Int
    override var receiveHighWaterMark: Int
    override var receiveTimeout: Int
    override fun receive(): Promise<JsArray<ArrayBuffer>>
    override var multicastHops: Int
    override var sendBufferSize: Int
    override var sendHighWaterMark: Int
    override var sendTimeout: Int
    override fun send(message: JsArray<ArrayBuffer>): Promise<JsAny>
    open var noDrop: Boolean
    open var manual: Boolean
    open var welcomeMessage: String?
    open var invertMatching: Boolean
}

internal open external class XSubscriber() : Socket,
    Readable, Writable {
    override var receiveBufferSize: Int
    override var receiveHighWaterMark: Int
    override var receiveTimeout: Int
    override fun receive(): Promise<JsArray<ArrayBuffer>>
    override var multicastHops: Int
    override var sendBufferSize: Int
    override var sendHighWaterMark: Int
    override var sendTimeout: Int
    override fun send(message: JsArray<ArrayBuffer>): Promise<JsAny>
}
