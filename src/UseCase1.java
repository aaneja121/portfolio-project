public class UseCase1 {

    private LineupComponent lineup;

    public UseCase1() {
        this.lineup = new LineupComponent();

        this.lineup.addPlayer("Darius Garland", "PG", 20.6);
        this.lineup.addPlayer("Donovan Mitchell", "SG", 24.0);
        this.lineup.addPlayer("De'Andre Hunter", "SF", 14.3);
        this.lineup.addPlayer("Evan Mobley", "PF", 18.5);
        this.lineup.addPlayer("Jarrett Allen", "C", 13.5);

        this.lineup.addPlayer("Ty Jerome", "PG", 12.5);
        this.lineup.addPlayer("Max Strus", "SG", 9.4);
        this.lineup.addPlayer("Isaac Okoro", "SF", 6.6);
        this.lineup.addPlayer("Dean Wade", "PF", 5.2);
        this.lineup.addPlayer("Tristan Thompson", "C", 2.7);
    }

    public void printBestLineup() {
        this.lineup.makeBest();
    }

    public static void main(String[] args) {
        UseCase1 optimizer = new UseCase1();
        optimizer.printBestLineup();
    }
}