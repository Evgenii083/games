import java.util.Comparator;

public class StrengthComparator implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        if (o1.getStrength() > o2.getStrength()) {
            return 1;
        } else if (o1.getStrength() < o2.getStrength()) {
            return -1;
        } else {
            return 0;
        }
    }
}
