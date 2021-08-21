package org.zeromq

import org.zeromq.internal.zeromqjs.Publisher as ZPublisher

internal class ZeroMQJsPublisherSocket internal constructor(
    override val underlying: ZPublisher = ZPublisher()
) :
    ZeroMQJsSocket(),
    SendSocket by ZeroMQJsSendSocket(underlying),
    PublisherSocket {

    override var conflate: Boolean by underlying::conflate
    override var invertMatching: Boolean by underlying::invertMatching
    override var noDrop: Boolean by underlying::noDrop
}
