package Tomteland

class Tomteland {

    fun getTomteLista(): Map<String, List<String>> {
        return mutableMapOf(
            "Tomte" to listOf("Glader", "Butter"),
            "Glader" to listOf("Tröger", "Trötter", "Blyger"),
            "Butter" to listOf("Rådjuret", "Nyckelpigan", "Haren", "Räven"),
            "Trötter" to listOf("Skumtomten"),
            "Skumtomten" to listOf("Dammråttan"),
            "Räven" to listOf("Gråsuggan", "Myran"),
            "Myran" to listOf("Bladlusen")
        )
    }

    fun getUnderlings(currentName: String, map: Map<String, List<String>>): List<String> {
        var count = 0
        var res = mutableListOf<String>()
        fun innerGetUnderlings(currentName: String, res: MutableList<String>): MutableList<String> {
            if (!map.containsKey(currentName)) return res
            var underlings = map[currentName]!!
            for (u in underlings) {
                if (!res.contains(u))
                    res.add(u)
                innerGetUnderlings(u, res)
            }
            return res
        }
        return innerGetUnderlings(currentName, res)
    }
}
fun main() {

    val tomte = Tomteland()

    var list: MutableList<String> = mutableListOf()
    var tomteLista = tomte.getTomteLista()
    println(tomte.getUnderlings("Butter", tomte.getTomteLista()))

    //tomteLista.filter{it.key == "Butter"}.values.forEach{list.add(it.toString())}
    //println(list)

}