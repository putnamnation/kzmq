package org.zeromq

interface SocketFactory {
    /**
     * Creates a [PairSocket].
     */
    fun createPair(): PairSocket

    /**
     * Creates a [PublisherSocket].
     */
    fun createPublisher(): PublisherSocket

    /**
     * Creates a [SubscriberSocket].
     */
    fun createSubscriber(): SubscriberSocket

    /**
     * Creates a [XPublisherSocket].
     */
    fun createXPublisher(): XPublisherSocket

    /**
     * Creates a [XSubscriberSocket].
     */
    fun createXSubscriber(): XSubscriberSocket

    /**
     * Creates a [PushSocket].
     */
    fun createPush(): PushSocket

    /**
     * Creates a [PullSocket].
     */
    fun createPull(): PullSocket

    /**
     * Creates a [RequestSocket].
     */
    fun createRequest(): RequestSocket

    /**
     * Creates a [ReplySocket].
     */
    fun createReply(): ReplySocket

    /**
     * Creates a [DealerSocket].
     */
    fun createDealer(): DealerSocket

    /**
     * Creates a [RouterSocket].
     */
    fun createRouter(): RouterSocket
}
