package factorymethod._01_before;

import factorymethod.Airplane;
import factorymethod.Truck;
import factorymethod.Vehicle;

public class TransportFactory {

    void transport(String vehicleType, String name, String address) {
        validate(name, address);
        Vehicle vehicle = chooseVehicle(vehicleType);
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

    Vehicle chooseVehicle(String vehicleType){
        if (vehicleType.equals("Truck")) {
            return new Truck();
        }
        if (vehicleType.equals("Airplane")) {
            return new Airplane();
        }
        throw new IllegalArgumentException("지원하지 않는 운송수단입니다.");
    }


    private void doTransport(String name, String address, Vehicle vehicle){
        System.out.println("고객님 성함 : " + name + " | 운송 방법 : " + vehicle.getType() + " | 운송 주소 : " + address);
    };


}
