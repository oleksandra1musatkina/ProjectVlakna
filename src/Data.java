public class Data {
    private int packet;

    private boolean transfer = true;

    public synchronized void send(int packet) {
        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        transfer = false;

        this.packet = packet;
        notifyAll();
    }

    public synchronized int receive() {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        transfer = true;

        notifyAll();
        return packet;
    }
}