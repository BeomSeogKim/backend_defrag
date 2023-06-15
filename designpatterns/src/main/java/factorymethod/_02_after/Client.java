package factorymethod._02_after;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        client.print(new TruckTransportFactory());
        client.print(new AirplaneTransportFactory());
    }

    private void print(TransportFactory transportFactory) {
        transportFactory.transport("Tommy", "경기도 고양시 일산동구");
    }
}
