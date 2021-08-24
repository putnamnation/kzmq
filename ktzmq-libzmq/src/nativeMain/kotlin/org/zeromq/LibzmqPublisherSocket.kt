package org.zeromq

import kotlinx.cinterop.COpaquePointer
import org.zeromq.internal.libzmq.ZMQ_CONFLATE
import org.zeromq.internal.libzmq.ZMQ_INVERT_MATCHING
import org.zeromq.internal.libzmq.ZMQ_XPUB_NODROP

internal class LibzmqPublisherSocket internal constructor(underlying: COpaquePointer?) :
    LibzmqSocket(underlying, Type.PUB), PublisherSocket {

    override var conflate: Boolean
            by socketOption(underlying, ZMQ_CONFLATE, booleanConverter)

    override var invertMatching: Boolean
            by socketOption(underlying, ZMQ_INVERT_MATCHING, booleanConverter)

    override var noDrop: Boolean
            by socketOption(underlying, ZMQ_XPUB_NODROP, booleanConverter)
}
