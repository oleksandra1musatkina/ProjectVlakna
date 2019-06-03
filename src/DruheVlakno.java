public class DruheVlakno implements Runnable {
    private Data load;

    public DruheVlakno(Data load) {
        this.load = load;
    }

    public void run() {
        for(int receivedMessage = load.receive();
            !(receivedMessage==0);
            receivedMessage = load.receive()) {

            System.out.print(receivedMessage+" ");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }

    }
}