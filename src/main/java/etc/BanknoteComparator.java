package etc;

import java.util.Comparator;

public class BanknoteComparator implements Comparator<Banknote> {

    public int compare(Banknote o1, Banknote o2) {

        if (o1.getDenomination() < o2.getDenomination()) {
            return 1;
        }
        if (o1.getDenomination() > o2.getDenomination()) {
            return -1;
        }
        return 0;
    }
}
