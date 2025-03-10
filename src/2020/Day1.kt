package `2020`

import java.io.File

fun readData() : List<String> {
    var data = mutableListOf<String>()
    try{
        data = File("src/2020/Day1data.txt").readLines().toMutableList()
    }
    catch (e: Exception){
        e.printStackTrace()
    }
    return data
}

fun multiply(l :List<String>) :Int{
    var list =l.map { it.toInt() }.toMutableList()
    for(i in list)
        for(x in list)
            if(i + x == 2020){
                return i*x
            }
    return 0
}
fun multiplyWithThree(l :List<String>) :Int{
    var list =l.map { it.toInt() }.toMutableList()
    for(i in list)
        for(x in list)
            for(y in list)
                if(i + x + y == 2020){
                    return i*x*y
                }
    return 0
}

fun main(){

    val readDatat = readData()
    println(multiply(readDatat))
    println(multiplyWithThree(readDatat))
}