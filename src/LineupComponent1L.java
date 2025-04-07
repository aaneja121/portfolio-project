import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Convention: - `lineup` has only valid positions, which are: {"PG", "SG",
 * "SF", "PF", "C"}. - Every player has their own PlayerBasics objects, which
 * are their name and position.
 *
 * Correspondence: - `this` is the current starting lineup. - Key-value pairs in
 * `lineup` equates to a position and its current starter.
 */

public class LineupComponent1L extends LineupComponentSecondary {

    private Map<String, List<PlayerBasics>> lineup;

    public LineupComponent1L() {
        this.lineup = new HashMap<>();
        this.lineup.put("PG", new ArrayList<>());
        this.lineup.put("SG", new ArrayList<>());
        this.lineup.put("SF", new ArrayList<>());
        this.lineup.put("PF", new ArrayList<>());
        this.lineup.put("C", new ArrayList<>());
    }

    private boolean isPosition(String pos) {
        for (String p : positions) {
            if (p.equals(pos)) {
                return true;
            }
        }
        return false;
    }

    public final void addPlayer(String name, String pos, double statistic) {

        if (this.isPosition(pos)) {
            this.team.get(pos).add(new PlayerBasics(name, pos, statistic));
        } else {
            System.out.println("You entered an invalid position.");
        }

    }

    public final void removePlayer(String name, String pos) {
        if (this.isPosition(pos)) {
            List<PlayerBasics> playerNames = this.team.get(pos);
            for (int i = 0; i < playerNames.size(); i++) {
                if (playerNames.get(i).getName().equals(name)) {
                    playerNames.remove(i);
                    break;
                }
            }
            System.out
                    .println(name + " does not play the " + pos + " position.");
        }

        else {
            System.out.println("You entered the wrong position.");
        }
    }

    public final void subPlayer(String name, String pos, String newName,
            double newStatistic) {
        if (this.isPosition(pos)) {
            List<PlayerBasics> players = this.team.get(pos);
            boolean found = false;

            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getName().equals(name)) {
                    players.remove(i);
                    found = true;
                    break;
                }
            }

            if (found) {
                players.add(new PlayerBasics(newName, pos, newStatistic));
            }

            else {
                System.out.println(
                        name + " does not play the " + pos + " position.");
            }
        }

        else {
            System.out.println("You entered the wrong position.");
        }

    }

    public final int size() {
        int playerCount = 0;
        for (String pos : positions) {
            playerCount += this.team.get(pos).size();
        }
        return playerCount;
    }

    public final void makeBest() {
        Map<String, PlayerBasics> best = new HashMap<>();
        for (String pos : positions) {
            List<PlayerBasics> players = this.team.get(pos);

            if (!players.isEmpty()) {
                PlayerBasics bestPlayer = players.get(0);
                for (PlayerBasics p : players) {
                    if (p.getStatistic() > bestPlayer.getStatistic()) {
                        bestPlayer = p;
                    }
                }
                best.put(pos, bestPlayer);
            }
        }

        System.out.println("The best lineup based on points: ");
        for (String pos : positions) {
            if (best.containsKey(pos)) {
                System.out.println(best.get(pos));
            } else {
                System.out.println(
                        pos + ": You have no players at this position");
            }
        }
    }

}
