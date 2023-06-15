package factorymethod._02_after;

import factorymethod.Vehicle;

public interface TransportFactory {

    default void transport(String name, String address) {
        validate(name, address);
        Vehicle vehicle = chooseVehicle();
        doTransport(name, address, vehicle);
    }

    private void validate(String name, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("주문자 성함을 기입해주세요");
        }
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("주소를 남겨주세요");
        }
    }

    Vehicle chooseVehicle();

    private void doTransport(String name, String address, Vehicle vehicle){
        System.out.println("고객님 성함 : " + name + " | 운송 방법 : " + vehicle.getType() + " | 운송 주소 : " + address);
    };


}
