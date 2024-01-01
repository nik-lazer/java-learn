import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("Program runs")

    launch {
        longRunningTask()
    }

    log("Program run ends")
}