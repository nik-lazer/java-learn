import kotlinx.coroutines.delay

suspend fun longRunningTask() {
    log("executing longRunningTask on")
    delay(1000)
    log("longRunningTask ends on thread")
}

fun log(message: String) {
    println("[${Thread.currentThread().name}]: $message")
}