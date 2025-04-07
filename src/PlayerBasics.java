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