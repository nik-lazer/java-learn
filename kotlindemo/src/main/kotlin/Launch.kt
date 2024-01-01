import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

fun main() = runBlocking {
    log("Program runs")

    val job: Job = launch(EmptyCoroutineContext, CoroutineStart.DEFAULT) {
        longRunningTask()
    }

    val job1: Job = launch { longRunningTask() }

    job.join()

    log("Program run ends")
}