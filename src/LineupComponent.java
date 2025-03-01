import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerBasics {
    private String name;
    private String position;
    private double statistic;

    public PlayerBasics(String name, String position, double statistic) {
        this.name = name;
        this.position = position;
        this.statistic = statistic;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPosition() {
        return this.position;
    }

    public final double getStatistic() {
        return this.statistic;
    }

    @Override
    public final String toString() {
        return this.name + " (" + this.position + ") - Statistic: "
                + this.statistic;
    }
}

public class LineupComponent {
    private final static String[] positions = { "PG", "SG", "SF", "PF", "C" };
    private Map<String, List<PlayerBasics>> team;

    public LineupComponent() {
        this.team = new HashMap<>();
        for (String pos : positions) {
            this.team.put(pos, new ArrayList<>());
        }
    }

    private boolean isPosition(String pos) {
        for (String p : positions) {
            if (p.equals(pos)) {
                return true;
            }
        }
        return false;
    }

    public void addPlayer(String name, String pos, double statistic) {

        if (this.isPosition(pos)) {
            this.team.get(pos).add(new PlayerBasics(name, pos, statistic));
        } else {
            System.out.println("You entered an invalid position.");
        }

    }

    public void removePlayer(String name, String pos) {
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

    public void subPlayer(String name, String pos, String newName,
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

    public int size() {
        int playerCount = 0;
        for (String pos : positions) {
            playerCount += this.team.get(pos).size();
        }
        return playerCount;
    }

    public void makeBest() {
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

    public static void main(String[] args) {
        LineupComponent lineup = new LineupComponent();

        // Here is where I'll input the starting lineup for the Cavs (I'm a Cavs fan)
        lineup.addPlayer("Darius Garland", "PG", 21.3);
        lineup.addPlayer("Donovan Mitchell", "SG", 24.3);
        lineup.addPlayer("Isaac Okoro", "SF", 5.3);
        lineup.addPlayer("Dean Wade", "PF", 5.7);
        lineup.addPlayer("Tristan Thompson", "PF", 1.6);
        lineup.addPlayer("Ty Jerome", "SG", 11.8);

        // Here is where I'll generate the best lineup for the Cavs.
        lineup.makeBest();

        // Here is where I'll sub out players for other players
        lineup.subPlayer("Dean Wade", "PF", "Emoni Bates", 0.9);

    }
}