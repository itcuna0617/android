import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    val N = scanner.nextInt()

    for(i in 1..9){
        println("$N * $i = ${N*i}")
    }
}