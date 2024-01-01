import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.Instant

fun main() = runBlocking{
    log("${Instant.now()}: Program runs")

    val productId = findProduct()

    launch (Dispatchers.Unconfined) {
        val price = fetchPrice(productId)
        log("Price is + $price")
    }
    updateProduct()

    log("${Instant.now()}: Program run ends")
}

suspend fun fetchPrice(productId: String) : Double{
    log("${Instant.now()}: fetchPrice for product $productId starts on")
    delay(2000)
    log("${Instant.now()}: fetchPrice for product $productId ends on")
    return 234.5
}

fun findProduct() : String{
    log("${Instant.now()}: findProduct on")
    return "P12333"
}

fun updateProduct() : String{
    log("${Instant.now()}: updateProduct on")
    return "Product updated"
}