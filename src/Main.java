public class Main {

    public static void main(String[] args) {
        Data data = new Data();
        Thread sender = new Thread(new PrveVlakno(data));
        Thread receiver = new Thread(new DruheVlakno(data));

        receiver.start();
        sender.start();
    }
}
