public class UseCase2 {

    private LineupComponent lineup;

    public UseCase2() {
        this.lineup = new LineupComponent();

        this.lineup.addPlayer("Darius Garland", "PG", 20.6);
        this.lineup.addPlayer("Donovan Mitchell", "SG", 24.0);
        this.lineup.addPlayer("De'Andre Hunter", "SF", 14.3);
        this.lineup.addPlayer("Evan Mobley", "PF", 18.5);
        this.lineup.addPlayer("Jarrett Allen", "C", 13.5);

        this.lineup.addPlayer("Max Strus", "SG", 9.4);
    }

    public void performSubstitution() {
        this.lineup.subPlayer("Donovan Mitchell", "SG", "Max Strus", 9.4);
    }

    public void displayLineup() {
        this.lineup.makeBest();
    }

    public static void main(String[] args) {
        UseCase2 sub = new UseCase2();
        System.out.println("Pre-Substitution:");
        sub.displayLineup();

        sub.performSubstitution();
        System.out.println("\nPost-Substitution:");
        sub.displayLineup();
    }
}
