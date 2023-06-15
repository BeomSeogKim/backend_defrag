package factorymethod._01_before;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        client.print(new TransportFactory());
    }

    private void print(TransportFactory transportFactory) {
        transportFactory.transport("Truck", "Tommy", "경기도 고양시 일산동구");
        transportFactory.transport("Airplane", "Tommy", "경기도 고양시 일산동구");
    }
}
