package Tomteland

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions.*;

class TomtelandTest {
    var tl: Tomteland = Tomteland()


    var tomteLista: MutableMap<String, List<String>> = mutableMapOf(
        "Tomte" to listOf("Glader", "Butter"),
        "Glader" to listOf("Tröger", "Trötter", "Blyger"),
        "Butter" to listOf("Rådjuret", "Nyckelpigan", "Haren", "Räven"),
        "Trötter" to listOf("Skumtomten"),
        "Skumtomten" to listOf("Dammråttan")
    )


    @Test
    fun getTomteUnderlingsTest() {
        val underlings = tl.getUnderlings("Trötter", tomteLista)
        assertTrue(underlings.contains("Skumtomten"))
        assertTrue(underlings.contains("Dammråttan"))
        assertEquals(underlings.size, 2)
    }
}