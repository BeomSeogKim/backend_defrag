package factorymethod._02_after;

import factorymethod.Airplane;
import factorymethod.Vehicle;

public class AirplaneTransportFactory implements TransportFactory{
    @Override
    public Vehicle chooseVehicle() {
        return new Airplane();
    }
}
