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
    private static String[] pos = { "PG", "SG", "SF", "PF", "C" };
    private Map<String, List<Player>> team;

    public LineupComponent() {

    }

    public void addPlayer(String name, String pos, double statistic) {

    }

    public void removePlayer(String name, String pos) {

    }

    public void subPlayer(String name, String pos, String newName,
            double newStatistic) {

    }

    public int size() {

    }

    public void makeBest() {

    }

    public static void main(String[] args) {
        LineupComponent lineup = new LineupComponent();

        // Here is where I'll input the starting lineup for the Cavs (I'm a Cavs fan)

        // Here is where I'll generate the best lineup for the Cavs.
        lineup.makeBest();

        // Here is where I'll sub out players for other players

    }
}