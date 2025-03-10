package `2020`

import java.io.File

fun readData1() : List<String> {
    return try{
        File("src/2020/Day9Test.txt").readLines()
    }
    catch (e: Exception){
        e.printStackTrace()
        return emptyList()
    }
}

fun List<Long>.preambleIsValid(): Boolean {
    val controlNumber = this.last()
    val numbers = this.dropLast(1).toSet()
    return numbers.any { controlNumber - it in numbers }
}

fun validateNumber(l :List<String>, preamble :Int = 25) :Long{
    var list =l.map { it.toLong() }.toMutableList()
    return list.windowed(preamble +1,1, false).first { !it.preambleIsValid() }.last()
}


fun main(){
    val data = readData1()

    println(validateNumber(data))
}