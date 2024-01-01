import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.*

fun main() = runBlocking {
    log("Program runs")

    val taskDeferred = async {
        generateUniqueID()
    }

    val taskResult = taskDeferred.await()

    log("program run ends with result $taskResult")
}

suspend fun generateUniqueID(): String{
    log("executing generateUniqueID on")
    delay(1000)
    log("generateUniqueID ends on thread")

    return UUID.randomUUID().toString()
}