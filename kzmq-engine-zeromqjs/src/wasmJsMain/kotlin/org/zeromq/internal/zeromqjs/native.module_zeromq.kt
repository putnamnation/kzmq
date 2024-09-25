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

package org.zeromq.internal.zeromqjs

import Buffer
import kotlin.js.Promise

public external interface `T$1` {
    public var publicKey: String
    public var secretKey: String
}

public external fun curveKeyPair(): `T$1`

internal open external class Context() {
    open var blocky: Boolean
    open var ioThreads: JsNumber
    open var maxMessageSize: JsNumber
    open var maxSockets: JsNumber
    open var ipv6: Boolean
    open var threadPriority: JsNumber
    open var threadSchedulingPolicy: JsNumber
    open var maxSocketsLimit: JsNumber
    open fun getBoolOption(option: JsNumber): Boolean
    open fun setBoolOption(option: JsNumber, value: Boolean)
    open fun getInt32Option(option: JsNumber): JsNumber
    open fun setInt32Option(option: JsNumber, value: JsNumber)
}

internal typealias ErrnoError = Error

internal typealias AuthError = Error

internal typealias ProtoError = Error

internal external interface EventAddress {
    var address: String
}

internal external interface EventInterval {
    var interval: JsNumber
}

internal external interface EventError {
    var error: JsAny
}

internal external interface EventError__0 : EventError

internal external interface `T$2` {
    var type: JsAny
}

//typealias Extract<T, U> = Any
//typealias Expand<T> = Any
//
//typealias EventFor<T, D> = Expand<`T$2`<T> /* `T$2`<T> & D */>
//
//typealias EventOfType<E> = Expand<Extract<dynamic /* EventFor<String /* "accept" */, EventAddress> | EventFor<String /* "accept:error" */, EventAddress /* EventAddress & EventError__0 */> | EventFor<String /* "bind" */, EventAddress> | EventFor<String /* "bind:error" */, EventAddress /* EventAddress & EventError__0 */> | EventFor<String /* "connect" */, EventAddress> | EventFor<String /* "connect:delay" */, EventAddress> | EventFor<String /* "connect:retry" */, EventAddress /* EventAddress & EventInterval */> | EventFor<String /* "close" */, EventAddress> | EventFor<String /* "close:error" */, EventAddress /* EventAddress & EventError__0 */> | EventFor<String /* "disconnect" */, EventAddress> | EventFor<String /* "end" */> | EventFor<String /* "handshake" */, EventAddress> | EventFor<String /* "handshake:error:protocol" */, EventAddress /* EventAddress & EventError<ProtoError> */> | EventFor<String /* "handshake:error:auth" */, EventAddress /* EventAddress & EventError<AuthError> */> | EventFor<String /* "handshake:error:other" */, EventAddress /* EventAddress & EventError__0 */> | EventFor<String /* "unknown" */> */, dynamic /* EventFor<String /* "accept" */, EventAddress> | EventFor<String /* "accept:error" */, EventAddress /* EventAddress & EventError__0 */> | EventFor<String /* "bind" */, EventAddress> | EventFor<String /* "bind:error" */, EventAddress /* EventAddress & EventError__0 */> | EventFor<String /* "connect" */, EventAddress> | EventFor<String /* "connect:delay" */, EventAddress> | EventFor<String /* "connect:retry" */, EventAddress /* EventAddress & EventInterval */> | EventFor<String /* "close" */, EventAddress> | EventFor<String /* "close:error" */, EventAddress /* EventAddress & EventError__0 */> | EventFor<String /* "disconnect" */, EventAddress> | EventFor<String /* "end" */> | EventFor<String /* "handshake" */, EventAddress> | EventFor<String /* "handshake:error:protocol" */, EventAddress /* EventAddress & EventError<ProtoError> */> | EventFor<String /* "handshake:error:auth" */, EventAddress /* EventAddress & EventError<AuthError> */> | EventFor<String /* "handshake:error:other" */, EventAddress /* EventAddress & EventError__0 */> | EventFor<String /* "unknown" */> */>>
//
//external open class Observer(socket: Socket) : EventSubscriber {
//    override fun <E : Any> on(type: E, listener: (data: EventOfType<E>) -> Unit): EventSubscriber
//    override fun <E : Any> off(type: E, listener: (data: EventOfType<E>) -> Unit): EventSubscriber
//    open var closed: Boolean
//    open fun close()
//    open fun receive(): Promise<dynamic /* EventFor<String /* "accept" */, EventAddress> | EventFor<String /* "accept:error" */, EventAddress /* EventAddress & EventError__0 */> | EventFor<String /* "bind" */, EventAddress> | EventFor<String /* "bind:error" */, EventAddress /* EventAddress & EventError__0 */> | EventFor<String /* "connect" */, EventAddress> | EventFor<String /* "connect:delay" */, EventAddress> | EventFor<String /* "connect:retry" */, EventAddress /* EventAddress & EventInterval */> | EventFor<String /* "close" */, EventAddress> | EventFor<String /* "close:error" */, EventAddress /* EventAddress & EventError__0 */> | EventFor<String /* "disconnect" */, EventAddress> | EventFor<String /* "end" */> | EventFor<String /* "handshake" */, EventAddress> | EventFor<String /* "handshake:error:protocol" */, EventAddress /* EventAddress & EventError<ProtoError> */> | EventFor<String /* "handshake:error:auth" */, EventAddress /* EventAddress & EventError<AuthError> */> | EventFor<String /* "handshake:error:other" */, EventAddress /* EventAddress & EventError__0 */> | EventFor<String /* "unknown" */> */>
//}

internal open external class Proxy<F : Socket, B : Socket>(frontEnd: F, backEnd: B) {
    open var frontEnd: F
    open var backEnd: B
    open fun run(): Promise<JsAny>
    open fun pause()
    open fun resume()
    open fun terminate()
}

internal open external class Socket(type: SocketType, options: JsAny = definedExternally) {
    open var affinity: JsNumber
    open var rate: JsNumber
    open var recoveryInterval: JsNumber
    open var linger: JsNumber
    open var reconnectInterval: JsNumber
    open var backlog: JsNumber
    open var reconnectMaxInterval: JsNumber
    open var maxMessageSize: JsNumber
    open var tcpKeepalive: JsNumber
    open var tcpKeepaliveCount: JsNumber
    open var tcpKeepaliveIdle: JsNumber
    open var tcpKeepaliveInterval: JsNumber
    open var tcpAcceptFilter: String?
    open var immediate: Boolean
    open var ipv6: Boolean
    open var plainServer: Boolean
    open var plainUsername: String?
    open var plainPassword: String?
    open var curveServer: Boolean
    open var curvePublicKey: String?
    open var curveSecretKey: String?
    open var curveServerKey: String?
    open var gssapiServer: Boolean
    open var gssapiPrincipal: String?
    open var gssapiServicePrincipal: String?
    open var gssapiPlainText: Boolean
    open var gssapiPrincipalNameType: String /* "hostBased" | "userName" | "krb5Principal" */
    open var gssapiServicePrincipalNameType: String /* "hostBased" | "userName" | "krb5Principal" */
    open var zapDomain: String?
    open var typeOfService: JsNumber
    open var handshakeInterval: JsNumber
    open var socksProxy: String?
    open var heartbeatInterval: JsNumber
    open var heartbeatTimeToLive: JsNumber
    open var heartbeatTimeout: JsNumber
    open var connectTimeout: JsNumber
    open var tcpMaxRetransmitTimeout: JsNumber
    open var multicastMaxTransportDataUnit: JsNumber
    open var vmciBufferSize: JsNumber
    open var vmciBufferMinSize: JsNumber
    open var vmciBufferMaxSize: JsNumber
    open var vmciConnectTimeout: JsNumber
    open var `interface`: String?
    open var zapEnforceDomain: Boolean
    open var loopbackFastPath: Boolean
    open var type: SocketType
    open var lastEndpoint: String?
    open var securityMechanism: String /* "plain" | "curve" | "gssapi" */
    open var threadSafe: Boolean

    //    open var events: Observer
    open var context: Context
    open var closed: Boolean
    open var readable: Boolean
    open var writable: Boolean
    open fun close()
    open fun bind(address: String): Promise<JsAny>
    open fun unbind(address: String): Promise<JsAny>
    open fun connect(address: String)
    open fun disconnect(address: String)
    open fun getBoolOption(option: JsNumber): Boolean
    open fun setBoolOption(option: JsNumber, value: Boolean)
    open fun getInt32Option(option: JsNumber): JsNumber
    open fun setInt32Option(option: JsNumber, value: JsNumber)
    open fun getUint32Option(option: JsNumber): JsNumber
    open fun setUint32Option(option: JsNumber, value: JsNumber)
    open fun getInt64Option(option: JsNumber): JsNumber
    open fun setInt64Option(option: JsNumber, value: JsNumber)
    open fun getUint64Option(option: JsNumber): JsNumber
    open fun setUint64Option(option: JsNumber, value: JsNumber)
    open fun getStringOption(option: JsNumber): String?
    open fun setStringOption(option: JsNumber, value: String?)
    open fun setStringOption(option: JsNumber, value: Buffer?)
}

@Suppress("NON_EXPORTABLE_TYPE")
@ExperimentalJsExport
//@JsExport
public external object SocketType {
    public val Pair: Int = definedExternally
    public val Publisher: Int  = definedExternally
    public val Subscriber: Int  = definedExternally
    public val Request: Int  = definedExternally
    public val Reply: Int  = definedExternally
    public val Dealer: Int  = definedExternally
    public val Router: Int  = definedExternally
    public val Pull: Int  = definedExternally
    public val Push: Int  = definedExternally
    public val XPublisher: Int  = definedExternally
    public val XSubscriber: Int = definedExternally
    public val Stream: Int = definedExternally
    public val Server: Int = definedExternally
    public val Client: Int = definedExternally
    public val Radio: Int = definedExternally
    public val Dish: Int = definedExternally
    public val Gather: Int = definedExternally
    public val Scatter: Int = definedExternally
    public val Datagram: Int  = definedExternally
}
