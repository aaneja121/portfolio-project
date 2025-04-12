import java.util.Iterator;

public abstract class LineupComponentSecondary extends LineupComponent {
    @Override
    public final void makeBest() {
        Iterator<String> posIterator = this.positions();
        while (posIterator.hasNext()) {
            String pos = posIterator.next();
            Iterator<PlayerBasics> players = this.playersAt(pos);

            if (players.hasNext()) {
                PlayerBasics best = players.next();
                while (players.hasNext()) {
                    PlayerBasics current = players.next();
                    if (current.getStatistic() > best.getStatistic()) {
                        best = current;
                    }
                }
                System.out.println(pos + ": " + best);
            } else {
                System.out.println(
                        pos + ": You have no players at this position.");
            }
        }
    }

    @Override
    public final void displayLineup() {
        Iterator<String> posIterator = this.positions();
        while (posIterator.hasNext()) {
            String pos = posIterator.next();
            Iterator<PlayerBasics> players = this.playersAt(pos);
            System.out.print(pos + ": ");
            while (players.hasNext()) {
                System.out.print(players.next() + ", ");
            }
            System.out.println();
        }
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> posIterator = this.positions();
        while (posIterator.hasNext()) {
            String pos = posIterator.next();
            Iterator<PlayerBasics> players = this.playersAt(pos);
            while (players.hasNext()) {
                sb.append(players.next().toString()).append("\n");
            }
        }
        return sb.toString().trim();
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj instanceof LineupComponent) {
            LineupComponent other = (LineupComponent) obj;
            if (this.size() != other.size()) {
                return false;
            }
            Iterator<String> posIterator = this.positions();
            while (posIterator.hasNext()) {
                String pos = posIterator.next();
                Iterator<PlayerBasics> thisPlayers = this.playersAt(pos);
                Iterator<PlayerBasics> otherPlayers = other.playersAt(pos);
                while (thisPlayers.hasNext() && otherPlayers.hasNext()) {
                    if (!thisPlayers.next().equals(otherPlayers.next())) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

}
