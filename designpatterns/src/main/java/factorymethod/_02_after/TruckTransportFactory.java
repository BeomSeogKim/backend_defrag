package factorymethod._02_after;

import factorymethod.Truck;
import factorymethod.Vehicle;

public class TruckTransportFactory implements TransportFactory{
    @Override
    public Vehicle chooseVehicle() {
        return new Truck();
    }
}
