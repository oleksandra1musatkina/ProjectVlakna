import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrveVlakno implements Runnable {
    private Data data;

    public PrveVlakno(Data data) {
        this.data = data;
    }

    public void run() {
        Integer numbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> l = new ArrayList<>(Arrays.asList(numbers));
        Collections.shuffle(l);
        l.add(0);
        for (int packet : l) {
            data.send(packet);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}