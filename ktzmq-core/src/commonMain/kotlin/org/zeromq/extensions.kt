package org.zeromq

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.flow.*

fun ReceiveSocket.consumeAsFlow(): Flow<Message> = flow {
    while (currentCoroutineContext().isActive) emit(receive())
}

suspend fun Flow<Message>.collectToSocket(socket: SendSocket) = collect {
    socket.send(it)
}

@OptIn(FlowPreview::class)
fun ReceiveSocket.produceIn(scope: CoroutineScope): ReceiveChannel<Message> =
    consumeAsFlow().produceIn(scope)
