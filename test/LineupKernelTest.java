import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class LineupKernelTest {

    @Test
    public void testAddPlayer() {
        LineupComponent component = new LineupComponent1L();
        component.addPlayer("Curry", "PG", 30.0);
        Iterator<PlayerBasics> iterate = component.playersAt("PG");
        assertTrue(iterate.hasNext());
        assertEquals("Curry", iterate.next().name());
    }

    @Test
    public void testAddMultiplePlayers() {
        LineupComponent component = new LineupComponent1L();
        component.addPlayer("Curry", "PG", 30.0);
        component.addPlayer("Paul", "PG", 17.0);
        Iterator<PlayerBasics> iterate = component.playersAt("PG");
        assertEquals("Curry", iterate.next().name());
        assertEquals("Paul", iterate.next().name());
    }

    @Test
    public void testAddMultiplePlayersDiffPositions() {
        LineupComponent component = new LineupComponent1L();
        component.addPlayer("Curry", "PG", 30.0);
        component.addPlayer("Booker", "SG", 28.0);
        Iterator<PlayerBasics> g1 = component.playersAt("PG");
        Iterator<PlayerBasics> g2 = component.playersAt("SG");
        assertEquals("Curry", g1.next().name());
        assertEquals("Booker", g2.next().name());
    }

    @Test
    public void testRemovePlayer() {
        LineupComponent component = new LineupComponent1L();
        component.addPlayer("Curry", "PG", 30.0);
        component.removePlayer("Curry", "PG");
        assertFalse(component.playersAt("PG").hasNext());
    }

    @Test
    public void testSubPlayer() {
        LineupComponent component = new LineupComponent1L();
        component.addPlayer("Curry", "PG", 30.0);
        component.subPlayer("Curry", "PG", "Paul", 17.0);
        assertEquals("Paul", component.playersAt("PG").next().getName());
    }

    @Test
    public void testSizeAfterAddRemove() {
        LineupComponent component = new LineupComponent1L();
        component.addPlayer("A", "PG", 1);
        component.addPlayer("B", "SG", 1);
        assertEquals(2, component.size());
        component.removePlayer("A", "PG");
        assertEquals(1, component.size());
    }

    @Test
    public void testAddPlayerNonPosition() {
        LineupComponent component = new LineupComponent1L();
        component.addPlayer("Unknown", "Coach", 0);
    }

    @Test
    public void testRemoveNonPlayer() {
        LineupComponent component = new LineupComponent1L();
        component.removePlayer("Ghost", "PG");
    }

    @Test
    public void testSubNonPlayer() {
        LineupComponent component = new LineupComponent1L();
        component.subPlayer("Ghost", "PG", "Paul", 17.0);
    }

    @Test
    public void testClearAfterAdd() {
        LineupComponent component = new LineupComponent1L();
        component.addPlayer("A", "PG", 1);
        component.clear();
        assertEquals(0, component.size());
    }

}
