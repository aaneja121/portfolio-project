/**
 * Enhanced interface for LineupComponent.
 * This component will further enhance the team's lineup with methods not provided in the basic interface.
 */
public interface LineupComponentEnhanced extends LineupComponentKernel {

    /**
     * Generates and shows the best lineup based on points per game.
     *
     * @ensures the highest-scoring player for each position is in the starting lineup
     */
    void makeBest();

    /**
     * Prints out the current lineup without the update.
     *
     * @ensures every player's essentials are displayed (name, position, PPG)
     */
    void displayLineup();
}