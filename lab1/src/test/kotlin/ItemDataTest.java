import junit.framework.TestCase;

public class ItemDataTest extends TestCase {

    public void testItemData() {


        ItemDataJ itemDataJ = new ItemDataJ("Enero");
        assertEquals("cadena", itemDataJ.getType());
        assertEquals("L5", itemDataJ.getInfo());

        itemDataJ = new ItemDataJ(10);
        assertEquals("entero", itemDataJ.getType());
        assertEquals("M10", itemDataJ.getInfo());

        itemDataJ = new ItemDataJ(true);
        assertEquals("booleano", itemDataJ.getType());
        assertEquals("Verdadero", itemDataJ.getInfo());


        itemDataJ = new ItemDataJ(null);
        assertNull(itemDataJ.getType());
        assertNull(itemDataJ.getInfo());

    }

}