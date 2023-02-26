package JobScheduling;

import java.util.Comparator;

public class Compare implements Comparator<Model> {
    public Compare() {
    }

    public int compare(Model o1, Model o2) {
        if (o1.getProfit() < o2.getProfit()) {
            return 1;
        } else {
            return o1.getProfit() > o2.getProfit() ? -1 : 0;
        }
    }

}