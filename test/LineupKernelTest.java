import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class LineupKernelTest {

    @Test
    LineupComponent component = new LineupComponent1L();component.addPlayer("Darius Garland","PG",20.6Iterator<PlayerBasics> iterate = thiscompoent.pl
    assertTrue(iterate.hasNext());

    assertEquals("Darius Garland", iterate.next().name());
    }

    @Test
    public void testAddMultiplePlayers() {
        LineupComponent component = new LineupComponent1L();
        component.addPlayer("Darius Garland", "PG", 20.6);
        component.addPlayer("Craig Porter Jr.", "PG", 3.7);
        Iterator<PlayerBasics> iterate = component.playersAt("PG");
        assertEquals("Darius Garland", iterate.next().name());
        assertEquals("Craig Porter Jr.", iterate.next().name());
    }

    @Test
    public void testAddMultiplePlayersDiffPositions() {
        LineupComponent component = new LineupComponent1L();
        component.addPlayer("Darius Garland", "PG", 20.6);
        component.addPlayer("Donovan Mitchell", "SG", 24.0);
        Iterator<PlayerBasics> p1 = component.playersAt("PG");
        Iterator<PlayerBasics> p2 = component.playersAt("SG");
        assertEquals("Darius Garland", p1.next().name());
        assertEquals("Donovan Mitchell", p2.next().name());
    }

    @Test
    public void testRemovePlayer() {
        LineupComponent component = new LineupComponent1L();
        component.addPlayer("Darius Garland", "PG", 20.3);
        component.removePlayer("Darius Garland", "PG");
        assertFalse(component.playersAt("PG").hasNext());
    }

    @Test
    public void testSubPlayer() {
        LineupComponent component = new LineupComponent1L();
        component.addPlayer("Darius Garland", "PG", 20.6);
        component.subPlayer("Darius Garland", "PG", "Craig Porter Jr.", 2.8);
        assertEquals("Craig Porter Jr.",
                component.playersAt("PG").next().name());
    }

    @Test
    public void testSizeAfterAddRemove() {
        LineupComponent component = new LineupComponent1L();
        component.addPlayer("Darius Garland", "PG", 20.6);
        component.addPlayer("Donovan Mitchell", "SG", 24.0);
        assertEquals(2, component.size());
        component.removePlayer("Darius Garland", "PG");
        assertEquals(1, component.size());
    }

    @Test
    public void testAddPlayerNonPosition() {
        LineupComponent component = new LineupComponent1L();
        component.addPlayer("Kenny Atkinson", "Coach", 0);
    }

    @Test
    public void testRemoveNonPlayer() {
        LineupComponent component = new LineupComponent1L();
        component.removePlayer("Garius Darland", "PG");
    }

    @Test
    public void testSubNonPlayer() {
        LineupComponent component = new LineupComponent1L();
        component.subPlayer("Garius Darland", "PG", "Craig Porter Jr.", 3.7);
    }

    @Test
    public void testClearAfterAdd() {
        LineupComponent component = new LineupComponent1L();
        component.addPlayer("Jarrett Allen", "C", 13.6);
        component.clear();
        assertEquals(0, component.size());
    }

    @Test
    public void testNewInstanceCreatesEmpty() {
        LineupComponent component = new LineupComponent1L();
        LineupComponent newComponent = component.newInstance();
        assertEquals(0, newComponent.size());
    }

    @Test
    public void testTransferFrom() {
        LineupComponent main = new LineupComponent1L();
        main.addPlayer("Evan Mobley", "PF", 18.5);
        LineupComponent newComponent = new LineupComponent1L();
        newComponent.transferFrom(main);
        assertEquals(1, newComponent.size());
        assertEquals(0, main.size());
    }

}
