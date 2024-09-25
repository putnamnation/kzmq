/*
 * Copyright (c) 2021-2024 Didier Villevalois and Kzmq contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */

package org.zeromq

import Buffer
import kotlinx.coroutines.*
import kotlinx.coroutines.selects.*
import kotlinx.io.bytestring.*
import org.khronos.webgl.*
import org.zeromq.internal.zeromqjs.*

public fun Int8Array.toByteArray(): ByteArray =
    ByteArray(this.length) { this[it] }
public fun Uint8Array.toByteArray(): ByteArray =
    ByteArray(this.length) { this[it] }

private fun toJsArrayImpl(vararg x: Byte): Int8Array = js("new Int8Array(x)")

public fun ByteArray.toJsArray(): Int8Array = toJsArrayImpl(*this)

public fun Array<ArrayBuffer>.toJsArray(): JsArray<ArrayBuffer> = this.toJsReference().unsafeCast()

internal class ZeroMQJsReceiveSocket(private val underlying: Readable) : ReceiveSocket {

    override suspend fun receive(): Message {
        val buf = underlying.receive().await<ArrayBuffer>().let {
            val array = Uint8Array(it)
            Message(ByteString(array.toByteArray()))
        }

        return buf
    }


    override suspend fun receiveCatching(): SocketResult<Message> = try {
        SocketResult.success(receive())
    } catch (t: Throwable) {
        SocketResult.failure(t)
    }

    override fun tryReceive(): SocketResult<Message> =
        throw NotImplementedError("Not supported on ZeroMQ.JS engine")

    override val onReceive: SelectClause1<Message>
        get() = throw NotImplementedError("Not supported on ZeroMQ.JS engine")

    override var receiveBufferSize: Int by underlying::receiveBufferSize
    override var receiveHighWaterMark: Int by underlying::receiveHighWaterMark
    override var receiveTimeout: Int by underlying::receiveTimeout
}
