import static org.junit.Assert.*;

import org.junit.*;

public class LineupAbstractTest {

    @Test
    public void testMakeBestOnePerPosition() {
        LineupComponent component = new LineupComponent1L();
        component.addPlayer("Ty Jerome", "PG", 12.5);
        component.makeBest();
        String output = out.toString();
        assertTrue(output.contains("PG: Jerome"));
    }

    @Test
    public void testMakeBestMultipleSelectsHighest() {
        LineupComponent component = new LineupComponent1L();
        component.addPlayer("Ty Jerome", "PG", 12.5);
        component.addPlayer("Darius Garland", "PG", 20.6);
        component.makeBest();
        String output = out.toString();
        assertTrue(output.contains("PG: Garland"));
    }

    @Test
    public void testDisplayLineup() {
        LineupComponent component = new LineupComponent1L();
        component.addPlayer("Donovan Mitchell", "SG", 24.0);
        component.displayLineup();
        String output = out.toString();
        assertTrue(output.contains("SG: Mitchell"));
    }

    @Test
    public void testToStringIncludesPlayers() {
        LineupComponent component = new LineupComponent1L();
        component.addPlayer("Jarrett Allen", "C", 13.5);
        String str = component.toString();
        assertTrue(str.contains("Allen"));
    }

    @Test
    public void testToStringEmptyLineup() {
        LineupComponent component = new LineupComponent1L();
        assertEquals("", component.toString());
    }

    @Test
    public void testEqualsTrue() {
        LineupComponent p1 = new LineupComponent1L();
        LineupComponent p2 = new LineupComponent1L();
        p1.addPlayer("Isaac Okoro", "SF", 6.1);
        p2.addPlayer("Isaac Okoro", "SF", 6.1);
        assertTrue(p1.equals(p2));
    }

    @Test
    public void testEqualsFalse() {
        LineupComponent p1 = new LineupComponent1L();
        LineupComponent p2 = new LineupComponent1L();
        p1.addPlayer("Isaac Okoro", "SF", 6.1);
        p2.addPlayer("De'Andre Hunter", "SF", 17.0);
        assertFalse(p1.equals(p2));
    }
