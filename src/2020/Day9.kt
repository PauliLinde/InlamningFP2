package `2020`

import java.io.File
fun separate(l :List<String>) : List<Pair<Int, List<String>>> {
    val separated = l.map{it.split("\n")}.toList().flatten()
    val mapped = separated.mapIndexed{index, value -> index to value.split(" ")}
    return mapped
}
fun jumpGame(l :List<Pair<Int, List<String>>>) :Int{
    val acc = 0
    for(i) {
        if(l[i].first.equals("acc"){
            acc += l[0].second.?toInt()
            }
    }

    return
}

fun main(){
    val data = `2020`.readData()


}