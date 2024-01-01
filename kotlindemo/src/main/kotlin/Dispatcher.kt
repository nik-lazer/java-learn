import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    repeat(1000) {
        launch(Dispatchers.Default.limitedParallelism(16)) {
            log("Default: running in thread ${Thread.currentThread().name}")
            longRunningTask()
        }
    }
}