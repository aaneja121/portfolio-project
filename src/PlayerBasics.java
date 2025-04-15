public final class PlayerBasics {
    private String name;
    private String position;
    private double statistic;

    public PlayerBasics(String name, String position, double statistic) {
        this.name = name;
        this.position = position;
        this.statistic = statistic;
    }

    public String name() {
        return this.name;
    }

    public String position() {
        return this.position;
    }

    public double statistic() {
        return this.statistic;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.position + ") - Statistic: "
                + this.statistic;
    }
}