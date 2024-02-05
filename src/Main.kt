import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class Watek1 : Runnable {
    override fun run() {
        for (i in 1..5) {
            println("Wątek 1: Licznik $i")
            Thread.sleep(1000)
        }
    }
}

class Watek2 : Runnable {
    override fun run() {
        for (j in 1..5) {
            println("Wątek 2: Licznik $j")
            Thread.sleep(1500)
        }
    }
}

fun main() {
    println("Rozpoczęcie programu")

    // Utwórz pulę wątków z pięcioma wątkami
    val executor: ExecutorService = Executors.newFixedThreadPool(5)

    // Zleć zadania do wykonania w puli wątków
    executor.submit(Watek1())
    executor.submit(Watek2())

    // Zakończ pulę wątków po zakończeniu zadań
    executor.shutdown()

    println("Zakończenie programu")
}
