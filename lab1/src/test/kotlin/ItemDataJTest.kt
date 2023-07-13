/*
Nelson García Bravatti 22434
Programación en plataformas móviles
Laboratorio #1
Test dado por Francisco
 */

import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ItemDataJTest {

    @Test
    fun `Given a list, When it has multiple elements, Then result type and info should be correct`() {
        val result = listOf(
            ItemData(10),
            ItemData("Enero"),
            ItemData(null),
            ItemData(true)
        )
        assertNotNull(result)
        assertTrue(
            result[0].getType() == "entero"
                    && result[0].getInfo() == "M10"
        )
        assertTrue(
            result[1].getType() == "cadena"
                    && result[1].getInfo() == "L5"
        )
        assertTrue(
            result[2].getType() == null
                    && result[2].getInfo() == null
        )
        assertTrue(
            result[3].getType() == "booleano"
                    && result[3].getInfo() == "Verdadero"
        )
    }
}