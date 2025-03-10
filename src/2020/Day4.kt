package `2020`

import java.io.File

class Passport(val byr :Int?, val iyr :Int?, val eyr :Int?, val hgt :String?, val hcl :String?,
               val ecl :String?, val pid :String?, val cid :String? = "25") {}

fun readToPass() : List<String> {
    return try{
        File("src/2020/Day4data.txt").readLines()
    }
    catch (e: Exception){
        e.printStackTrace()
        emptyList()
    }
}

fun splitPassports(l :List<String>) : List<String>{
    return l.joinToString("\n").split("\n\n")
        .map{it.replace("\n", " ")}
}

fun parseToPass(s :String) : Passport{
    val all = s.split(" ").associate {
        val (key, value) = it.split(":")
        key to value
    }
    return Passport (byr= all["byr"]?.toInt(), iyr=all["iyr"]?.toInt(), eyr=all["eyr"]?.toInt(), hgt=all["hgt"], hcl=all["hcl"],
        ecl=all["ecl"], pid=all["pid"], cid=all["cid"])
}

//Här kommer funktioner till b-delen
fun validByr(i :Int) :Boolean{
    return 1920<= i && i <= 2002
}
fun validIyr(i :Int) :Boolean{
    return 2010 <= i && i <= 2020
}
fun validEyr(i :Int) :Boolean{
    return 2020 <= i && i <= 2030
}
fun validHgt(s :String) :Boolean{
    var digit = ""
    var string = ""
    for (i in s) {
        if (i.isDigit()) {
            digit += i
        }
        else
            string += i
    }
    if (string.equals("cm")){
        return 150 <= digit.toInt() && digit.toInt() <= 193
    }
    else if (string.equals("in")){
        return 59 <= digit.toInt() && digit.toInt() <= 76
    }
    else
        return false
}
fun validHcl(s :String) :Boolean{
    return Regex("^#[0-9a-f]{6}$").matches(s)
}
fun validEcl(s :String) :Boolean{
    return (s.equals("amb") || s.equals("blu") || s.equals("brn") || s.equals("gry") || s.equals("grn") ||
            s.equals("hzl") || s.equals("oth"))
}
fun validPid(s :String) :Boolean{
    return Regex("^[0-9]{9}$").matches(s)
}

fun isValid(p : Passport) : Boolean {
    return ((p.byr != null && validByr(p.byr)) &&
            (p.iyr != null && validIyr(p.iyr)) &&
            (p.eyr != null && validEyr(p.eyr)) &&
            (p.hgt != null && validHgt(p.hgt)) &&
            (p.hcl != null && validHcl(p.hcl)) &&
            (p.ecl != null && validEcl(p.ecl)) &&
            (p.pid != null && validPid(p.pid)))
}


fun main(){
    val allPassports = readToPass()
    val splitedWord = splitPassports(allPassports)
    val passportList = splitedWord.map{parseToPass(it)}

    val validPassports = passportList.filter{isValid(it)}
    println(validPassports.count())

}