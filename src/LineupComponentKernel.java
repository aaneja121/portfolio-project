/**
 * Kernel interface for LineupComponent. This component creates an NBA
 * starting lineup with players assigned to certain positions.
 */
public interface LineupComponentKernel extends Standard<LineupComponent> {

    // Note: Every position can have multiple players, as the NBA has evolved into a
    // positionless league.

    /**
     * Adds a player to the lineup.
     *
     * @param name
     *            the player's name
     * @param position
     *            the player's position
     * @param statistic
     *            the player's statistic
     * @requires position is among the following: {PG, SG, SF, PF, C}
     * @ensures this = #this with (name, position, statistic) added to the
     *          lineup
     */
    void addPlayer(String name, String position, double statistic);

    /**
     * Removes a player from the lineup.
     *
     * @param name
     *            the player's name
     * @param position
     *            the player's position
     * @requires both (name, position) in this
     * @ensures this = #this with (name, position) removed from the lineup
     */
    void removePlayer(String name, String position);

    /**
     * Substitutes a player in the lineup with a bench player.
     *
     * @param name
     *            the subbed out player's name
     * @param position
     *            the player's position
     * @param newName
     *            the entering player's name
     * @param newStatistic
     *            the new player's statistic
     * @requires name exists in this at position
     * @ensures this = #this with (name, position) replaced by (newName,
     *          position)
     */
    void subPlayer(String name, String position, String newName,
            double newStatistic);

    /**
     * Returns how many players are in the lineup currently.
     *
     * @return the amount of players in the lineup
     * @ensures size = |this|
     */
    int size();
}